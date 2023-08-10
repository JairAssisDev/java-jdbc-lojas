package br.com.toninho.loja_virtual_repository.modelo;

public class Prodoto {

	private Integer id;
	private String nome;
	private String descricao;

	public Prodoto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		
		return String.format("O produto criado foi: %d,%s,%s",
				this.id,this.nome,this.descricao);
	}
}
