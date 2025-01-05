package com.Clinica.Clinica.controller;

import com.Clinica.Clinica.model.Profissional;
import com.Clinica.Clinica.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalRESTController 
{
    @Autowired
    private ProfissionalService profissionalService; 

    @PostMapping("/cadastrar")
    public ResponseEntity<Profissional> adicionarProfissional(@RequestBody Profissional profissional) 
    {
        var novoProfissional = profissionalService.adicionarProfissional(profissional);
        
        return new ResponseEntity<>(novoProfissional, HttpStatus.CREATED);
    }
}
