package com.chavate.hotelReservation.dto;

import com.chavate.hotelReservation.model.Quarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.NumberFormat;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuartoDisponivelDTO {
    private Long quarto;
    private String tipo;
    private String preco;
    private String disponivel;

    public QuartoDisponivelDTO(Quarto quarto) {
        this.quarto = Long.valueOf(quarto.getNumero());
        this.tipo = quarto.getTipoQuarto().name();
        this.preco = formatarPreco(quarto.getPreco());
        this.disponivel = quarto.isDisponivel() ? "Sim" : "Não";
    }

    private String formatarPreco(double preco) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(preco);
    }
}