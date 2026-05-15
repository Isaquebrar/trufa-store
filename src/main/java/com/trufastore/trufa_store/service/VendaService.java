package com.trufastore.trufa_store.service;

import com.trufastore.trufa_store.entity.ItemVenda;
import com.trufastore.trufa_store.entity.Produto;
import com.trufastore.trufa_store.entity.Venda;
import com.trufastore.trufa_store.repository.ProdutoRepository;
import com.trufastore.trufa_store.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Venda salvar(Venda venda) {

        // validação simples
        if (venda.getItens() == null || venda.getItens().isEmpty()) {
            throw new RuntimeException("Venda precisa ter itens");
        }

        // salva venda primeiro
        Venda vendaSalva = vendaRepository.save(venda);

        // processa itens
        for (ItemVenda item : venda.getItens()) {

            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow();

            item.setProduto(produto);
            item.setVenda(vendaSalva);
            item.setPreco(produto.getPreco());
        }

        // salva novamente com cascade
        return vendaRepository.save(vendaSalva);
    }

    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id).orElseThrow();
    }
}