package com.chavatte.biblioteca.services;

import com.chavatte.biblioteca.exceptions.ResourceNotFoundException;
import com.chavatte.biblioteca.models.Emprestimo;
import com.chavatte.biblioteca.models.Livro;
import com.chavatte.biblioteca.models.Usuario;
import com.chavatte.biblioteca.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroService livroService;

    @Autowired
    private UsuarioService usuarioService;

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Optional<Emprestimo> buscarEmprestimoPorId(Long id) {
        return emprestimoRepository.findById(id);
    }

    public Emprestimo registrarEmprestimo(Emprestimo emprestimo) {
        if (!livroService.buscarLivroPorId(emprestimo.getLivro().getId()).isPresent()) {
            throw new ResourceNotFoundException("Livro não encontrado.");
        }
        if (!usuarioService.buscarUsuarioPorId(emprestimo.getUsuario().getId()).isPresent()) {
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        Livro livro = livroService.buscarLivroPorId(emprestimo.getLivro().getId()).get();

        if (livro.getQuantidadeEmEstoque() <= livro.getExemplaresEmprestados()) {
            throw new IllegalArgumentException("Livro indisponível para empréstimo.");
        }

        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucaoPrevista(emprestimo.getDataEmprestimo().plusDays(15));

        livro.setExemplaresEmprestados(livro.getExemplaresEmprestados() + 1);
        livroService.atualizarLivro(livro.getId(), livro);

        return emprestimoRepository.save(emprestimo);
    }

    public Optional<Emprestimo> devolverEmprestimo(Long id) {
        return emprestimoRepository.findById(id)
                .map(emprestimo -> {
                    Livro livro = emprestimo.getLivro();
                    emprestimo.setDataDevolucaoEfetiva(LocalDate.now());

                    long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataDevolucaoPrevista(), LocalDate.now());
                    if (diasAtraso > 0) {
                        double multaPorDia = 1.0;
                        double valorMulta = diasAtraso * multaPorDia;

                        Usuario usuario = emprestimo.getUsuario();
                        usuario.setMultaAcumulada(usuario.getMultaAcumulada() + valorMulta);
                        usuarioService.atualizarUsuario(usuario.getId(), usuario);
                    }

                    livro.setExemplaresEmprestados(livro.getExemplaresEmprestados() - 1);
                    livroService.atualizarLivro(livro.getId(), livro);

                    return emprestimoRepository.save(emprestimo);
                });
    }

    public Optional<Emprestimo> atualizarEmprestimo(Long id, Emprestimo emprestimoAtualizado) {
        return emprestimoRepository.findById(id)
                .map(emprestimoExistente -> {
                    emprestimoExistente.setDataDevolucaoPrevista(emprestimoAtualizado.getDataDevolucaoPrevista());

                    return emprestimoRepository.save(emprestimoExistente);
                });
    }
}