package com.chavatte.biblioteca.services;

import com.chavatte.biblioteca.exceptions.ResourceNotFoundException;
import com.chavatte.biblioteca.models.Livro;
import com.chavatte.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarLivroPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Livro criarLivro(Livro livro) {
        if (livroRepository.existsByIsbn(livro.getIsbn())) {
            throw new IllegalArgumentException("Já existe um livro com este ISBN.");
        }
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("O título do livro é obrigatório.");
        }
        if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new IllegalArgumentException("O autor do livro é obrigatório.");
        }
        if (livro.getGenero() == null || livro.getGenero().isEmpty()) {
            throw new IllegalArgumentException("O gênero do livro é obrigatório.");
        }
        if (livro.getQuantidadeEmEstoque() < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }

        return livroRepository.save(livro);
    }

    public Optional<Livro> atualizarLivro(Long id, Livro livroAtualizado) {
        return livroRepository.findById(id)
                .map(livro -> {
                    if (livroAtualizado.getIsbn() != null && !livroAtualizado.getIsbn().equals(livro.getIsbn())
                            && livroRepository.existsByIsbn(livroAtualizado.getIsbn())) {
                        throw new IllegalArgumentException("Já existe um livro com este ISBN.");
                    }
                    livro.setTitulo(livroAtualizado.getTitulo());
                    livro.setAutor(livroAtualizado.getAutor());
                    livro.setIsbn(livroAtualizado.getIsbn());
                    livro.setGenero(livroAtualizado.getGenero());
                    livro.setQuantidadeEmEstoque(livroAtualizado.getQuantidadeEmEstoque());
                    livro.setExemplaresEmprestados(livroAtualizado.getExemplaresEmprestados());
                    return livroRepository.save(livro);
                });
    }

    public void excluirLivro(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Livro não encontrado com ID: " + id);
        }
        livroRepository.deleteById(id);
    }

    public void atualizarEstoque(Long livroId, int quantidade) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com ID: " + livroId));

        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }

        livro.setQuantidadeEmEstoque(quantidade);
        livroRepository.save(livro);
    }
}