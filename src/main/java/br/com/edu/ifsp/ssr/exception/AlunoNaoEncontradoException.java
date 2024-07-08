package br.com.edu.ifsp.ssr.exception;

public class AlunoNaoEncontradoException extends RuntimeException {

    public AlunoNaoEncontradoException() {
        super("Aluno não encontrado.");
    }
}
