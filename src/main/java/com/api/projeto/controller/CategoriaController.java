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

import com.api.projeto.model.Categoria;
import com.api.projeto.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin("*")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obeterTodos(){

    return categoriaService.obeterTodos();
    }

    
    @GetMapping("/{id}")
    public Categoria obterPorId(@PathVariable Long id){

        return categoriaService.obeterPorId(id);
    }

    
    @PostMapping
    public Categoria adicionar(@RequestBody Categoria categoria){

        return categoriaService.Adicionar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.Atualizar(id,categoria);
    }

    @DeleteMapping("/{id}")
public void Deletar(@PathVariable Long id){
  categoriaService.Deletar(id);

}
}
