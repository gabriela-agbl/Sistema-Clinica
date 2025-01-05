package com.Clinica.Clinica.service;

import com.Clinica.Clinica.model.Usuário;
import com.Clinica.Clinica.model.UsuárioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuárioService 
{
    @Autowired
    private UsuárioRepository usuarioRepository;

    public Usuário getUsuarioById(Integer id_u) 
    {
        return usuarioRepository.findById(id_u).orElse(null);
    }
}
