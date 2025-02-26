package br.com.forum.alura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRecordDto(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Long autorId,
        @NotNull
        Long cursoId
) {
}
