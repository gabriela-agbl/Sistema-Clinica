package com.Clinica.Clinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "Consulta")
public class Consulta 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero_c; 
    @NotNull(message = "A data da consulta é obrigatória.")
    @Future(message = "A data da consulta deve ser no futuro.")
    private String data_c;
    private String receita_c;
    @NotNull(message = "O status da consulta é obrigatório.")
    private Boolean feita;
    @NotNull(message = "O paciente é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "id_p")
    private Paciente paciente;
    @NotNull(message = "O profissional é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "id_pr")
    private Profissional profissional;
    
    public Integer getNumero_c() {
        return numero_c;
    }

    public void setNumero_c(Integer numero_c) {
        this.numero_c = numero_c;
    }

    public String getData_c() {
        return data_c;
    }

    public void setData_c(String data_c) {
        this.data_c = data_c;
    }

    public String getReceita_c() {
        return receita_c;
    }

    public void setReceita_c(String receita_c) {
        this.receita_c = receita_c;
    }

    public Boolean getFeita() {
        return feita;
    }

    public void setFeita(Boolean feita) {
        this.feita = feita;
    } 
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    } 
    
    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    } 
        
}
