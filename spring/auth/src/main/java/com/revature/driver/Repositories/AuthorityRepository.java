package com.revature.driver.Repositories;

import com.revature.driver.Entities.Authority;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
/** The Authority Repository is used to fetch Authority Entities from the db. */
public interface AuthorityRepository extends CrudRepository<Authority,String> {
    
}
