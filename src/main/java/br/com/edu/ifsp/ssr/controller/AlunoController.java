package br.com.edu.ifsp.ssr.controller;

import br.com.edu.ifsp.ssr.controller.dto.CadastrarAlunoDto;
import br.com.edu.ifsp.ssr.entity.AlunoEntity;
import br.com.edu.ifsp.ssr.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> cadastrarAluno(@RequestBody @Valid CadastrarAlunoDto dto) {
        var aluno = this.service.cadastrarAluno(dto);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> listarAlunos() {
        return ResponseEntity.ok(this.service.listarAlunos());
    }

    @GetMapping("/{prontuario}")
    public ResponseEntity<AlunoEntity> listarPeloProntuario(@PathVariable String prontuario) {
        return ResponseEntity.ok(this.service.listarPeloProntuario(prontuario));
    }
}
