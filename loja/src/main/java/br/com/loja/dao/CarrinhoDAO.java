package br.com.loja.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.loja.modelo.Carrinho;
import br.com.loja.modelo.Produto;

public class CarrinhoDAO {
	
	private static Map<Long, Carrinho> banco = new HashMap<Long, Carrinho>();
	private static AtomicLong contador = new AtomicLong(1);
	
	static {
		Produto videogame = new Produto(6237, "Videogame 4", 4000, 1);
		Produto esporte = new Produto(3467, "Jogo de esporte", 60, 2);
		Carrinho carrinho = new Carrinho()
								.adiciona(videogame)
								.adiciona(esporte)
								.para("Rua Vergueiro 3185, 8 andar", "São Paulo")
								.setId(1l);
		banco.put(1l, carrinho);
		
		
		
		
		
//		Produto monitor = new Produto(5566, "Monitor LG 27 Pol", 1210, 1);
//		Produto teclado = new Produto(5878, "Teclado e Mouse sem Fio Logitech", 250, 1);
//		Carrinho carrinho2 = new Carrinho()
//								.adiciona(monitor)
//								.adiciona(teclado)
//								.para("Rua Urucuca, 60", "São Paulo")
//								.setId(2l);
//		banco.put(2l, carrinho2);
	}
	
	public void adiciona(Carrinho carrinho) {
		long id = contador.incrementAndGet();
		carrinho.setId(id);
		banco.put(id, carrinho);
		System.out.println("Entrou no adiciona do DAO");
		
	}
	
	public Carrinho busca(Long id) {
		return banco.get(id);
	}
	public Map buscaTodos() {
		return banco;
	}
	
	public Carrinho remove(long id) {
		return banco.remove(id);
	}

}
