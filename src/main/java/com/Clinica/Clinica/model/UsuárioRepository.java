package com.Clinica.Clinica.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuárioRepository extends JpaRepository<Usuário, Integer>
{
    
}
