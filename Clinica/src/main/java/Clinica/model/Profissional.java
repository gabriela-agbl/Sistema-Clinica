
package Clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profissional 
{
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    int id_pr;
           
    String nome_pr;
    String cpf_pr;
    String ende_pr;
    int idade_pr;
    String telefone_pr;
    String especialidade_pr;
    
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

    public void setEspecialidade_pr(String profissao_pr) {
        this.especialidade_pr = profissao_pr;
    }

    public int getId_pr() {
        return id_pr;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
    }
    
    
   
    
}