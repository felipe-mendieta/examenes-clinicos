package com.basededatos.laboratorio.principal.repository;


import com.basededatos.laboratorio.principal.entity.Area;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface AreaRepository  extends JpaRepository<Area, Long> {

    public List<Area> findByArea(Area staging);
}