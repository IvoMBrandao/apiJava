package com.api.projeto.service;

import com.api.projeto.model.Endereco;
import com.api.projeto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> obterEnderecoPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(Long id, Endereco enderecoAtualizado) {
        return enderecoRepository.findById(id)
                .map(enderecoExistente -> {
                    enderecoExistente.setCep(enderecoAtualizado.getCep());
                    enderecoExistente.setRua(enderecoAtualizado.getRua());
                    enderecoExistente.setNumero(enderecoAtualizado.getNumero());
                    enderecoExistente.setBairro(enderecoAtualizado.getBairro());
                    enderecoExistente.setComplemento(enderecoAtualizado.getComplemento());
                    enderecoExistente.setCidade(enderecoAtualizado.getCidade());
                    enderecoExistente.setEstado(enderecoAtualizado.getEstado());
                    return enderecoRepository.save(enderecoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}