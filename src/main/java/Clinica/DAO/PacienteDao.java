
package Clinica.DAO;
import Clinica.JPA.JPAUtil;
import Clinica.model.*;
import jakarta.persistence.EntityManager;

public class PacienteDao 
{
    public void cadastrar_p(Paciente p)
    {
        EntityManager em = JPAUtil.conectar();
        
        try
        {
            em.getTransaction().begin();
            em.persist(p);
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
