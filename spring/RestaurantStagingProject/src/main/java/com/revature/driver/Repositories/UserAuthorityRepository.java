package com.revature.driver.Repositories;

import com.revature.driver.Entities.UserAuthorities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends CrudRepository<UserAuthorities,String> {
    
}
