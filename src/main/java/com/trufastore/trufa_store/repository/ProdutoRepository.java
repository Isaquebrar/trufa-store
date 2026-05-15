package com.trufastore.trufa_store.repository;

import com.trufastore.trufa_store.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}