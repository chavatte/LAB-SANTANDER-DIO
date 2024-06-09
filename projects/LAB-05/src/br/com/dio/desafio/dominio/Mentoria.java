package br.com.dio.desafio.dominio;

import static br.com.dio.desafio.dominio.Bootcamp.definirPadraoData;
import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public Mentoria() {
    }

    public String getData() {
        return definirPadraoData(data);
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mentoria: ").append(getTitulo()).append("\n");
        sb.append("Descrição: ").append(getDescricao()).append("\n");
        sb.append("Data: ").append(getData()).append("\n");
        sb.append("Instrutor: ").append(getInstrutor()).append("\n");
        return sb.toString();
    }
}
