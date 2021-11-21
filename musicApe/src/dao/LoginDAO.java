package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class LoginDAO {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public User usernamePassCheck(String username, String password) {
		
		User user = null;
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				String hql = "from User where username = :usernameInput and password = :passwordInput";
				Query query = session.createQuery(hql);
					query.setParameter("usernameInput", username);
					query.setParameter("passwordInput", password);
					
				user = (User)query.getSingleResult();
				if(user != null) {
					System.out.println("pronadjen user");
					session.getTransaction().commit();
					return user;
				}else {
					System.out.println("nije pronadjen user");
					session.getTransaction().commit();
					return null;
				}
				
			} catch (Exception e) {
				System.out.println("Nesto je puklo u usernamePassCheck metodi...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}

}
