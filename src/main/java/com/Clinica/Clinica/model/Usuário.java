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
    private String username;
    private String password;
    
    public Integer getId_u() {
        return id_u;
    }

    public void setId_u(Integer id_u) {
        this.id_u = id_u;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
