package banco.Sistema;

import java.util.Scanner;
import java.util.Locale;
import banco.Contas.ContaCorrente;
import banco.Contas.ContaPoupanca;

public class Sistema {
	private Scanner sc = new Scanner(System.in).useLocale(Locale.US);

	public void terminal() {
		System.out.println("==========================================");
		System.out.println("    BEM-VINDO AO BANCO **VIRTUS BANK**    ");
		System.out.println("==========================================");
		System.out.println("  OPÇÃO 1 - CONTA POUPANCA                ");
		System.out.println("  OPÇÃO 2 - CONTA CORRENTE                ");
		System.out.println("  OPÇÃO 0 - SAIR                          ");
		System.out.println("==========================================");

		int operacao;
		do {
			System.out.print("Digite a operação desejada: ");
			operacao = sc.nextInt();

			switch (operacao) {
				case 1:
					ContaPoupanca cp = new ContaPoupanca();
					cp.contaPoupanca();
					break;
				case 2:
					ContaCorrente cc = new ContaCorrente();
					cc.contaCorrente();
					break;
				case 0:
					System.out.println("Saindo do sistema...");
					break;
				default:
					System.out.println("Operação inválida. Tente novamente.");
			}
		} while (operacao != 0);
	}
}