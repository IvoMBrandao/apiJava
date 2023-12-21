package com.api.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.projeto.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
    @EntityGraph(attributePaths = "enderecos")
    List<Cliente> findAll();


    @EntityGraph(attributePaths = "enderecos")
    Optional<Cliente> findById(Long id);

    @EntityGraph(attributePaths = "enderecos")
    Optional<Cliente> findWithEnderecosById(Long id);
}
