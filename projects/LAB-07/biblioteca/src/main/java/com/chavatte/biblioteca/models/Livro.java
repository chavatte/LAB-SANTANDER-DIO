package com.chavatte.biblioteca.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(unique = true)
    private String isbn;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private int quantidadeEmEstoque;

    @Column(nullable = false)
    private int exemplaresEmprestados;
}
