package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Szallas;
import model.User;
import javax.persistence.*;


public class PersistenceManager {

	static User getUserByName() {
		User user=null;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("TravelAgencyJpa");
		EntityManager em=emf.createEntityManager();
		
		
		
		
		em.close();
		return user;
	}
	
	public void createUser(User user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("TravelAgencyJpa");
		EntityManager em=emf.createEntityManager();
		em.persist(user);
		em.close();
	}
	
	public void createSzallas(Szallas szallas) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("TravelAgencyJpa");
		EntityManager em=emf.createEntityManager();
		em.persist(szallas);
		em.close();
	}
}