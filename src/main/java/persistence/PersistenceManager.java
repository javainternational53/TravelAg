package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.User;
import model.Szallas;
import model.Quality;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


public class PersistenceManager {

	private static EntityManager getEntityManager(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("TravelAgencyJpa");
		EntityManager em=emf.createEntityManager();
		return em;
	}
	
	public static User getUserByName(String name) {
		User user=null;
		EntityManager em=getEntityManager();
		
		Query query = em.createQuery("SELECT u FROM User u WHERE name LIKE :uName");
		query.setParameter("uName", name);
		user=(User)query.getSingleResult();
		
		em.close();
		return user;
	}
	
	public static void createUser(User user) {
		EntityManager em=getEntityManager();
		
		em.persist(user);
		
		em.close();
	}
	
	public static void createSzallas(Szallas szallas) {
		EntityManager em=getEntityManager();
		
		em.persist(szallas);
		
		em.close();
	}
	
	public static List<Szallas> getAllSzallas(){
		EntityManager em=getEntityManager();
		List<Szallas> szallasList=new LinkedList<Szallas>(); 
		
		Query query = em.createQuery("SELECT s from Szallas s");
		szallasList = query.getResultList();
		
		em.close();
		return szallasList;
	}
	
	public static List<Szallas> getSzallasByLocation(String location){
		EntityManager em=getEntityManager();
		List<Szallas> szallasList=new LinkedList<Szallas>(); 
		
		Query query = em.createQuery("SELECT s from Szallas s WHERE location LIKE :loc");
		query.setParameter("loc", location);
		szallasList = query.getResultList();
		
		em.close();
		return szallasList;
	}
	
	public static List<Szallas> getSzallasByQuality(Quality quality){
		EntityManager em=getEntityManager();
		List<Szallas> szallasList=new LinkedList<Szallas>(); 
		
		Query query = em.createQuery("SELECT s from Szallas s WHERE location LIKE :qual");
		query.setParameter("qual", quality);
		szallasList = query.getResultList();
		
		em.close();
		return szallasList;
	}
	
	
}