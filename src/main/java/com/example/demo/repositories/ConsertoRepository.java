package com.example.demo.repositories;

import com.example.demo.models.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {

    Page<Conserto> findAllByAtivoTrue(Pageable paginacao);
    List<Conserto> findAllByAtivoTrue();
    //Optional<Conserto> findByIdAtivoTrue(Long id);
}
