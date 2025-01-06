package com.Clinica.Clinica.controller;

import com.Clinica.Clinica.model.Consulta;
import com.Clinica.Clinica.model.Paciente;
import com.Clinica.Clinica.model.Profissional;
import com.Clinica.Clinica.service.ConsultaService;
import com.Clinica.Clinica.service.PacienteService;
import com.Clinica.Clinica.service.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClinicaController 
{
    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ProfissionalService profissionalService;
    
    @GetMapping("/lista")
    public String listarConsultas(Model model) 
    {
        model.addAttribute("listarConsultas", consultaService.listarConsultas());
        return "Lista";
    } 

    @GetMapping("/excluir/consulta/{numero_c}")
    public String deletarConsulta(@PathVariable(value = "numero_c") Integer numero_c) 
    {
        consultaService.deletarConsulta(numero_c);
        return "redirect:/";
    } 

    @GetMapping("/cadastrar/consulta")
    public String exibirFormularioCadastro(Model model) 
    {
        Consulta consulta = new Consulta();
        model.addAttribute("consulta", consulta);
        return "Consulta";
    } 

    @PostMapping("/cadastrar/consulta")
    public String cadastrarConsulta(@Valid @ModelAttribute("consulta") Consulta consulta, BindingResult result) 
    {
        if (result.hasErrors()) 
        {
            return "Consulta";
        } 
    
        if (consulta.getNumero_c() == null) 
        {
            consultaService.adicionarConsulta(consulta);
        } 
      
        return "redirect:/";

    }
    
    @GetMapping("/cadastrar/paciente")
    public String exibirFormularioCadastroP(Model model) 
    {
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente);
        return "Paciente";
    } 

    @PostMapping("/cadastrar/paciente")
    public String cadastrarPaciente(@Valid @ModelAttribute("paciente") Paciente paciente, BindingResult result) 
    {
        if (result.hasErrors()) 
        {
            return "Paciente";
        } 
    
        if (paciente.getId_p() == null) 
        {
            pacienteService.adicionarPaciente(paciente);
        } 
      
        return "redirect:/";

    }
    
    @GetMapping("/cadastrar/profissional")
    public String exibirFormularioCadastroPR(Model model) 
    {
        Profissional profissional = new Profissional();
        model.addAttribute("profissional", profissional);
        return "Profissional";
    } 

    @PostMapping("/cadastrar/profissional")
    public String cadastrarProfissional(@Valid @ModelAttribute("profissional") Profissional profissional, BindingResult result) 
    {
        if (result.hasErrors()) 
        {
            return "Profissional";
        } 
    
        if (profissional.getId_pr() == null) 
        {
            profissionalService.adicionarProfissional(profissional);
        } 
      
        return "redirect:/";

    }
    
}
