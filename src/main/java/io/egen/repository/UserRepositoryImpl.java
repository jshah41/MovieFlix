package io.egen.repository;

import io.egen.entity.User;
import io.egen.exception.UserBadAuthentication;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository

public class UserRepositoryImpl implements UserRepositroy {
	
	

	@PersistenceContext
	private EntityManager em;
	
	public UserRepositoryImpl(){
		
	}
	
	@Override
	@Transactional
	public List<User> findAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.email ASC", User.class);
    	List<User> users = query.getResultList();
    	return users;
	}

	@Override
	@Transactional
	public User findUserById(String id) {
		User user = em.find(User.class, id);
		return user;
	}

	@Override
    @Transactional
	public User findUserByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
    	query.setParameter("pEmail", email);
    	List<User> users = query.getResultList();
    	if(users != null && users.size() == 1) {
    		return users.get(0);
    	}
    	else {
    		return null;
    	}
	}

	@Override
    @Transactional
	public User createUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	@Transactional
	public User updateUser(User user) {
	
		return em.merge(user);
	}

	@Override
	@Transactional
	public User deleteUser (String id) {
		
		User user=em.find(User.class, id );
		em.remove(user);
		return user;
		
	}

	@Override
	public void authenticate(String password)throws UserBadAuthentication {
		
		Query q=em.createQuery("SELECT u FROM User u WHERE u.password=:password",User.class);
		q.setParameter("password", password);
		
		try{
			User user=(User) q.getSingleResult();
			if(password.equals(user.getPassword())){
				@SuppressWarnings("unused")
				boolean flag=true;
			}
			
		}catch(Exception e){
			throw new UserBadAuthentication();
		}
		
	}

	

	

	
}
