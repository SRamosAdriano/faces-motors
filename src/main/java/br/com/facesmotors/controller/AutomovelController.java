package br.com.facesmotors.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facesmotors.modelo.Automovel;
import br.com.facesmotors.util.JPAUtil;

@ManagedBean(name="automovelController")
public class AutomovelController {
	
	private Automovel automovel = new Automovel();
	
	private List<Automovel> automoveis;

	public void salvar(Automovel automovel){
		
		if(automovel != null){
			EntityManager manager = JPAUtil.getEntityManager();
			
			manager.getTransaction().begin();
			
			manager.persist(automovel);
			
			manager.getTransaction().commit();
			
			manager.close();
		}		
	}
	
	public void exclui(Automovel automovel){
		
		EntityManager manager = JPAUtil.getEntityManager();
				
		manager.getTransaction().begin();
		
		manager.remove(automovel);
		
		manager.getTransaction().commit();
		
		manager.close();
	}
	

	public Automovel getAutomovel() {
		return automovel;
	}

	public List<Automovel> getAutomoveis() {
		if(automoveis == null){
			EntityManager manager = JPAUtil.getEntityManager();
			
			Query query = manager.createQuery("SELECT a FROM Automovel a", Automovel.class);
			
			this.automoveis = query.getResultList();
		}	
		return automoveis;
	}
	
}
