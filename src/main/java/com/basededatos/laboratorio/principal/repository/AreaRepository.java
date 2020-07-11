package com.basededatos.laboratorio.principal.repository;


import com.basededatos.laboratorio.principal.entity.Area;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface AreaRepository  extends JpaRepository<Area, Long> {



    Area findByNombreContaining(String nombre);


}