package com.example.demo.controller;

import com.example.demo.models.Conserto;
import com.example.demo.modelsRecord.DadosConserto;
import com.example.demo.modelsRecord.DadosListagemConserto;
import com.example.demo.repositories.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    //localhost:8080/conserto
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosConserto dados){

        System.out.println(dados);
        repository.save( new Conserto(dados));

    }

    //localhost:8080/conserto/getConsertosDados
    @GetMapping("/getConsertosDados")
    public Page<Conserto> listarDados(@PageableDefault(size = 2) Pageable page){

        return repository.findAll(page);

    }

    //localhost:8080/conserto/getConsertos
    @GetMapping("/getConsertos")
    public List<DadosListagemConserto>listar(){

        return repository.findAll().stream().map(DadosListagemConserto::new).toList();

    }
}
