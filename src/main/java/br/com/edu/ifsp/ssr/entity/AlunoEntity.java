package br.com.edu.ifsp.ssr.entity;

import java.util.UUID;

public class AlunoEntity {
    private UUID id;
    private String nome;
    private String prontuario;
    private Integer periodo;

    public AlunoEntity() {

    }

    public AlunoEntity(UUID id, String nome, String prontuario, Integer periodo) {
        this.id = id;
        this.nome = nome;
        this.prontuario = prontuario;
        this.periodo = periodo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
