package dao;

import entity.User;

public class UserDAO extends BaseDAO {
	public User findById(int id)
	{
		User user = this.hSession.find(User.class, id);

		return user;
	}
}
