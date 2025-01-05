package com.Clinica.Clinica.service;

import com.Clinica.Clinica.model.Paciente;
import com.Clinica.Clinica.model.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService 
{
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente adicionarPaciente(Paciente paciente) 
    {
        paciente.setId_p(null);
        
        pacienteRepository.save(paciente);
        
        return paciente;
    }

    public Paciente getPacienteById(Integer id_p) 
    {
        return pacienteRepository.findById(id_p).orElse(null);
    }
}
