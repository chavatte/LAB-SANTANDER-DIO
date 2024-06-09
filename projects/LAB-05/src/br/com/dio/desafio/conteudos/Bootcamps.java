package br.com.dio.desafio.conteudos;

import br.com.dio.desafio.dominio.Bootcamp;

public class Bootcamps {
  public static Bootcamp bootcamp() {
    Bootcamp bootcamp = new Bootcamp();
    bootcamp.setNome("Santander 2024 - Backend com Java");
    bootcamp.setDescricao(
            "Boas-vindas à trilha de Back-end Java do Santander Bootcamp 2024!\n" +
            "Aprenda desde os primeiros passos com Java partindo da sintaxe básica até a implementação\n" +
            "de uma API utilizando Spring para se tornar um profissional atrativo no mercado.\n"
            );
    bootcamp.getConteudos().add(Cursos.cursoJava1());
    bootcamp.getConteudos().add(Cursos.cursoJava2());
    bootcamp.getConteudos().add(Cursos.cursoJava3());
    bootcamp.getConteudos().add(Cursos.cursoJava4());
    bootcamp.getConteudos().add(Cursos.cursoJava5());
    bootcamp.getConteudos().add(Mentorias.mentoriaJava());
    bootcamp.getConteudos().add(DesafioDeProjetos.projetoJava());
    return bootcamp;
  }
}
