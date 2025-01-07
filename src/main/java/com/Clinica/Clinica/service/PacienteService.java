package com.Clinica.Clinica.service;

import com.Clinica.Clinica.model.Paciente;
import com.Clinica.Clinica.model.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService 
{
    private final PacienteRepository pacienteRepository;
    
    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) 
    {
        this.pacienteRepository = pacienteRepository;
    }
    
    public List<Paciente> listarPacientes() 
    {
        return pacienteRepository.findAll();
    }

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
