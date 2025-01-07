package com.Clinica.Clinica.controller;

import com.Clinica.Clinica.model.Consulta;
import com.Clinica.Clinica.model.Paciente;
import com.Clinica.Clinica.model.Profissional;
import com.Clinica.Clinica.service.ConsultaService;
import com.Clinica.Clinica.service.PacienteService;
import com.Clinica.Clinica.service.ProfissionalService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.List;
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
        List<Consulta> consultas = consultaService.listarConsultas();
        model.addAttribute("listarConsultas", consultas);
        return "Lista";
    } 

    @GetMapping("/excluir/consulta/{numero_c}")
    public String deletarConsulta(@PathVariable(value = "numero_c") Integer numero_c) 
    {
        consultaService.deletarConsulta(numero_c);
        return "redirect:/lista";
    } 

    @GetMapping("/cadastrar/consulta")
    public String exibirFormularioCadastro(Model model) 
    {
        model.addAttribute("consulta", new Consulta());
        return "Consulta";
    } 

    @PostMapping("/cadastrar/consulta")
    public String cadastrarConsulta(@Valid @ModelAttribute("consulta") Consulta consulta, BindingResult result, Model model) 
    {
        if (result.hasErrors()) 
        {
            model.addAttribute("consulta, consulta");
            return "Consulta";
        } 
    
        if (consulta.getNumero_c() == null) 
        {
            consultaService.adicionarConsulta(consulta);
        } 
      
        return "redirect:/lista";

    }
    
    @GetMapping("/cadastrar/paciente")
    public String exibirFormularioCadastroP(Model model) 
    {
        model.addAttribute("paciente", new Paciente());
        return "Paciente";
    } 

    @PostMapping("/cadastrar/paciente")
    public String cadastrarPaciente(@Valid @ModelAttribute("paciente") Paciente paciente, BindingResult result, Model model) 
    {
        if (result.hasErrors()) 
        {
            model.addAttribute("paciente", paciente);
            return "Paciente";
        } 
    
        if (paciente.getId_p() == null) 
        {
            pacienteService.adicionarPaciente(paciente);
        } 
      
        return "redirect:/Menu";

    }
    
    @GetMapping("/cadastrar/profissional")
    public String exibirFormularioCadastroPR(Model model) 
    {
        model.addAttribute("profissional", new Profissional());
        return "Profissional";
    } 

    @PostMapping("/cadastrar/profissional")
    public String cadastrarProfissional(@Valid @ModelAttribute("paciente") Profissional profissional, BindingResult result, Model model) 
    {
        if (result.hasErrors()) 
        {
            model.addAttribute("profissional", profissional);
            return "Profissional";
        } 
    
        if (profissional.getId_pr() == null) 
        {
            profissionalService.adicionarProfissional(profissional);
        } 
      
        return "redirect:/Menu";

    }
    
    @GetMapping("/Menu")
    public String PáginaMenu(HttpSession session, Model model) 
    {
        return "Menu";  
    }
}
