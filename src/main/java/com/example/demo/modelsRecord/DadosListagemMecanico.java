package com.example.demo.modelsRecord;

import com.example.demo.models.Mecanico;

public record DadosListagemMecanico (

        String nome

){
    public DadosListagemMecanico(Mecanico mecanico){
        this(
                mecanico.getNome()
        );
    }
}
