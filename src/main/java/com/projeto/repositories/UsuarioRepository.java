package com.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
