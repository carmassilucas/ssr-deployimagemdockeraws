package br.com.edu.ifsp.ssr.service;

import br.com.edu.ifsp.ssr.controller.dto.CadastrarAlunoDto;
import br.com.edu.ifsp.ssr.entity.Aluno;
import br.com.edu.ifsp.ssr.exception.AlunoNaoEncontradoException;
import br.com.edu.ifsp.ssr.exception.ProntuarioExisteException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final List<Aluno> alunos = new ArrayList<>();

    public Aluno cadastrarAluno(CadastrarAlunoDto dto) {
        if (findByProntuario(dto.prontuario()).isPresent()) {
            throw new ProntuarioExisteException();
        }

        var aluno = dto.toAluno();
        this.alunos.add(aluno);
        return aluno;
    }

    public List<Aluno> listarAlunos() {
        return this.alunos;
    }

    public Aluno listarPeloProntuario(String prontuario) {
        return findByProntuario(prontuario).orElseThrow(AlunoNaoEncontradoException::new);
    }

    private Optional<Aluno> findByProntuario(String prontuario) {
        return this.alunos.stream().filter(aluno ->
                aluno.getProntuario().equalsIgnoreCase(prontuario)
        ).findFirst();
    }
}
