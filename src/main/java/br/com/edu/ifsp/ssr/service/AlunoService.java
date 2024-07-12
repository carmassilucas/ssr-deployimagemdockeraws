package br.com.edu.ifsp.ssr.service;

import br.com.edu.ifsp.ssr.controller.dto.CadastrarAlunoDto;
import br.com.edu.ifsp.ssr.entity.AlunoEntity;
import br.com.edu.ifsp.ssr.exception.AlunoNaoEncontradoException;
import br.com.edu.ifsp.ssr.exception.ProntuarioExisteException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final List<AlunoEntity> alunos = new ArrayList<>();

    public AlunoEntity cadastrarAluno(CadastrarAlunoDto dto) {
        if (findByProntuario(dto.prontuario()).isPresent()) {
            throw new ProntuarioExisteException();
        }

        var aluno = dto.toAluno();
        this.alunos.add(aluno);
        return aluno;
    }

    public List<AlunoEntity> listarAlunos() {
        return this.alunos;
    }

    public AlunoEntity listarPeloProntuario(String prontuario) {
        return findByProntuario(prontuario).orElseThrow(AlunoNaoEncontradoException::new);
    }

    public void deletarAluno(String prontuario) {
        var aluno = findByProntuario(prontuario).orElseThrow(AlunoNaoEncontradoException::new);
        alunos.remove(aluno);
    }

    private Optional<AlunoEntity> findByProntuario(String prontuario) {
        return this.alunos.stream().filter(aluno ->
                aluno.getProntuario().equalsIgnoreCase(prontuario)
        ).findFirst();
    }
}
