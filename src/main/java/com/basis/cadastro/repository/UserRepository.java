package com.basis.cadastro.repository;

import com.basis.cadastro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
