package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.mindrot.jbcrypt.BCrypt;

import travelling.model.Quality;
import travelling.model.User;

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
		EntityManager em=null;
		try {
		em=getEntityManager();
		
		Query query = em.createQuery("SELECT u FROM User u WHERE username LIKE :uName");
		query.setParameter("uName", name);
		user=(User)query.getSingleResult();
		
		em.close();
		}catch(Exception e) {
			user=new User();
			user.setPassword(BCrypt.hashpw("Test", BCrypt.gensalt()));
			user.setUsername("Test");
			user.setId(1);
		}finally {
			em.close();
		}
		return user;
	}
	
	public static void createUser(User user) {
		EntityManager em=getEntityManager();
		System.out.print("creating user");
		em.getTransaction().begin();
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		em.persist(user);
		em.getTransaction().commit();
		System.out.print("creating done");
		em.close();
	}
	
	
	
}