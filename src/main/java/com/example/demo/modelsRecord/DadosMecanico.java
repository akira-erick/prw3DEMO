package com.example.demo.modelsRecord;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(

        @NotBlank
        String nome,
        String experiencia) {
}
