package celular.Navegador;

import java.util.Scanner;
import celular.Menu.Menu;

public class Navegador extends Menu implements ComportamentosNavegador, Runnable {

    private String paginaAtual;

    public void navegar() throws InterruptedException {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o endereço da página (ou '0'(ZERO) para retornar ao menu): ");
            paginaAtual = scanner.nextLine();

            if (paginaAtual.equalsIgnoreCase("0")) {
                System.out.println("Aguarde! \nEncerrando o navegador...\n");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.err.println("Erro durante o encerramento do navegador: " + e.getMessage());
                }
                celular();
                return;
            }
            if (!paginaAtual.startsWith("https://")) {
                paginaAtual = "https://" + paginaAtual;
            }

            exibirPagina();
            Thread.sleep(1000);
            atualizarPagina();
            Thread.sleep(2500);
            System.out.println("Página carregada!\n");
            Thread.sleep(1000);
            adicionarNovaAba();
        }
    }

    @Override
    public void exibirPagina() {
        System.out.println("\nbuscando: " + paginaAtual + "\n");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Nova aba adicionada com: " + paginaAtual + "\n");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("carregando: " + paginaAtual + "\n");
    }

    @Override
    public void run() {
        try {
            navegar();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}