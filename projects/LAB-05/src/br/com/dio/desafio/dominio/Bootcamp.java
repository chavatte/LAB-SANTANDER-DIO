package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.of(2024, 04, 24);
    private final LocalDate dataFinal = dataInicial.plusDays(75);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicial() {
        return definirPadraoData(dataInicial);
    }

    public String getDataFinal() {
        return definirPadraoData(dataFinal);
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    public static String definirPadraoData(LocalDate dataNaoFormatada) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNaoFormatada.format(formatter);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Bootcamp: ").append(getNome()).append("\n");
        sb.append("Data Inicial: ").append(getDataInicial()).append("\n");
        sb.append("Data Final: ").append(getDataFinal()).append("\n");
        sb.append("\n").append(getDescricao()).append("\n");
        sb.append("\nTrilha de Aprendizado:");
        sb.append("\n----------------------\n");

        getConteudos().forEach(conteudo -> {
            sb.append("- Curso: ").append(conteudo.getTitulo()).append("\n");
            sb.append("- Descrição: ").append(conteudo.getDescricao()).append("\n");
            sb.append("- Instrutor: ").append(conteudo.getInstrutor()).append("\n");
            sb.append("- Carga Horária: ").append(conteudo.getCargaHoraria()).append(" Horas\n");
            sb.append("- Nível: ").append(conteudo.getNivel()).append("\n\n");
        });
        sb.append("Devs Inscritos: \n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao)
                && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal)
                && Objects.equals(devsInscritos, bootcamp.devsInscritos)
                && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}
