package br.com.dio.desafio.dominio;

import br.com.dio.desafio.conteudos.Bootcamps;

public class Alunos {
  public static Dev criarDevVicente() {
    Dev devVicente = new Dev();
    devVicente.setNome("Vicente");
    devVicente.inscreverBootcamp(Bootcamps.bootcamp());
    devVicente.progredir();
    devVicente.progredir();
    devVicente.progredir();
    devVicente.progredir();
    return devVicente;
  }

  public static Dev criarDevChavatte() {
    Dev devChavatte = new Dev();
    devChavatte.setNome("João Carlos");
    devChavatte.inscreverBootcamp(Bootcamps.bootcamp());
    devChavatte.progredir();
    devChavatte.progredir();
    devChavatte.progredir();
    devChavatte.progredir();
    devChavatte.progredir();
    devChavatte.progredir();
    return devChavatte;
  }
}
