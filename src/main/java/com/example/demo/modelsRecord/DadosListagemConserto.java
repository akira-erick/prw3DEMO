package com.example.demo.modelsRecord;

import com.example.demo.models.Conserto;

public record DadosListagemConserto(

        Long id,
        String entrada,
        String saida,
        //separado só pra ser mais bonito
        DadosListagemMecanico mecanico,
        DadosListagemVeiculo veiculo

) {
    public DadosListagemConserto(Conserto conserto){
        this(
                conserto.getId(),
                conserto.getEntrada(),
                conserto.getSaida(),
                new DadosListagemMecanico(conserto.getMecanico()),
                new DadosListagemVeiculo(conserto.getVeiculo())
        );
    }

}
