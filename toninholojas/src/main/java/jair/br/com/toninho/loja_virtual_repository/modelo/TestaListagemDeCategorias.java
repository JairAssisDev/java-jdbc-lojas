package jair.br.com.toninho.loja_virtual_repository.modelo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jair.br.com.toninho.loja_virtual_repository.dao.CategoriaDAO;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDecategoria = categoriaDAO.listaComProdutos();

			listaDecategoria.stream().forEach(ct -> {
				System.out.println(ct.getNome());

				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());

				}
			});

		}

	}

}
