package com.Clinica.Clinica.service;

import com.Clinica.Clinica.model.UsuárioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class UsuárioService 
{
    @Autowired
    private UsuárioRepository usuarioRepository;

    public boolean authenticate(String username, String password) 
    {
        Optional<User> userOpt = usuarioRepository.findByUsername(username);
        
        if (userOpt.isPresent()) 
        {
            User user = userOpt.get();
            
            return user.getPassword().equals(password); // Comparando senha simples
        }
        
        return false;
    }

}
