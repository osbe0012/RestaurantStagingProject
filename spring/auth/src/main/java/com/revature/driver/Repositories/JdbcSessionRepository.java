package com.revature.driver.Repositories;


import org.springframework.session.MapSession;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcSessionRepository extends SessionRepository<MapSession> {
    
}

