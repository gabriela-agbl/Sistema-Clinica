
package Clinica.DAO;

import Clinica.JPA.JPAUtil;
import Clinica.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class ConsultaDao 
{
    public void cadastrar_c(Consulta c)
    {
        EntityManager em = JPAUtil.conectar();
        
        try
        {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }
        
        catch(Exception e)
        {
            em.getTransaction().rollback();
            throw e;
        }
        
        finally
        {
            JPAUtil.desconectar();
        }
    }
     
    public static List<Consulta> buscar_c(String receita_c)
    {
        List<Consulta> lista_c = new ArrayList<Consulta>();
        
        EntityManager em  =JPAUtil.conectar();
        
        try
        {
            Query consulta = em.createQuery("SELECT c FROM Consulta c WHERE (:receita_c is null OR c.receita_c LIKE :receita_c)");
            
            consulta.setParameter("receita_c", receita_c.isEmpty() ?null : "%" + receita_c +"%");
            
            lista_c = consulta.getResultList();
        }
        
        catch(Exception e)
        {
            System.out.println("Ocorreu um erro ao buscar a consulta");
            System.out.println(e);
        }
        
        finally
        {
            JPAUtil.desconectar();
        }
        
        return lista_c;
    }
    
    public List<Consulta> listar_c()
    {
        List<Consulta> lista_c = new ArrayList<Consulta>();
        
        EntityManager em = JPAUtil.conectar();
        
        try
        {
            Query consulta = em.createQuery("SELECT c FROM Consulta c");
            
            lista_c = consulta.getResultList();
        }
        
        catch(Exception e)
        {
           System.out.println("Ocorreu um erro ao listar as Consultas");
           System.out.println(e);
        }
        
        finally
        {
            JPAUtil.desconectar();
        }
        
       return lista_c;
    }
    
    public static void excluir_c(int numero_c)
    {
        EntityManager em= JPAUtil.conectar();
        
        try
        {
            em.getTransaction().begin();
            
            Consulta c = em.find(Consulta.class, numero_c);
            
            if(c != null)
            {
                em.remove(c);
            }
            
            em.getTransaction().commit();
        }
        
        catch(Exception e)
        {
            System.out.println("Ocorreu um erro ao excluir a Consulta");
            System.out.println(e);
        }
        
        finally
        {
          JPAUtil.desconectar();
        }
    }
    
    
}
