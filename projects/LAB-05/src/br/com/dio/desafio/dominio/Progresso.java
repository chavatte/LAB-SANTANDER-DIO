package br.com.dio.desafio.dominio;

public class Progresso {

  public static void exibirProgressoDev(Dev dev) {
    System.out.println("********************************************************");
    System.out.println(" Dev: " + dev.getNome() + "\n");
    System.out.println(" Trilha de Aprendizado Atual:\n");
    dev.getConteudosInscritos().forEach(conteudo -> {
      System.out.println("--> " + conteudo.getTitulo() + "\n");
    });

    System.out.println(" Trilha de Aprendizado Concluida:\n");
    dev.getConteudosConcluidos().forEach(conteudo -> {
      System.out.println("--> " + conteudo.getTitulo() + "\n");
    });
    System.out.println(" XP Total: " + dev.calcularTotalXp());
    System.out.println("********************************************************");
  }
}