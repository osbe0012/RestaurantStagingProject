package com.revature.driver.Repositories;

import java.util.List;

import com.revature.driver.Entities.UserAuthorities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends CrudRepository<UserAuthorities,String> {
    
    
    @Query("select ua from user_authorities ua where ua.username = ?1")
    public List<UserAuthorities> findAllById(String username);
}
