package com.chavate.hotelReservation.repository;

import com.chavate.hotelReservation.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT r.quarto.id FROM Reserva r WHERE (:dataEntrada < r.dataSaida AND :dataSaida > r.dataEntrada)")
    List<Long> findIdsQuartosOcupadosNoPeriodo(
            @Param("dataEntrada") LocalDate dataEntrada,
            @Param("dataSaida") LocalDate dataSaida);
}