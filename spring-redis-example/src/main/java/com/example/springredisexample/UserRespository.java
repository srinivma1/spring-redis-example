package com.example.springredisexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springredisexample.entity.User;

@Repository
public interface UserRespository extends JpaRepository<User, String> {

	

}
