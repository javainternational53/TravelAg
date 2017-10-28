package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Szallas;
import model.User;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


public class PersistenceManager {

	private static EntityManager getEntityManager(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("TravelAgencyJpa");
		EntityManager em=emf.createEntityManager();
		return em;
	}
	
	static User getUserByName() {
		User user=null;
		EntityManager em=getEntityManager();
		
		//getuser
		
		em.close();
		return user;
	}
	
	public void createUser(User user) {
		EntityManager em=getEntityManager();
		em.persist(user);
		em.close();
	}
	
	public void createSzallas(Szallas szallas) {
		EntityManager em=getEntityManager();
		em.persist(szallas);
		em.close();
	}
	
	public List<Szallas> getAllSzallas(){
		EntityManager em=getEntityManager();
		List<Szallas> szallasList=new LinkedList<Szallas>(); 
		
		
		em.close();
		return szallasList;
	}
}