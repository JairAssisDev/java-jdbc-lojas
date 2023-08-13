package br.com.toninho.loja_virtual_repository.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.toninho.loja_virtual_repository.dao.ProdutoDAO;



public class TesteInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("comoda", "comoda vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
			
		}
	}
}
