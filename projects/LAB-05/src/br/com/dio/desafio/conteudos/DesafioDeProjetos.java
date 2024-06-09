package br.com.dio.desafio.conteudos;

import br.com.dio.desafio.dominio.DesafioDeProjeto;

public class DesafioDeProjetos {
  public static DesafioDeProjeto projetoJava() {
    DesafioDeProjeto projetoJava = new DesafioDeProjeto();
    projetoJava.setTitulo("Construa um Sistema de Gerenciamento de Biblioteca com Java");
    projetoJava.setDescricao(
            "Desenvolva um sistema completo para gerenciar livros, autores, usuários e empréstimos em uma biblioteca, utilizando Java, orientação a objetos, persistência de dados (JDBC ou JPA) e interface gráfica (Swing ou JavaFX).");
    projetoJava.setCargaHoraria(50);
    projetoJava.setInstrutor("Juliana Ferreira");
    projetoJava.setNivel("Avançado");
    return projetoJava;
  }

}
