package celular.Telefone;

import celular.Menu.Menu;
import java.util.HashMap;
import java.util.Map;

public class Telefone extends Menu implements ComportamentosTelefone, Runnable {

    private Map<String, String> contato;

    public Telefone() {
        this.contato = new HashMap<>();
        this.contato.put("João Carlos", "123456789");
        this.contato.put("Mariana", "987654321");
        this.contato.put("Vicente", "555123456");
    }

    public void Telefone() throws InterruptedException {
        System.out.println("\nAguarde...\n");
        Thread.sleep(1000);
        System.out.println("\nSelecione uma opção:\n");
        System.out.println("1. Acessar agenda");
        System.out.println("2. Fazer chamada");
        System.out.println("3. Acessar caixa postal");
        System.out.println("0. Sair");
        int opcao = Integer.parseInt(System.console().readLine());
        switch (opcao) {
            case 1:
                acessarAgenda();
                Telefone();
                break;
            case 2:
                fazerChamada();
                Telefone();
                break;
            case 3:
                acessarCaixaPostal();
                Telefone();
                break;
            case 0:
                desligar();
                celular();
                break;
            default:
                System.out.println("\nOpção inválida.\n");
        }
    }

    private void acessarAgenda() {
        while (true) {
            System.out.println("\nAgenda:\n");
            System.out.println("1. Listar contatos");
            System.out.println("2. Adicionar contato");
            System.out.println("0. Voltar");
            int opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    listarContatos();
                    break;
                case 2:
                    adicionarContato();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\nOpção inválida.\n");
            }
        }
    }

    private void listarContatos() {
        System.out.println("\nContatos:\n");
        for (Map.Entry<String, String> entry : contato.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private void adicionarContato() {
        System.out.println("\nAdicionar contato:\n");
        System.out.println("Digite o nome do contato: ");
        String nome = System.console().readLine();
        System.out.println("Digite o número do contato: ");
        String numero = System.console().readLine();
        contato.put(nome, numero);
        System.out.println("\nContato adicionado com sucesso!\n");
    }

    private void fazerChamada() throws InterruptedException {
        System.out.println("\nDigite o nome do contato: ");
        String nome = System.console().readLine();
        if (contato.containsKey(nome)) {
            atender();
            Thread.sleep(2500);
            System.out.println("\nChamando " + nome + "...\n");
            Thread.sleep(1000);
            System.out.println("\nChamada em andamento com " + nome + "\n");
            Thread.sleep(3500);
            desligar();
        } else {
            System.out.println("\nContato não encontrado.\n");
        }
    }

    public void acessarCaixaPostal() {
        System.out.println("\nCaixa postal:\n");
        System.out.println("No momento você não tem nenhuma mensagem.\n");
    }

    @Override
    public void atender() {
        System.out.println("\nChamando...\n");
    }

    public void desligar() {
        System.out.println("\nChamada encerrada.\n");
    }

    @Override
    public void run() {
    }
}