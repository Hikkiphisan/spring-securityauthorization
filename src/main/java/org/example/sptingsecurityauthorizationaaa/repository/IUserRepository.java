package org.example.sptingsecurityauthorizationaaa.repository;

import org.example.sptingsecurityauthorizationaaa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}