package com.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
