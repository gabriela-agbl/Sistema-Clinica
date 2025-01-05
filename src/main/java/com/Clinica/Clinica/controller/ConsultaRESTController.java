package com.Clinica.Clinica.controller;

import com.Clinica.Clinica.model.Consulta;
import com.Clinica.Clinica.service.ConsultaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaRESTController 
{
    @Autowired
    private ConsultaService consultaService; 

    @GetMapping("/")
    public ResponseEntity<List> listarConsultas() 
    {
        List<Consulta> consulta = consultaService.listarConsultas();
        return new ResponseEntity<>(consulta, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Consulta> adicionarConsulta(@RequestBody Consulta consulta) 
    {
        var novaConsulta = consultaService.adicionarConsulta(consulta);
        
        return new ResponseEntity<>(novaConsulta, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/excluir/{numero_c}")
    public ResponseEntity deletarConsulta(@PathVariable Integer numero_c) 
    {
        consultaService.deletarConsulta(numero_c);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
