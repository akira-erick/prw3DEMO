package com.example.demo.models;

import com.example.demo.modelsRecord.DadosAtualizacaoMecanico;
import com.example.demo.modelsRecord.DadosMecanico;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    private String nome;
    private String experiencia;

    public Mecanico(DadosMecanico dados){
        this.nome = dados.nome();
        this.experiencia = dados.experiencia();
    }

    public void atualizarInformacoes(DadosAtualizacaoMecanico dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
    }
}
