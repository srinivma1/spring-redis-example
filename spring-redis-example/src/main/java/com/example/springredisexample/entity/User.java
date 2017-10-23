/**
 * 
 */
package com.example.springredisexample.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author mahes
 *
 */
@Entity
public class User implements Serializable{
	
	public User() {
		
		
	}
	public User(String id, String userName) {
	
		this.id = id;
		this.userName = userName;
	}
	
	@Id
  
	private String id;
	
	

	private String userName;



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}



	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	

}
