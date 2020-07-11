package com.basededatos.laboratorio.principal.repository;

import com.basededatos.laboratorio.principal.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    public List<Orden> findByIdPaciente(String idPaciente);

    @Query(value="select ord from Orden ord where ord.idPaciente=?1 order by create_at desc limit 1", nativeQuery = true)
    public Orden findAllByIdPacienteLast(String idPaciente);


}
