package com.chavate.hotelReservation.dto;

import com.chavate.hotelReservation.model.Quarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuartosDisponiveisDTO {
    private String mensagem;
    private List<Quarto> quartos;
}
