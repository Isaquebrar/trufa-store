package com.trufastore.trufa_store.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemVenda> itens;

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}