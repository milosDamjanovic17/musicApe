package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.ProfileDetails;
import model.User;

public class EditProfileDAO {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	
	public User returnUserFromID(String id) {
		User user = null;
		int idInt = Integer.parseInt(id);
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				String hql = "from User where id = :idInput";
				Query query = session.createQuery(hql);
					query.setParameter("idInput", idInt);
					
				user = (User)query.getSingleResult();
				System.out.println("Retrieving user" +user.getUsername() +" from DB");
				session.getTransaction().commit();
				return user;
			} catch (Exception e) {
				System.out.println("nesto je puklo u metodi returnUserFromID");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}


	public ProfileDetails returnProfileDetailsFromUser(User user) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				ProfileDetails persistedUserFromDB = session.get(ProfileDetails.class, user.getId());
				System.out.println("Retrieving from ProfileDetails...");
				session.getTransaction().commit();
				return persistedUserFromDB;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u returnProfileDetailsFromUser metodi...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}


	public boolean updateProfileDetails(String name, String djName, String description, String soundcloud, String genre,
			ProfileDetails details) {
		Session session = sf.openSession();
			session.beginTransaction();
		
			try {
				
				ProfileDetails profileFromDB = session.get(ProfileDetails.class, details.getIdProfileDetails());
				
				profileFromDB.setName(name);
				profileFromDB.setDjName(djName);
				profileFromDB.setDescription(description);
				profileFromDB.setSoundCloudURL(soundcloud);
				profileFromDB.setGenre(genre);
				
				session.update(profileFromDB);
				System.out.println("Updating ProfileDetails.....");
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u metodi updateProfileDetails.....");
				e.printStackTrace();
				return false;
			} finally {
				session.close();
			}

	}

}
