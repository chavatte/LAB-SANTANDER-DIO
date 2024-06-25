package com.chavatte.biblioteca.services;

import com.chavatte.biblioteca.exceptions.ResourceNotFoundException;
import com.chavatte.biblioteca.models.Usuario;
import com.chavatte.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario criarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário com este email.");
        }
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O email do usuário é obrigatório.");
        }
        if (usuario.getTipoUsuario() == null) {
            throw new IllegalArgumentException("O tipo de usuário é obrigatório.");
        }

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    if (usuarioAtualizado.getEmail() != null && !usuarioAtualizado.getEmail().equals(usuario.getEmail())
                            && usuarioRepository.existsByEmail(usuarioAtualizado.getEmail())) {
                        throw new IllegalArgumentException("Já existe um usuário com este email.");
                    }
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    usuario.setTipoUsuario(usuarioAtualizado.getTipoUsuario());
                    return usuarioRepository.save(usuario);
                });
    }

    public void excluirUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}