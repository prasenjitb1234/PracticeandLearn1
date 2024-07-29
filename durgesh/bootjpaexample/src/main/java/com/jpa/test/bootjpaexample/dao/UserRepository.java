package com.jpa.test.bootjpaexample.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.bootjpaexample.entities.User;

public interface UserRepository  extends CrudRepository<User,Integer>{

	
	
}
