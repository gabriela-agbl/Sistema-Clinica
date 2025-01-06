package com.Clinica.Clinica.model;

import java.util.Optional;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuárioRepository extends JpaRepository<Usuário, Integer>
{
    Optional<User> findByUsername(String username);
}
