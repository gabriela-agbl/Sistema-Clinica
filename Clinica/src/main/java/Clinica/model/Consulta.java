
package Clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consulta 
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    int numero_c;
    
    String data_c;
    int id_p;
    int id_pr;
    String receita_c;
    boolean feita;

    public int getNumero_c() {
        return numero_c;
    }

    public void setNumero_c(int numero_c) {
        this.numero_c = numero_c;
    }

    public String getData_c() {
        return data_c;
    }

    public void setData_c(String data_c) {
        this.data_c = data_c;
    }

    public int getId_pr() {
        return id_pr;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getReceita_c() {
        return receita_c;
    }

    public void setReceita_c(String receita_c) {
        this.receita_c = receita_c;
    }

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }
    
    
    
    
}
