package br.com.dio.desafio.conteudos;

import br.com.dio.desafio.dominio.Curso;

public class Cursos {
  public static Curso cursoJava1() {
    Curso cursoJava1 = new Curso();
    cursoJava1.setTitulo("Java Essencial: Do Zero ao Programador");
    cursoJava1.setDescricao(
        "Domine os fundamentos da linguagem Java, desde sintaxe básica até orientação a objetos, e construa seus primeiros programas.");
    cursoJava1.setCargaHoraria(20);
    cursoJava1.setInstrutor("Ana Souza");
    cursoJava1.setNivel("Básico");
    return cursoJava1;
  }

  public static Curso cursoJava2() {
    Curso cursoJava2 = new Curso();
    cursoJava2.setTitulo("Java Avançado: Mergulho em APIs e Frameworks");
    cursoJava2.setDescricao(
        "Explore as principais APIs do Java, como Collections e Streams, e utilize frameworks populares como Spring Boot para criar aplicações web robustas.");
    cursoJava2.setCargaHoraria(30);
    cursoJava2.setInstrutor("Carlos Oliveira");
    cursoJava2.setNivel("Avançado");
    return cursoJava2;
  }

  public static Curso cursoJava3() {
    Curso cursoJava3 = new Curso();
    cursoJava3.setTitulo("Desenvolvimento Web com Java: Do Back-end ao Front-end");
    cursoJava3.setDescricao(
        "Aprenda a construir aplicações web completas com Java, utilizando tecnologias como Servlets, JSP e frameworks front-end como React ou Angular.");
    cursoJava3.setCargaHoraria(40);
    cursoJava3.setInstrutor("Maria Silva");
    cursoJava3.setNivel("Intermediário");
    return cursoJava3;
  }

  public static Curso cursoJava4() {
    Curso cursoJava4 = new Curso();
    cursoJava4.setTitulo("Java para Dispositivos Móveis: Crie Apps Android Nativos");
    cursoJava4.setDescricao(
        "Desenvolva aplicativos Android nativos com Java, utilizando o Android Studio e as principais ferramentas do ecossistema Android.");
    cursoJava4.setCargaHoraria(35);
    cursoJava4.setInstrutor("Pedro Alves");
    cursoJava4.setNivel("Intermediário");
    return cursoJava4;
  }

  public static Curso cursoJava5() {
    Curso cursoJava5 = new Curso();
    cursoJava5.setTitulo("Testes Automatizados em Java: Garanta a Qualidade do Seu Código");
    cursoJava5.setDescricao(
        "Domine as principais técnicas de testes automatizados em Java, utilizando frameworks como JUnit e Mockito, e escreva código mais confiável.");
    cursoJava5.setCargaHoraria(15);
    cursoJava5.setInstrutor("Laura Santos");
    cursoJava5.setNivel("Intermediário");
    return cursoJava5;
  }
}
