package com.api.projeto.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projeto.model.Cliente;
import com.api.projeto.service.ClienteService;


@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obeterTodos(){

    return clienteService.obeterTodos();
    }

    @GetMapping("/{id}")
    public Cliente obterPorId(@PathVariable Long id){

        return clienteService.obeterPorId(id);
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){

        return clienteService.Adicionar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.Atualizar(id,cliente);
    }

    @DeleteMapping("/{id}")
public void Deletar(@PathVariable Long id){
  clienteService.Deletar(id);

}
}
