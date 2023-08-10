package br.com.toninho.loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.toninho.loja_virtual_repository.modelo.Prodoto;

public class PersistenciaProduto {

	private Connection connection;

	public PersistenciaProduto(Connection connection) {
		this.connection = connection;
	}

	public void salvarProduto(Prodoto prodoto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, prodoto.getNome());
			pstm.setString(2, prodoto.getDescricao());
			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					prodoto.setId(rst.getInt(1));
				}
			}
		}
	}
}
