package com.trufastore.trufa_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trufastore.trufa_store.entity.Produto;
import com.trufastore.trufa_store.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    // LISTAR 
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // SALVAR
    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    // DELETAR
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
