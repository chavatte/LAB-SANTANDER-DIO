package com.chavate.hotelReservation.dto;

import com.chavate.hotelReservation.model.Cliente;
import com.chavate.hotelReservation.model.Quarto;
import com.chavate.hotelReservation.model.Reserva;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaDTO {
    private Long quartoId;
    private Long clienteId;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public Reserva toEntity() {
        Quarto quarto = new Quarto(null, 0, 0.0, false);
        quarto.setId(quartoId);

        Cliente cliente = new Cliente();
        cliente.setId(clienteId);

        Reserva reserva = new Reserva();
        reserva.setQuarto(quarto);
        reserva.setCliente(cliente);
        reserva.setDataEntrada(dataEntrada);
        reserva.setDataSaida(dataSaida);
        return reserva;
    }
}