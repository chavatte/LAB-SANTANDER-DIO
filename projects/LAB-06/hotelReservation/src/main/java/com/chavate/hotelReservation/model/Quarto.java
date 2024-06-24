package com.chavate.hotelReservation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoQuarto tipoQuarto;
    private int numero;
    private double preco;
    private boolean disponivel;

    public Quarto(TipoQuarto tipoQuarto, int numero, double preco, boolean disponivel) {
        this.tipoQuarto = tipoQuarto;
        this.numero = numero;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public enum TipoQuarto {
        STANDARD, LUXO, SUITE
    }
}