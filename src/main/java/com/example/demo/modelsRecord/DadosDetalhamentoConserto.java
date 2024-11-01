package com.example.demo.modelsRecord;

import com.example.demo.models.Conserto;
import com.example.demo.models.Mecanico;
import com.example.demo.models.Veiculo;

public record DadosDetalhamentoConserto (Long id, String entrada, String saida, Mecanico mecanico, Veiculo veiculo){
    public DadosDetalhamentoConserto(Conserto conserto){
        this(conserto.getId(), conserto.getEntrada(), conserto.getSaida(), conserto.getMecanico(), conserto.getVeiculo());
    }
}
