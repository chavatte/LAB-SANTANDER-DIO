package com.chavate.hotelReservation.service;

import com.chavate.hotelReservation.model.Quarto;
import com.chavate.hotelReservation.model.Reserva;
import com.chavate.hotelReservation.repository.QuartoRepository;
import com.chavate.hotelReservation.repository.ReservaRepository;
import com.chavate.hotelReservation.strategy.LuxoQuartoStrategy;
import com.chavate.hotelReservation.strategy.StandardQuartoStrategy;
import com.chavate.hotelReservation.strategy.SuiteQuartoStrategy;
import com.chavate.hotelReservation.strategy.TipoQuartoStrategy;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {

    private final QuartoRepository quartoRepository;
    private final ReservaRepository reservaRepository;
    private final Map<Quarto.TipoQuarto, TipoQuartoStrategy> estrategias;

    public HotelService(QuartoRepository quartoRepository, ReservaRepository reservaRepository,
            List<TipoQuartoStrategy> estrategias) {
        this.quartoRepository = quartoRepository;
        this.reservaRepository = reservaRepository;
        this.estrategias = new EnumMap<>(Quarto.TipoQuarto.class);

        for (TipoQuartoStrategy estrategia : estrategias) {
            if (estrategia instanceof StandardQuartoStrategy) {
                this.estrategias.put(Quarto.TipoQuarto.STANDARD, estrategia);
            } else if (estrategia instanceof LuxoQuartoStrategy) {
                this.estrategias.put(Quarto.TipoQuarto.LUXO, estrategia);
            } else if (estrategia instanceof SuiteQuartoStrategy) {
                this.estrategias.put(Quarto.TipoQuarto.SUITE, estrategia);
            }
        }
    }

    public List<Quarto> buscarTodosQuartosDisponiveis() {
        return quartoRepository.findByDisponivel(true);
    }

    public List<Quarto> buscarQuartosDisponiveis(Quarto.TipoQuarto tipoQuarto, LocalDate dataEntrada,
            LocalDate dataSaida) {
        List<Long> idsQuartosOcupados = reservaRepository.findIdsQuartosOcupadosNoPeriodo(dataEntrada, dataSaida);
        return quartoRepository.findByTipoQuartoAndDisponivelAndIdNotIn(tipoQuarto, true, idsQuartosOcupados);
    }

    public double calcularPrecoReserva(Quarto quarto, Reserva reserva) {
        return estrategias.get(quarto.getTipoQuarto()).calcularPreco(quarto, reserva);
    }

    public void criarReserva(Reserva reserva) {
        if (reserva == null || reserva.getQuarto() == null || reserva.getCliente() == null) {
            throw new IllegalArgumentException("Dados da reserva inválidos");
        }

        Quarto quarto = quartoRepository.findById(reserva.getQuarto().getId())
                .orElseThrow(() -> new EntityNotFoundException("Quarto não encontrado"));

        List<Long> idsQuartosOcupados = new ArrayList<>();
        idsQuartosOcupados.add(quarto.getId());

        boolean quartoDisponivel = quartoRepository.findByDisponivelAndIdNotIn(
                true,
                idsQuartosOcupados,
                reserva.getDataEntrada(),
                reserva.getDataSaida()).isEmpty();

        if (!quartoDisponivel) {
            throw new IllegalStateException("Quarto não disponível para o período selecionado.");
        }

        quarto.setDisponivel(false);
        quartoRepository.save(quarto);

        reserva.setQuarto(quarto);
        reservaRepository.save(reserva);
    }

    public Map<Quarto.TipoQuarto, List<Reserva>> buscarReservasAgrupadasPorTipoQuarto() {
        List<Reserva> todasReservas = reservaRepository.findAll();

        Map<Quarto.TipoQuarto, List<Reserva>> reservasPorTipo = new EnumMap<>(Quarto.TipoQuarto.class);
        for (Quarto.TipoQuarto tipo : Quarto.TipoQuarto.values()) {
            reservasPorTipo.put(tipo, new ArrayList<>());
        }

        LocalDate hoje = LocalDate.now();
        for (Reserva reserva : todasReservas) {
            Quarto.TipoQuarto tipoQuarto = reserva.getQuarto().getTipoQuarto();
            if (reserva.getDataSaida().isBefore(hoje)) {
                reservasPorTipo.get(tipoQuarto).add(reserva);
            } else if (reserva.getDataEntrada().isAfter(hoje)) {
                reservasPorTipo.get(tipoQuarto).add(reserva);
            }
        }

        return reservasPorTipo;
    }
}