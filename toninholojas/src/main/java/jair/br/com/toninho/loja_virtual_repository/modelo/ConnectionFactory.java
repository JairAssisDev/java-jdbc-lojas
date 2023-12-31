package jair.br.com.toninho.loja_virtual_repository.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	public ConnectionFactory() {

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource
				.setJdbcUrl("jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("123456");

		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
	}
}
