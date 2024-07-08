package com.sunshine.co.BINI.STORE.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunshine.co.BINI.STORE.Model.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findByEmail(String email);
    Optional<UserAuth> findByUsername(String username);
    Optional<UserAuth> findByUsernameOrEmail(String email, String username);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);

    
}