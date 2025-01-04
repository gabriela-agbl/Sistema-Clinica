
package Clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuário 
{
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    int id_u;
           
    String login_u;
    String senha_u;
    String tipo_u;
    
    public String getLogin_u() {
        return login_u;
    }

    public void setlogin_u(String login_u) {
        this.login_u = login_u;
    }

    public String getSenha_u() {
        return senha_u;
    }

    public void setSenha_u(String senha_u) {
        this.senha_u = senha_u;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getTipo_u() {
        return tipo_u;
    }

    public void setTipo_u(String tipo_u) {
        this.tipo_u = tipo_u;
    }
    
    
    
    
}
