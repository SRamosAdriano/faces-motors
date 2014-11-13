package br.com.facesmotors.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JPAUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "default";

	private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory factory;

	private JPAUtil() {
	}

	public static EntityManager getEntityManager() {
		if (JPAUtil.factory == null) {
			JPAUtil.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		EntityManager m = JPAUtil.manager.get();
		if (m == null) {
			m = JPAUtil.factory.createEntityManager();
			JPAUtil.manager.set(m);
		}
		return m;
	}
}
