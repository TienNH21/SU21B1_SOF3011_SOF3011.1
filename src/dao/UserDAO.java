package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.User;
import utils.HashUtil;
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
	
	public boolean update(User entity) {
		try {
			this.hSession.beginTransaction();
			
			this.hSession.merge(entity);
			
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			this.hSession.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(User entity) {
		try {
			this.hSession.beginTransaction();
			this.hSession.remove(entity);
			this.hSession.flush();
			this.hSession.getTransaction().commit();
			return true;
		} catch (Exception e) {
			this.hSession.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	public User login(String email, String password)
	{
		TypedQuery<User> query = this.hSession.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("email", email);
		User entity = query.getSingleResult();

		boolean checkPwd = HashUtil.verify(password, entity.getPassword());
		if (checkPwd == false) {
			return null;
		}
		
		return entity;
	}
}
