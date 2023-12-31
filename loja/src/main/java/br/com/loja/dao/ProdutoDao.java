package br.com.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		this.em=em;
	}
	public void cadastrar (Produto produto) {
		this.em.persist(produto);
	}

	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
	public Produto buscarPorId(Long id) {
		
		return em.find(Produto.class, id);
	}
	public List<Produto> buscarTodos(){
		String jpql ="SELECT p FROM Produto p";
		return em.createQuery(jpql,Produto.class).getResultList();
	}
	public List<Produto> buscarPorNome(String nome){
		String jpql ="SELECT p FROM Produto p WHERE p.nome = ?1";
		return em.createQuery(jpql,Produto.class).setParameter(1, nome)
				.getResultList();
	}
	public List<Produto> buscarPorNomeDaCategoria(String nome){
		String jpql ="SELECT p FROM Produto p WHERE p.categoria.nome = ?1";
		return em.createQuery(jpql,Produto.class).setParameter(1, nome)
				.getResultList();
	}
	public BigDecimal buscarPrecoDoProdutoComNome(String nome){
		String jpql ="SELECT p.preco FROM Produto p WHERE p.nome = ?1";
		return em.createQuery(jpql,BigDecimal.class).setParameter(1, nome)
				.getSingleResult();
	}
}
