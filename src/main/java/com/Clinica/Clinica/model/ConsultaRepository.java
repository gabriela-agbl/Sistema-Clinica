package com.Clinica.Clinica.model;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>
{

    public List<Consulta> findByPaciente(Paciente id_p);

    public List<Consulta> findByProfissional(Profissional id_pr);
    
}
