package com.chavatte.biblioteca.controllers;

import com.chavatte.biblioteca.models.Emprestimo;
import com.chavatte.biblioteca.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Long id) {
        return emprestimoService.buscarEmprestimoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Emprestimo> registrarEmprestimo(@RequestBody Emprestimo emprestimo) {
        Emprestimo novoEmprestimo = emprestimoService.registrarEmprestimo(emprestimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEmprestimo);
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<Emprestimo> devolverEmprestimo(@PathVariable Long id) {
        return emprestimoService.devolverEmprestimo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizarEmprestimo(@PathVariable Long id,
            @RequestBody Emprestimo emprestimoAtualizado) {
        return emprestimoService.atualizarEmprestimo(id, emprestimoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}