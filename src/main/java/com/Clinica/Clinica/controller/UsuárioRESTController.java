package com.Clinica.Clinica.controller;

import com.Clinica.Clinica.model.Usuário;
import com.Clinica.Clinica.model.UsuárioRepository;
import com.Clinica.Clinica.service.UsuárioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuárioRESTController 
{
    @Autowired
    private UsuárioService usuarioService;
    
    @Autowired
    private UsuárioRepository usuarioRepository;

    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody Usuário usuario) 
    {
        boolean authenticated = usuarioService.authenticate(usuario.getUsername(), usuario.getPassword());
        if (authenticated) 
        {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } 
        
        else 
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }

    @GetMapping("/Login/{login_u}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) 
    {
        Optional<User> user = usuarioRepository.findByUsername(username);
        if (user.isPresent()) 
        {
            return ResponseEntity.ok(user.get());
        } 
        
        else 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
    }
}
