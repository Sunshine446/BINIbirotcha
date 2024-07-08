package com.sunshine.co.BINI.STORE.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunshine.co.BINI.STORE.Model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
    
}
