package com.niit.dao;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionfactory;
	public User registerUser(User user){
		Session session=sessionfactory.openSession();
		
		Transaction trans=session.beginTransaction();
		session.save(user);
		trans.commit();
		session.close();
	return user;
}
	

	public User login(User user) {
		Session session=sessionfactory.openSession();
		Transaction trans=session.beginTransaction();
		//select * from user_batch15 where username=user.getUsername() and password=user.getPassword()
		Query query=session.createQuery(
"from User where username=? and password=?");
		//from user where username='john' and password='123'
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		User validUser=(User)query.uniqueResult();
		trans.commit();
		return validUser;
	}

	
	public void updateUser(User validUser) {
		Session session=sessionfactory.openSession();
		Transaction trans=session.beginTransaction();
		//update user_batch15 set username=?,password=?,email=?,enabled=?,online=? where id=?
		session.update(validUser);
		session.flush();
		trans.commit();
		session.close();
		
	}
}
