/**
 * 
 */
package com.example.springredisexample;

import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springredisexample.entity.User;

/**
 * @author mahes
 *
 */
@Service
public class UserService {

	private UserRespository userRepository;
	
	public UserService(UserRespository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@CachePut(value="user", key="#user.getId()")
	public void save(User user) {
		// TODO Auto-generated method stub
     userRepository.save(user) ;
	}

	/* (non-Javadoc)
	 * @see com.example.springredisexample.repository.UserRepository#update(com.example.springredisexample.model.User)
	 */
	@CachePut(value="user", key="#user.getId()")
	public void update(User user) {
		// TODO Auto-generated method stub
        save(user);
	}

	/* (non-Javadoc)
	 * @see com.example.springredisexample.repository.UserRepository#delete(java.lang.String)
	 */

	@CacheEvict(value="user", key="#id")
	public void delete(String id) {
		// TODO Auto-generated method stub
      userRepository.delete(id);  
	}

	/* (non-Javadoc)
	 * @see com.example.springredisexample.repository.UserRepository#getUserById(java.lang.String)
	 */
 @Cacheable(value="user", key="#id")
	public User getUserById(String id) {
		// TODO Auto-generated method stub
	return userRepository.getOne(id);
	}

	

}
