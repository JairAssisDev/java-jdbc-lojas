package br.com.loja.tetes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("xiaomi Redmi","muito ruin",new BigDecimal("600"),celulares);

		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtodao = new ProdutoDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtodao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
