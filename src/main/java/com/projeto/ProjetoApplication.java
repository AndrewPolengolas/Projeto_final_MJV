package com.projeto;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.projeto.models.Categoria;
import com.projeto.models.ItemPedido;
import com.projeto.models.Pagamento;
import com.projeto.models.Pedido;
import com.projeto.models.Produto;
import com.projeto.models.Usuario;
import com.projeto.models.enums.StatusPedido;
import com.projeto.repositories.CategoriaRepository;
import com.projeto.repositories.ItemPedidoRepository;
import com.projeto.repositories.PedidoRepository;
import com.projeto.repositories.ProdutoRepository;
import com.projeto.repositories.UsuarioRepository;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(UsuarioRepository usuarioRepository, PedidoRepository PedidoRepository,
			CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository,
			ItemPedidoRepository itemPedidoRepository) throws Exception {
		return args -> {
			Categoria cat1 = new Categoria(null, "Electronicos");
			Categoria cat2 = new Categoria(null, "Livros");
			Categoria cat3 = new Categoria(null, "Computadores");
			
			Produto p1 = new Produto(null, "O Senhor dos anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
			Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
			Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
			Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
			Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
			
			categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
			produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
			
			p1.getCategorias().add(cat2);
			p2.getCategorias().add(cat1);
			p2.getCategorias().add(cat3);
			p3.getCategorias().add(cat3);
			p4.getCategorias().add(cat3);
			p5.getCategorias().add(cat2);
			
			produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
			
			Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
			Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
			
			Pedido i1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
			Pedido i2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u2);
			Pedido i3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);
			
			usuarioRepository.saveAll(Arrays.asList(u1, u2));
			PedidoRepository.saveAll(Arrays.asList(i1, i2, i3));
			
			ItemPedido ip1 = new ItemPedido(i1, p1, 2, p1.getPreco());
			ItemPedido ip2 = new ItemPedido(i1, p3, 1, p3.getPreco());
			ItemPedido ip3 = new ItemPedido(i2, p3, 2, p3.getPreco());
			ItemPedido ip4 = new ItemPedido(i3, p5, 2, p5.getPreco());
			
			itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));	
			
			Pagamento pagamento1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), i1);
			i1.setPagamento(pagamento1);
	
			PedidoRepository.save(i1);
		};
	}
}
