package com.example.demo.modelsRecord;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(

        @NotNull
        Long id,
        String entrada,

        DadosAtualizacaoMecanico mecanico

) {
}
