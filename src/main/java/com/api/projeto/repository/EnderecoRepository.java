package com.api.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.projeto.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long> {
    
}
