package com.example.demo.controller;

import com.example.demo.models.Conserto;
import com.example.demo.modelsRecord.DadosAtualizacaoConserto;
import com.example.demo.modelsRecord.DadosConserto;
import com.example.demo.modelsRecord.DadosDetalhamentoConserto;
import com.example.demo.modelsRecord.DadosListagemConserto;
import com.example.demo.repositories.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    //localhost:8080/conserto
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosConserto dados, UriComponentsBuilder uriBuilder){

        var conserto = new Conserto(dados);
        repository.save(conserto);

        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));

    }

    //localhost:8080/conserto/getConsertosDados
    @GetMapping("/getConsertosDados")
    public ResponseEntity listarDados(@PageableDefault(size = 2) Pageable page){

        return ResponseEntity.ok(repository.findAllByAtivoTrue(page));

    }

    //localhost:8080/conserto/getConsertos
    @GetMapping("/getConsertos")
    public ResponseEntity listar(){

        return ResponseEntity.ok(repository.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id){

        Optional<Conserto> consertoOptional =  repository.findById(id);

        if(consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            if(!conserto.getAtivo()) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAtualizacaoConserto dados){

        Conserto conserto = repository.getReferenceById(dados.id());
        if(!conserto.getAtivo()) return ResponseEntity.notFound().build();
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        Conserto conserto = repository.getReferenceById(id);
        conserto.delete();

        return ResponseEntity.noContent().build();
    }
}
