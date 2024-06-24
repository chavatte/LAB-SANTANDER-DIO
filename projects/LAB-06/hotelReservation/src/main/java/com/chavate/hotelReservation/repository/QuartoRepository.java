package com.chavate.hotelReservation.repository;

import com.chavate.hotelReservation.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
        List<Quarto> findByTipoQuartoAndDisponivel(Quarto.TipoQuarto tipoQuarto, boolean disponivel);

        @Query("SELECT r.quarto.id FROM Reserva r WHERE (r.dataEntrada <= :dataSaida AND r.dataSaida >= :dataEntrada)")
        List<Long> findIdsQuartosOcupadosNoPeriodo(
                        @Param("dataEntrada") LocalDate dataEntrada,
                        @Param("dataSaida") LocalDate dataSaida);

        List<Quarto> findByTipoQuartoAndDisponivelAndIdNotIn(Quarto.TipoQuarto tipoQuarto, boolean disponivel,
                        List<Long> idsQuartosOcupados);

        @Query("SELECT q FROM Quarto q WHERE q.disponivel = :disponivel AND q.id NOT IN :idsQuartosOcupados " +
                        "AND NOT EXISTS (SELECT 1 FROM Reserva r WHERE r.quarto = q AND (r.dataEntrada <= :dataSaida AND r.dataSaida >= :dataEntrada))")
        List<Quarto> findByDisponivelAndIdNotIn(
                        @Param("disponivel") boolean disponivel,
                        @Param("idsQuartosOcupados") List<Long> idsQuartosOcupados,
                        @Param("dataEntrada") LocalDate dataEntrada,
                        @Param("dataSaida") LocalDate dataSaida);

        @Query("SELECT q FROM Quarto q WHERE q.disponivel = :disponivel")
        List<Quarto> findByDisponivel(@Param("disponivel") boolean disponivel);

}