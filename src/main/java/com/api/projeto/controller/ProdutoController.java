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
import com.api.projeto.model.Produto;
import com.api.projeto.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
     @Autowired
    private ProdutoService produtoService;


   

    @GetMapping
    public List<Produto> obeterTodos(){

    return produtoService.obeterTodos();
    }


    


    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable Long id){

        return produtoService.obeterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){

        return produtoService.Adicionar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.Atualizar(id,produto);
    }

    @DeleteMapping("/{id}")
public void Deletar(@PathVariable Long id){
  produtoService.Deletar(id);

}
}

    

