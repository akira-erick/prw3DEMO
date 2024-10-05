package com.example.demo.controller;

import com.example.demo.models.Conserto;
import com.example.demo.modelsRecord.DadosConserto;
import com.example.demo.repositories.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosConserto dados){

        System.out.println(dados);
        repository.save( new Conserto(dados));

    }
}
