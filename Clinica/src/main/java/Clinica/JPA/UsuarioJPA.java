
package Clinica.JPA;

import Clinica.model.*;
import jakarta.persistence.EntityManager;
import java.util.List;


public class UsuarioJPA 
{
    public static Usuário validarU(Usuário u)
    {
        EntityManager em = JPAUtil.conectar();
        
        try
        {
            List<Usuário> usuarioEncontrado = em
                    .createQuery("SELECT u FROM Usuário u WHERE u.login_u = :login_u AND u.senha_u = :senha_u", Usuário.class)
                    .setParameter("login_u", u.getLogin_u())
                    .setParameter("senha_u", u.getSenha_u())
                    .getResultList();
                    
            if(!usuarioEncontrado.isEmpty())   
            {
                System.out.println("Usuário encontrado");
                
                return usuarioEncontrado.get(0);
            }
            
            else
            {
                System.out.println("Nenhum usuário encontrado");
            }
             
        }
        
        catch(Exception e)
            {
                System.out.println("Erro ao buscar usuário");
                System.out.println(e);
            }
        
        finally
        {
            JPAUtil.desconectar();
        }
        
        return null;
    }
    
    
    
}
