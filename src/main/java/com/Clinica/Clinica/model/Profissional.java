package com.Clinica.Clinica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Profissional")
public class Profissional 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pr; 
    private String nome_pr;
    private String cpf_pr;
    private String ende_pr;
    private int idade_pr;
    private String telefone_pr;
    private String especialidade_pr;
    
    public Integer getId_pr() {
        return id_pr;
    }

    public void setId_pr(Integer id_pr) {
        this.id_pr = id_pr;
    }

    public String getNome_pr() {
        return nome_pr;
    }

    public void setNome_pr(String nome_pr) {
        this.nome_pr = nome_pr;
    }

    public String getCpf_pr() {
        return cpf_pr;
    }

    public void setCpf_pr(String cpf_pr) {
        this.cpf_pr = cpf_pr;
    }

    public String getEnde_pr() {
        return ende_pr;
    }

    public void setEnde_pr(String ende_pr) {
        this.ende_pr = ende_pr;
    }

    public int getIdade_pr() {
        return idade_pr;
    }

    public void setIdade_pr(int idade_pr) {
        this.idade_pr = idade_pr;
    }

    public String getTelefone_pr() {
        return telefone_pr;
    }

    public void setTelefone_pr(String telefone_pr) {
        this.telefone_pr = telefone_pr;
    }

    public String getEspecialidade_pr() {
        return especialidade_pr;
    }

    public void setEspecialidade_pr(String especialidade_pr) {
        this.especialidade_pr = especialidade_pr;
    }
}
