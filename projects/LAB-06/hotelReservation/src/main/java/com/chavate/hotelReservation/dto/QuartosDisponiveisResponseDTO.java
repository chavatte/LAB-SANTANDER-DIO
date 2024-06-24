package com.chavate.hotelReservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuartosDisponiveisResponseDTO {
    private String mensagem;
    private List<QuartoDisponivelDTO> quartos;
}
