package com.Clinica.Clinica.service;

import com.Clinica.Clinica.model.Profissional;
import com.Clinica.Clinica.model.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService 
{
    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Profissional adicionarProfissional(Profissional profissional) 
    {
        profissional.setId_pr(null);
        
        profissionalRepository.save(profissional);
        
        return profissional;
    }

    public Profissional getProfissionalById(Integer id_pr) 
    {
        return profissionalRepository.findById(id_pr).orElse(null);
    }
}
