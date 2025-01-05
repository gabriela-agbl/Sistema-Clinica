package com.Clinica.Clinica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuário")
public class Usuário 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_u; 
    private String login_u;
    private String senha_u;
    private String tipo_u;
    
    public Integer getId_u() {
        return id_u;
    }

    public void setId_u(Integer id_u) {
        this.id_u = id_u;
    }

    public String getLogin_u() {
        return login_u;
    }

    public void setLogin_u(String login_u) {
        this.login_u = login_u;
    }

    public String getSenha_u() {
        return senha_u;
    }

    public void setSenha_u(String senha_u) {
        this.senha_u = senha_u;
    }

    public String getTipo_u() {
        return tipo_u;
    }

    public void setTipo_u(String tipo_u) {
        this.tipo_u = tipo_u;
    }
}
