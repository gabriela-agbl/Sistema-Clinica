
package Clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paciente 
{
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    int id_p;
           
    String nome_p;
    String cpf_p;
    String ende_p;
    int idade_p;
    String telefone_p;
    String convenio_p;
    
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
    
    public String getConvenio_p()
    {
        return convenio_p;
    }
    
    public void setConvenio_p(String convenio_p)
    {
        this.convenio_p= convenio_p;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }
    

}
