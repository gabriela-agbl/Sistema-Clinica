package com.Clinica.Clinica.controller;

import com.Clinica.Clinica.model.Paciente;
import com.Clinica.Clinica.service.PacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/")
    public ResponseEntity<List> listarPacientes() 
    {
        List<Paciente> paciente = pacienteService.listarPacientes();
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Paciente> adicionarPaciente(@RequestBody Paciente paciente) 
    {
        var novoPaciente = pacienteService.adicionarPaciente(paciente);
        
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
    }
}
