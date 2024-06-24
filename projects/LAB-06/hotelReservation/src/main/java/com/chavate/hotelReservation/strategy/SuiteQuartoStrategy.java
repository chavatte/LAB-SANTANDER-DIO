package com.chavate.hotelReservation.strategy;

import com.chavate.hotelReservation.model.Quarto;
import com.chavate.hotelReservation.model.Reserva;
import org.springframework.stereotype.Component;

@Component
public class SuiteQuartoStrategy implements TipoQuartoStrategy {
    @Override
    public double calcularPreco(Quarto quarto, Reserva reserva) {
        return quarto.getPreco() * 1.5;
    }
}