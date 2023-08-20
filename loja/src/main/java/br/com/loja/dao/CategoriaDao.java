package br.com.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}

	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}

	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}

	public Categoria buscarPorId(Long id) {

		return em.find(Categoria.class, id);
	}

	public List<Categoria> buscarTodos() {
		String jpql = "SELECT c FROM Categoria c";
		return em.createQuery(jpql, Categoria.class).getResultList();
	}
	public List<Categoria> buscarPorNome(String nome){
		String jpql ="SELECT c FROM Categoria c WHERE c.nome = ?1";
		return em.createQuery(jpql,Categoria.class).setParameter(1, nome)
				.getResultList();
	}
	
}
