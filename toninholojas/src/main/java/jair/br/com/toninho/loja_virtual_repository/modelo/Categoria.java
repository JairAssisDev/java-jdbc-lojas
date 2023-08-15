package jair.br.com.toninho.loja_virtual_repository.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private List<Produto> produtos = new ArrayList<Produto>();
	private Integer id;
	private String nome;

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getId() {
		return id;
	}

	public void adicionar(Produto produto) {
		// TODO Auto-generated method stub
		produtos.add(produto);
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
}
