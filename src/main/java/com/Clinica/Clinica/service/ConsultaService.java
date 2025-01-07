package com.Clinica.Clinica.service;

import com.Clinica.Clinica.model.Consulta;
import com.Clinica.Clinica.model.ConsultaRepository;
import com.Clinica.Clinica.model.Paciente;
import com.Clinica.Clinica.model.Profissional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ConsultaService 
{
    private final ConsultaRepository consultaRepository;
    
    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) 
    {
        this.consultaRepository = consultaRepository;
    }
    
    public Consulta adicionarConsulta(Consulta consulta) 
    {
        consulta.setNumero_c(null);
        
        consultaRepository.save(consulta);
        
        return consulta;
    }

    public List<Consulta> listarConsultas() 
    {
        return consultaRepository.findAll();
    }
   
    public Consulta getConsultaById(Integer numero_c) 
    {
        return consultaRepository.findById(numero_c).orElse(null);
    }
    
    public List<Consulta> getConsultaByPaciente(Paciente id_p) 
    {
        return consultaRepository.findByPaciente(id_p);
    }
    
    public List<Consulta> getConsultaByProfissional(Profissional id_pr) 
    {
        return consultaRepository.findByProfissional(id_pr);
    }
    
    public void deletarConsulta(Integer numero_c) 
    {
        Consulta consulta = getConsultaById(numero_c);
        consultaRepository.deleteById(consulta.getNumero_c());
    }
}
