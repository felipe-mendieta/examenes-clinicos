package com.basededatos.laboratorio.principal;


import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.entity.UnidadMedida;
import com.basededatos.laboratorio.principal.repository.PruebaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJdbcTest
public class PruebaRepositoryMockTest {

    @Autowired
private PruebaRepository pruebaRepository;

    @Test
public void findPruebaList(){

Prueba prueba01 = Prueba.builder().id(1L).titulo("Globulos Rojos").limiteInferior((float) 1).limiteSuperior((float) 5.0).precio(18.15)
        .area(Area.builder().id(1L).build())
        .unidadMedida(UnidadMedida.builder().id(1L).build()).build();

    pruebaRepository.save(prueba01);

    //List<Prueba> encontrados= pruebaRepository.findByArea(prueba01.getArea());

    //Assertions.assertThat(encontrados.size()).isEqualTo(1);


}
}
