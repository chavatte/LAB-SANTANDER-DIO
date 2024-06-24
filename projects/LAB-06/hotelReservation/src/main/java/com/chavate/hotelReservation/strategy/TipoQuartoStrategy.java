package com.chavate.hotelReservation.strategy;

import com.chavate.hotelReservation.model.Quarto;
import com.chavate.hotelReservation.model.Reserva;

public interface TipoQuartoStrategy {
    double calcularPreco(Quarto quarto, Reserva reserva);
}