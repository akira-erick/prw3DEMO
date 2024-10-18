package com.example.demo.modelsRecord;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(

        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        String cor,

        @Pattern(regexp = "^\\d{4}$")
        String ano) {
}
