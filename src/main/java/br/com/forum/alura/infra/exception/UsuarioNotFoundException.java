package br.com.forum.alura.infra.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String mensagem) {
        super(mensagem);
    }
    public UsuarioNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
