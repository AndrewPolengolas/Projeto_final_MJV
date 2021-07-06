package com.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
