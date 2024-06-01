import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.println("==========================================");
            System.out.println(" BEM-VINDO AO BANCO **VIRTUS BANK** ");
            System.out.println("==========================================");

            System.out.print("Nome: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Sobrenome: ");
            String sobrenomeCliente = scanner.nextLine();

            String nomeCompleto = nomeCliente + " " + sobrenomeCliente;

            System.out.print("Agência (com dígito): ");
            String agencia = scanner.next();

            System.out.print("Número da conta: ");
            int numero = scanner.nextInt();

            System.out.print("Valor do depósito inicial: ");
            double saldo = scanner.nextDouble();

            System.out.println("\n==========================================");
            System.out.println(" CONTA CRIADA COM SUCESSO! ");
            System.out.println("==========================================");
            System.out.println("Titular: " + nomeCompleto);
            System.out.println("Agência: " + agencia);
            System.out.println("Conta: " + numero);
            System.out.printf("Saldo inicial: R$ %.2f\n", saldo);
            System.out.println("==========================================");
            System.out.println("Obrigado por criar uma conta em nosso banco! \n Seu saldo já está disponível para saque!");
        }

        System.out.println("==========================================");
    }
}
