package com.deolit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deolit.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, String>{

	
}
