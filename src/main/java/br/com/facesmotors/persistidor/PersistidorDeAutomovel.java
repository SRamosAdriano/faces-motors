package br.com.facesmotors.persistidor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.facesmotors.modelo.Automovel;
import br.com.facesmotors.util.JPAUtil;

public class PersistidorDeAutomovel {
	
	public static void main(String[] args) {
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Automovel auto = new Automovel();
		auto.setAnoFabricacao(2010);
		auto.setModelo("Ferrari Teste");
		auto.setObservacoes("Nunca foi batido");
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();		
		em.persist(auto);
		tx.commit();
		
		em.close();
		
	}

}
