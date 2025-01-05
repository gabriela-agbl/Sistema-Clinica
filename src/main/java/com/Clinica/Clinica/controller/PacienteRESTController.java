package com.Clinica.Clinica.controller;

import com.Clinica.Clinica.model.Paciente;
import com.Clinica.Clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteRESTController 
{
    @Autowired
    private PacienteService pacienteService; 

    @PostMapping("/cadastrar")
    public ResponseEntity<Paciente> adicionarPaciente(@RequestBody Paciente paciente) 
    {
        var novoPaciente = pacienteService.adicionarPaciente(paciente);
        
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
    }
}
