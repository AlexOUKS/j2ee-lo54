package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities.User;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.helpers.SessionFactoryHelper;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.validators.Validators;

public class UserRepository extends Repository {
	private static Class className = User.class;
	private static UserRepository instance;

	public static UserRepository getInstance() {
		if(instance == null)
			instance = new UserRepository();
		return instance;
	}
	
	public User getUser(String login) {
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		List<User> user;
		try {
			Query<User> qry = session.createQuery("from User u where u.username = ?");
			qry.setParameter(0, login);
			user = qry.list();
		} finally {
			session.close();
		}
		
		if (Validators.isArrayEmpty(user)) {
			return null;
		} else {
			return user.get(0);
		}
	}

	public List<User> getUsersFromSession(Integer sessionId) {
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		List<User> users;
		try {
			Query<User> qry = session.createQuery("select u.userId from User u, Session s where s.id = ? and s in elements(u.sessions)");
			qry.setParameter(0, sessionId);
			users = qry.list();
		} finally {
			session.close();
		}
		
		if (Validators.isArrayEmpty(users)) {
			return null;
		} else {
			return users;
		}
	}
	@Override
	protected Class getClassName()
	{
		return className;
	}
}
