package com.chavate.hotelReservation.facade;

import com.chavate.hotelReservation.model.Quarto;
import com.chavate.hotelReservation.model.Reserva;
import com.chavate.hotelReservation.service.HotelService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class HotelFacade {

    private final HotelService hotelService;

    public HotelFacade(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public List<Quarto> buscarTodosQuartosDisponiveis() {
        return hotelService.buscarTodosQuartosDisponiveis();
    }

    public double calcularPrecoReserva(Quarto quarto, Reserva reserva) {
        return hotelService.calcularPrecoReserva(quarto, reserva);
    }

    public void criarReserva(Reserva reserva) {
        hotelService.criarReserva(reserva);
    }

    public Map<Quarto.TipoQuarto, List<Reserva>> buscarReservasAgrupadasPorTipoQuarto() {
        return hotelService.buscarReservasAgrupadasPorTipoQuarto();
    }

}
