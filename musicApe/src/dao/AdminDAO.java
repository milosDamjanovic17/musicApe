package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class AdminDAO {

	
	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	@SuppressWarnings("unchecked")
	public List<User> returnAllUsers() {
		
		List<User> localList = new ArrayList<>();
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				String hql = "from User";
				Query query = session.createQuery(hql);
				localList = (List<User>)query.getResultList();
				System.out.println("preuzimam sve usere...");
				
				session.getTransaction().commit();
				return localList;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u returnAllUsers metodi...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}
	
	
	
	
	
	
	
}
