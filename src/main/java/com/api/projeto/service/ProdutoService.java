package com.api.projeto.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.projeto.model.Produto;
import com.api.projeto.repository.ProdutoRepository;

@Service
public class ProdutoService {
     @Autowired
    private ProdutoRepository produtoRepository;


    public Produto Adicionar(Produto produto){

        return produtoRepository.save(produto);
    }

    public List<Produto> obeterTodos(){
        return produtoRepository.findAll();
    }



    public Produto obeterPorId(Long id){
      Optional<Produto> optionalProduto= produtoRepository.findById(id);

      if(optionalProduto.isEmpty()){
        throw new IllegalArgumentException("Nao existe Categoria com um id" + id);
      }

      return optionalProduto.get();
    }

    public Produto Atualizar(Long id, Produto produto){
        


      produto.setId(id);

      produtoRepository.save(produto);
      return null;
    }
    public void Deletar(Long id) {
      produtoRepository.deleteById(id);
    }


}
