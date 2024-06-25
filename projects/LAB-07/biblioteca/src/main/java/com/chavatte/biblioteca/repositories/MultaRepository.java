package com.chavatte.biblioteca.repositories;

import com.chavatte.biblioteca.models.Multa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultaRepository extends JpaRepository<Multa, Long> {
}
