package banco.Contas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import banco.Clientes.Clientes;
import banco.Sistema.Sistema;

public class Contas implements ContasInter {
	private static final Random random = new Random();
	private Scanner sc = new Scanner(System.in);
	private Sistema recursos = new Sistema();
	private List<Clientes> clientesList = new ArrayList<>();

	protected int numero;
	protected int agencia;
	protected double saldo;
	protected Clientes cliente;

	public Contas() {
		this.agencia = gerarNumeroAgencia();
		this.numero = gerarNumeroConta();
	}

	private int gerarNumeroAgencia() {
		return 1000 + random.nextInt(90);
	}

	private int gerarNumeroConta() {
		return 100000 + random.nextInt(900000);
	}

	protected void criarConta() {
		System.out.println("Digite seu nome: ");
		String nome = sc.next();

		Clientes cliente = new Clientes();
		cliente.setName(nome);
		cliente.setNumero(getNumero());
		this.cliente = cliente;
		this.numero = cliente.getNumero();
		clientesList.add(cliente);
		voltar();

	}

	@Override
	public void depositar() {
		System.out.println("Valor de depósito: ");
		double valorDeposito = sc.nextDouble();
		this.saldo += valorDeposito;
		voltar();

	}

	@Override
	public void sacar() {
		System.out.println("Valor de saque: ");
		double valorSaque = sc.nextDouble();
		if (getSaldo() != 0) {
			this.saldo -= valorSaque;
		} else {
			System.out.println("Saldo Insuficiente");
		}
		voltar();
	}

	@Override
	public void transferencia() {
		System.out.println("Agência destino: ");
		int agenciaDestino = sc.nextInt();

		System.out.println("Conta destino: ");
		int contaDestino = sc.nextInt();

		if (existeContaDestino(contaDestino, agenciaDestino)) {

		}

		System.out.println("Valor de transferência: ");
		double valorTransferir = sc.nextDouble();
		this.saldo -= valorTransferir;
		voltar();
	}

	private boolean existeContaDestino(int numeroConta, int agenciaDestino) {
		for (Clientes clientes : clientesList) {
			System.out.println("Validando ...");
			if (clientes.getNumero() == numeroConta && getAgencia() == agenciaDestino) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=========================================");
		System.out.println("             **VIRTUS BANK**             ");
		System.out.println("             ****EXTRATO****             ");
		System.out.println("=========================================");
		System.out.println(String.format("Titular: %s", cliente.getName()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %05d-%d", this.numero / 10, this.numero % 10));
		System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
		System.out.println("=========================================");
		voltar();
	}

	private void voltar() {
		caixaEletronico();
	}

	protected void caixaEletronico() {
		System.out.println("=========================================");
		System.out.println("             **VIRTUS BANK**             ");
		System.out.println("=========================================");
		System.out.println("  OPÇÃO 1 - DEPOSITO                     ");
		System.out.println("  OPÇÃO 2 - SACAR                        ");
		System.out.println("  OPÇÃO 3 - TRANSFERIR                   ");
		System.out.println("  OPÇÃO 4 - EXTRATO                      ");
		System.out.println("  OPÇÃO 5 - VOLTAR                       ");
		System.out.println("  OPÇÃO 0 - ENCERRAR                     ");
		System.out.println("=========================================");

		int operacao;
		do {
			System.out.print("Digite a operação desejada: ");
			operacao = sc.nextInt();

			switch (operacao) {
				case 1:
					depositar();
					break;
				case 2:
					sacar();
					break;
				case 3:
					transferencia();
					break;
				case 4:
					imprimirExtrato();
					break;
				case 5:
					recursos.terminal();
					break;
				case 0:
					System.out.println("Operações encerradas");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Operação inválida. Tente novamente.");
			}
		} while (operacao != 0);
	}

	public int getNumero() {
		return numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}
}