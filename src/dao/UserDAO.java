package dao;

import java.util.List;

import javax.persistence.Query;

import entity.User;
import utils.HibernateUtil;

public class UserDAO extends BaseDAO {
	public User findById(int id)
	{
		User user = this.hSession.find(User.class, id);

		return user;
	}
	
	public List<User> getAll()
	{
		String hql = "SELECT objectUser FROM User objectUser";
		Query query = this.hSession.createQuery(hql);
		List<User> result = query.getResultList();

		return result;
	}
	
	public User store(User user)
	{
		try {
			this.hSession.beginTransaction();
			
			Integer id = (Integer) this.hSession.save(user);
			user.setId(id);
			this.hSession.getTransaction().commit();
			System.out.println("id:" + id);
			return user;
		} catch (Exception e) {
			this.hSession.getTransaction().rollback();
			e.printStackTrace();
			
			return null;
		}
	}
}
