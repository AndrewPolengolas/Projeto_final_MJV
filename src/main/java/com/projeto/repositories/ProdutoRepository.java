package com.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
