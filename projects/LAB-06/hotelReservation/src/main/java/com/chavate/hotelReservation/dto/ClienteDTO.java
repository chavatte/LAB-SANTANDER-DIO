package com.chavate.hotelReservation.dto;

import com.chavate.hotelReservation.model.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {
    private String nome;
    private String email;
    private String telefone;

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }

    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        return cliente;
    }
}
