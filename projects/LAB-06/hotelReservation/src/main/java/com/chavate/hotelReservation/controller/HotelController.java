package com.chavate.hotelReservation.controller;

import com.chavate.hotelReservation.dto.QuartoDisponivelDTO;
import com.chavate.hotelReservation.dto.ReservaDTO;
import com.chavate.hotelReservation.facade.HotelFacade;
import com.chavate.hotelReservation.model.Quarto;
import com.chavate.hotelReservation.model.Reserva;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hotel")
@Tag(name = "Hotel", description = "Operações relacionadas ao hotel")
public class HotelController {

    private final HotelFacade hotelFacade;

    public HotelController(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
    }

    @GetMapping()
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("API do Hotel Reservation");
    }

    @GetMapping("/quartos/disponiveis")
    public ResponseEntity<List<QuartoDisponivelDTO>> buscarQuartosDisponiveis() {
        List<Quarto> quartosDisponiveis = hotelFacade.buscarTodosQuartosDisponiveis();
        List<QuartoDisponivelDTO> quartosDTO = quartosDisponiveis.stream()
                .map(QuartoDisponivelDTO::new)
                .toList();
        return ResponseEntity.ok(quartosDTO);
    }

    @PostMapping("/reservas")
    public ResponseEntity<ReservaDTO> criarReserva(@RequestBody ReservaDTO reservaDTO) {

        hotelFacade.criarReserva(reservaDTO.toEntity());
        return ResponseEntity.ok(reservaDTO);
    }

    @GetMapping("/reservas")
    public ResponseEntity<Map<Quarto.TipoQuarto, List<Reserva>>> buscarReservasPorTipoQuarto() {
        Map<Quarto.TipoQuarto, List<Reserva>> reservasPorTipo = hotelFacade.buscarReservasAgrupadasPorTipoQuarto();
        return ResponseEntity.ok(reservasPorTipo);
    }
}