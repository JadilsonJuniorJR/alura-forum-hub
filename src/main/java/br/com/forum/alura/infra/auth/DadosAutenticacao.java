package br.com.forum.alura.infra.auth;

public record DadosAutenticacao(
        String email,
        String senha) {
}
