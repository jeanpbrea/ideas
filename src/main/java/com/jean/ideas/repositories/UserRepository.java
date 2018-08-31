package com.jean.ideas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jean.ideas.models.User;

public interface UserRepository  extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
