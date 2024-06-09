package br.com.dio.desafio.conteudos;

import java.time.LocalDate;
import br.com.dio.desafio.dominio.Mentoria;

public class Mentorias {
  public static Mentoria mentoriaJava() {
    Mentoria mentoriaJava = new Mentoria();
    mentoriaJava.setTitulo("Mentoria Individualizada em Java: Alcance seus Objetivos de Carreira");
    mentoriaJava.setDescricao(
        "Receba orientação personalizada de um especialista em Java para aprimorar suas habilidades, solucionar dúvidas e construir um plano de carreira de sucesso.");
    mentoriaJava.setData(LocalDate.now());
    mentoriaJava.setInstrutor("Roberto Lima");
    return mentoriaJava;
  }
}
