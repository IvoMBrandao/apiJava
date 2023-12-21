package com.api.projeto.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.projeto.model.Categoria;
import com.api.projeto.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria Adicionar(Categoria categoria){

        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obeterTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria obeterPorId(Long id){
      Optional<Categoria> optionalCategoria= categoriaRepository.findById(id);

      if(optionalCategoria.isEmpty()){
        throw new IllegalArgumentException("Nao existe Categoria com um id" + id);
      }

      return optionalCategoria.get();
    }

    public Categoria Atualizar(Long id, Categoria categoria){
        


      categoria.setId(id);

      categoriaRepository.save(categoria);
      return null;
    }
    public void Deletar(Long id) {
      categoriaRepository.deleteById(id);
    }

}
