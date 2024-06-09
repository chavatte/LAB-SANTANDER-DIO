package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;
    private String nivel;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso: ").append(getTitulo()).append("\n");
        sb.append("Descrição: ").append(getDescricao()).append("\n");
        sb.append("Carga Horária: ").append(getCargaHoraria()).append(" hora(s)\n");
        sb.append("Instrutor: ").append(getInstrutor()).append("\n");
        sb.append("Nível: ").append(getNivel()).append("\n");
        return sb.toString();
    }
}
