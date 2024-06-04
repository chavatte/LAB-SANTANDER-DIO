import java.util.Scanner;

public class Contador {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o valor inicial: ");
    int valorInicial = scanner.nextInt();

    System.out.print("Digite o valor final: ");
    int valorFinal = scanner.nextInt();

    try {
      contar(valorInicial, valorFinal);
    } catch (ParametrosInvalidosException e) {
      System.err.println("Erro: " + e.getMessage());
      System.out.println("Por favor, insira um valor final maior que o valor inicial.");
    } finally {
      scanner.close();
    }
  }

  static void contar(int valorInicial, int valorFinal) throws ParametrosInvalidosException {
    if (valorInicial >= valorFinal) {
      throw new ParametrosInvalidosException("O valor final deve ser maior que o valor inicial.");
    }

    System.out.println("\nContagem:");
    for (int i = valorInicial + 1; i <= valorFinal; i++) {
      System.out.printf("Número %d\n", i);
    }
  }
}