package com.revature.driver.Repositories;

import com.revature.driver.Entities.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {

    public Users findByUsername(String username);
    
}
