package celular.ReprodutorMusical;

import java.util.Scanner;
import celular.Menu.Menu;

public class Reprodutor extends Menu implements ComportamentosReprodutor, Runnable {

	private Scanner sc = new Scanner(System.in);
	private int musicaAtual = -1;
	private boolean tocando = false;

	String[][] musicas = {
			{ "Stairway to Heaven", "Led Zeppelin" },
			{ "Bohemian Rhapsody", "Queen" },
			{ "Smells Like Teen Spirit", "Nirvana" },
			{ "Sweet Child o' Mine", "Guns N' Roses" },
			{ "Another Brick in the Wall, Pt. 2", "Pink Floyd" },
			{ "Back in Black", "AC/DC" },
			{ "(I Can't Get No) Satisfaction", "The Rolling Stones" },
			{ "Smoke on the Water", "Deep Purple" },
			{ "My Generation", "The Who" },
			{ "Purple Haze", "Jimi Hendrix" }
	};

	@Override
	public void tocar() {
		if (musicaAtual >= 0) {
			System.out.println("\nAguarde!\nCarregando...\n");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.err.println("Erro durante a espera: " + e.getMessage());
			}
			tocando = true;
		} else {
			System.out.println("\nNenhuma música selecionada.\n");
		}
	}

	@Override
	public void pausar() {
		if (tocando) {
			System.out.println("\nMúsica pausada.\n");
			tocando = false;
		} else {
			System.out.println("\nNenhuma música está tocando ou já está pausada.\n");
		}
	}

	@Override
	public void selecionarMusica() throws InterruptedException {
		int opcao;

		do {
			exibirMenuMusicas();
			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao > 0 && opcao <= musicas.length) {
				musicaAtual = opcao - 1;
				tocarMusica();
			} else if (opcao != 0) {
				System.out.println("Opção inválida.");
			}
		} while (opcao != 0);

		celular();
	}

	private void exibirMenuMusicas() {
		System.out.println("\n🎵🎶 MP3 PLAYER 🎶🎵\n");
		System.out.println("\nAguarde!\nBuscando...\n");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.err.println("Erro durante a busca: " + e.getMessage());
		}
		System.out.println("Músicas Disponiveis:");
		for (int i = 0; i < musicas.length; i++) {
			System.out.println((i + 1) + "--> " + musicas[i][0]);
		}
		System.out.println("0 --> Voltar");
		System.out.print("Escolha a música: ");
	}

	private void tocarMusica() throws InterruptedException {
		tocar();
		System.out.println("\nTocando:");
		System.out.println("Música: " + musicas[musicaAtual][0]);
		System.out.println("Artista: " + musicas[musicaAtual][1]);

		for (int i = 0; i < 10 && tocando; i++) {
			Thread.sleep(1000);
			System.out.print(".");
		}

		if (!tocando) {
			System.out.println("\nMúsica pausada.");
		} else {
			System.out.println("\nFim da música.");
			musicaAtual = -1;
		}
	}

	@Override
	public void run() {
	}
}