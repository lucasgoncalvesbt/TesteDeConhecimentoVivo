package org.vivo.testedeconhecimentovivo.models;

import java.time.LocalDateTime;

public class Job {

    private Integer id;
    private String descricao;
    private LocalDateTime dataMaximaConclusao;
    private Integer tempoEstimadoEmHoras;

    public Job(Integer id, String descricao, LocalDateTime dataMaximaConclusao, Integer tempoEstimadoEmHoras) {
        this.id = id;
        this.descricao = descricao;
        this.dataMaximaConclusao = dataMaximaConclusao;
        this.tempoEstimadoEmHoras = tempoEstimadoEmHoras;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataMaximaConclusao() {
        return dataMaximaConclusao;
    }

    public void setDataMaximaConclusao(LocalDateTime dataMaximaConclusao) {
        this.dataMaximaConclusao = dataMaximaConclusao;
    }

    public Integer getTempoEstimadoEmHoras() {
        return tempoEstimadoEmHoras;
    }

    public void setTempoEstimadoEmHoras(Integer tempoEstimadoEmHoras) {
        this.tempoEstimadoEmHoras = tempoEstimadoEmHoras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        if (descricao != null ? !descricao.equals(job.descricao) : job.descricao != null) return false;
        if (dataMaximaConclusao != null ? !dataMaximaConclusao.equals(job.dataMaximaConclusao) : job.dataMaximaConclusao != null)
            return false;
        return tempoEstimadoEmHoras != null ? tempoEstimadoEmHoras.equals(job.tempoEstimadoEmHoras) : job.tempoEstimadoEmHoras == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (dataMaximaConclusao != null ? dataMaximaConclusao.hashCode() : 0);
        result = 31 * result + (tempoEstimadoEmHoras != null ? tempoEstimadoEmHoras.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataMaximaConclusao=" + dataMaximaConclusao +
                ", tempoEstimadoEmHoras=" + tempoEstimadoEmHoras +
                '}';
    }
}
