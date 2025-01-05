package com.Clinica.Clinica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Paciente")
public class Paciente 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_p; 
    private String nome_p;
    private String cpf_p;
    private String ende_p;
    private int idade_p;
    private String telefone_p;
    private String convenio_p;
    
    public Integer getId_p() {
        return id_p;
    }

    public void setId_p(Integer id_p) {
        this.id_p = id_p;
    }

    public String getNome_p() {
        return nome_p;
    }

    public void setNome_p(String nome_p) {
        this.nome_p = nome_p;
    }

    public String getCpf_p() {
        return cpf_p;
    }

    public void setCpf_p(String cpf_p) {
        this.cpf_p = cpf_p;
    }

    public String getEnde_p() {
        return ende_p;
    }

    public void setEnde_p(String ende_p) {
        this.ende_p = ende_p;
    }

    public int getIdade_p() {
        return idade_p;
    }

    public void setIdade_p(int idade_p) {
        this.idade_p = idade_p;
    }

    public String getTelefone_p() {
        return telefone_p;
    }

    public void setTelefone_p(String telefone_p) {
        this.telefone_p = telefone_p;
    }

    public String getConvenio_p() {
        return convenio_p;
    }

    public void setConvenio_p(String convenio_p) {
        this.convenio_p = convenio_p;
    }
}
