package com.chavate.hotelReservation.strategy;

import com.chavate.hotelReservation.model.Quarto;
import com.chavate.hotelReservation.model.Reserva;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class StandardQuartoStrategy implements TipoQuartoStrategy {

    private static final double PRECO_DIARIA = 300.0;
    private static final double DESCONTO_ACIMA_DOIS_DIAS = 0.8;

    @Override
    public double calcularPreco(Quarto quarto, Reserva reserva) {
        long numeroDias = ChronoUnit.DAYS.between(reserva.getDataEntrada(), reserva.getDataSaida());

        if (numeroDias > 2) {
            return numeroDias * PRECO_DIARIA * DESCONTO_ACIMA_DOIS_DIAS;
        } else {
            return numeroDias * PRECO_DIARIA;
        }
    }
}