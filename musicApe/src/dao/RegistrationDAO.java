package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.ProfileDetails;
import model.User;

public class RegistrationDAO {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public boolean saveUserInDB(User user) {
		
		ProfileDetails profileDetails = new ProfileDetails();
			profileDetails.setUser(user);
			
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				session.persist(user); // cuvam usera UD
				session.persist(profileDetails); // cuvam if profileDetails koja je povezana sa Userom da bi se povezali sa FK
				System.out.println("User " +user.getUsername() +" is saved in DB");
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				
				System.out.println("Nesto je puklo u saveUserInDB metodi...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}

	}

	//@SuppressWarnings("unchecked")
	public User uniqueUsernameCheck(User userCheck) {
		
		User user = userCheck;
		List<User> localList = new ArrayList<>();
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				String hql = "from User where username = :usernameInput";
				Query query = session.createQuery(hql);
					query.setParameter("usernameInput", userCheck.getUsername());
				
				localList = (List<User>)query.getResultList();
				if(localList.isEmpty()) {
					System.out.println("username je unique...");
					session.getTransaction().commit();
					return user;
				}else {
					System.out.println("postoji vec taj username...");
					session.getTransaction().commit();
					user = null;
					return user;
				}
				
			} catch (Exception e) {
				System.out.println("nesto je puklo u uniqueUsernameCheck metodi");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}

}
