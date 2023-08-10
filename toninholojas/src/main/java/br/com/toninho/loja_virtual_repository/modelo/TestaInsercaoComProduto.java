package br.com.toninho.loja_virtual_repository.modelo;

import java.sql.Connection;
import java.sql.SQLException;


import br.com.toninho.loja_virtual_repository.ConnectionFactory;
import br.com.toninho.loja_virtual_repository.PersistenciaProduto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Prodoto comoda = new Prodoto("comoda", "comoda vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			PersistenciaProduto persistenciaProduto = new PersistenciaProduto(connection);
			persistenciaProduto.salvarProduto(comoda);
			
		}
		System.out.println(comoda);
	}
}