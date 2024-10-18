package com.example.demo.modelsRecord;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(

        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String entrada,

        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String saida,

        @Valid
        DadosMecanico mecanico,

        @Valid
        DadosVeiculo veiculo) {
}
