import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.toninho.loja_virtual_repository.dao.CategoriaDAO;
import br.com.toninho.loja_virtual_repository.dao.ProdutoDAO;
import br.com.toninho.loja_virtual_repository.modelo.Categoria;
import br.com.toninho.loja_virtual_repository.modelo.ConnectionFactory;
import br.com.toninho.loja_virtual_repository.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDecategoria = categoriaDAO.lista();

			listaDecategoria.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				try {
					for (Produto produto : new ProdutoDAO(connection).buscar(ct)) {
						System.out.println(ct.getNome()+" - "+ produto.getNome());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

		}

	}

}
