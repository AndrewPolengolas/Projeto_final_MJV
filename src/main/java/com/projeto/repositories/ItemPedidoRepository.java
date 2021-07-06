package com.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.models.ItemPedido;
import com.projeto.models.pk.PedidoItemPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, PedidoItemPK> {

}
