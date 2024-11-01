package com.example.demo.models;

import com.example.demo.modelsRecord.DadosAtualizacaoConserto;
import com.example.demo.modelsRecord.DadosConserto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entrada;
    private String saida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public Conserto(DadosConserto dados){
        this.ativo = true;
        this.entrada = dados.entrada();
        this.saida = dados.saida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados){
        if(dados.entrada() != null){
            this.entrada = dados.entrada();
        }
        if(dados.mecanico() != null){
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
    }

    public void delete(){
        this.ativo = false;
    }
}
