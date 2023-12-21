package com.api.projeto.controller;

import com.api.projeto.model.Endereco;
import com.api.projeto.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/{id}")
    public Endereco obterEnderecoPorId(@PathVariable Long id) {
        return enderecoService.obterEnderecoPorId(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    @PostMapping
    public Endereco criarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.criarEndereco(endereco);
    }

    @PutMapping("/{id}")
    public Endereco atualizarEndereco(@PathVariable Long id, @RequestBody Endereco enderecoAtualizado) {
        return enderecoService.atualizarEndereco(id, enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
    }
}
