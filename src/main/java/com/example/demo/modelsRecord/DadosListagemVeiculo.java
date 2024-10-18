package com.example.demo.modelsRecord;

import com.example.demo.models.Veiculo;

public record DadosListagemVeiculo (

        String marca,
        String modelo

){
    public DadosListagemVeiculo(Veiculo veiculo){
        this(
                veiculo.getMarca(),
                veiculo.getModelo()
        );
    }
}
