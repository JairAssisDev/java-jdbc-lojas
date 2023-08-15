package jair.br.com.toninho.loja_virtual_repository.modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteRemocao {
	
	public static void main(String[] args)throws SQLException {
		
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhaModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas que foram modificadas"+linhaModificadas);
		
	}

}
