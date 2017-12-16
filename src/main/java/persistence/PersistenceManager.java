package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.mindrot.jbcrypt.BCrypt;

import travelling.model.BookedTravel;
import travelling.model.NetworkMessage;
import travelling.model.Quality;
import travelling.model.Travel;
import travelling.model.User;

import java.util.ArrayList;
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
		
		System.err.println("\npersistence: "+user+"\n");
		
		}catch(NoResultException e){
			
		
		}catch(Exception e) {
			System.out.println(e.getMessage());	
			
		}finally {
			if(em!=null)
				em.close();
		}
		return user;
	}
	
	public static void createUser(User user) {
		EntityManager em=getEntityManager();
		em.getTransaction().begin();
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		em.persist(user);
		em.getTransaction().commit();
		if(em.isOpen())
			em.close();
	}

	public static User getUserByEmail(String email) {
		User user=null;
		EntityManager em=null;
		try {
		em=getEntityManager();
		
		Query query = em.createQuery("SELECT u FROM User u WHERE email LIKE :email");
		query.setParameter("email", email);
		user=(User)query.getSingleResult();
	
		}catch(NoResultException e){
			System.out.println("no result!");
		
		}catch(Exception e) {
			e.getMessage();
		}finally {
			if(em!=null)
				em.close();
		}
		return user;
	}
	
	public static User getUserById(long id) {
		User user=null;
		EntityManager em=null;
		try {
		em=getEntityManager();
		
		Query query = em.createQuery("SELECT u FROM User u WHERE id = :id");
		query.setParameter("id", id);
		user=(User)query.getSingleResult();
	
		}catch(NoResultException e){
			System.out.println("no result!");
		
		}catch(Exception e) {
			e.getMessage();
		}finally {
			if(em!=null)
				em.close();
		}
		return user;
	}
	
	public static Travel getTravelById(long id) {
		Travel result=null;
		EntityManager em=null;
		try {
		em=getEntityManager();
		
		Query query = em.createQuery("SELECT t FROM Travel t where id=:id");
		query.setParameter("id", id);
		result=(Travel)query.getSingleResult();
		
		}catch(NoResultException e){
			System.out.println("no result!");
		
		}catch(Exception e) {
			e.getMessage();
		}finally {
			if(em!=null)
				em.close();
		}
		return result;
		
	}
	
	public static List<Travel> getAllTravels() {
		List<Travel> result=null;
		EntityManager em=null;
		try {
		em=getEntityManager();
		
		Query query = em.createQuery("SELECT t FROM Travel t");
		
		result=(List<Travel>)query.getResultList();
		
		}catch(NoResultException e){
			System.out.println("no result!");
		
		}catch(Exception e) {
			e.getMessage();
		}finally {
			if(em!=null)
				em.close();
		}
		return result;
		
	}

	public static void createBooking(BookedTravel travel) {
		EntityManager em=getEntityManager();
		em.getTransaction().begin();
		em.persist(travel);
		em.getTransaction().commit();
		if(em.isOpen())
			em.close();
		
	}
	
	
	
}