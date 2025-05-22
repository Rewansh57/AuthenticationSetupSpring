package org.example.springsecuritylearning2.project.repository;

import org.example.springsecuritylearning2.project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
