package br.com.edu.ifsp.ssr.exception;

public class ProntuarioExisteException extends RuntimeException {

    public ProntuarioExisteException() {
        super("Prontuário já cadastrado.");
    }
}
