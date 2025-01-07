package org.example.sptingsecurityauthorizationaaa.repository;

import org.example.sptingsecurityauthorizationaaa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}