package com.api.projeto.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.projeto.model.Cliente;
import com.api.projeto.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente Adicionar(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    public List<Cliente> obeterTodos(){
        return clienteRepository.findAll();
    }
   


    public Cliente obeterPorId(Long id){
      Optional<Cliente> optionalCliente= clienteRepository.findById(id);

      if(optionalCliente.isEmpty()){
        throw new IllegalArgumentException("Nao existe Categoria com um id" + id);
      }

      return optionalCliente.get();
    }

    public Cliente Atualizar(Long id, Cliente cliente){
        


      cliente.setId(id);

      clienteRepository.save(cliente);
      return null;
    }
    public void Deletar(Long id) {
      clienteRepository.deleteById(id);
    }


}
