package br.com.edu.ifsp.ssr.controller.dto;

import br.com.edu.ifsp.ssr.entity.Aluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CadastrarAlunoDto(@NotBlank String nome,
                                @NotBlank String prontuario,
                                @NotNull Integer periodo) {

    public Aluno toAluno() {
        return new Aluno(UUID.randomUUID(), nome, prontuario, periodo);
    }
}
