
package Clinica.DAO;

import Clinica.JPA.JPAUtil;
import Clinica.model.*;
import jakarta.persistence.EntityManager;

public class ProfissionalDao 
{
     public void cadastrar_pr(Profissional pr)
    {
        EntityManager em = JPAUtil.conectar();
        
        try
        {
            em.getTransaction().begin();
            em.persist(pr);
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
}
