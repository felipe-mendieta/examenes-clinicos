package com.basededatos.laboratorio.principal;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.entity.Prueba;
import com.basededatos.laboratorio.principal.entity.UnidadMedida;
import com.basededatos.laboratorio.principal.repository.AreaRepository;
import com.basededatos.laboratorio.principal.repository.PruebaRepository;
import com.basededatos.laboratorio.principal.repository.UnidadMedidaRepository;
import com.basededatos.laboratorio.principal.service.*;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AreaServicesMockTest {

    @Mock
    private AreaRepository areaRepository;

    @Mock
    private PruebaRepository pruebaRepository;

    @Mock
    private UnidadMedidaRepository unidadMedidaRepository;

    private PruebaService pruebaService;

    private AreaService areaService;

    private UnidadMedidaService unidadMedidaService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        areaService = new AreaServiceImpl(areaRepository);
        pruebaService= new PruebaServiceImpl(pruebaRepository);
        unidadMedidaService = new UnidadMedidaServiceImpl(unidadMedidaRepository);

        UnidadMedida ug= UnidadMedida.builder().id(1L).unidadDeMedida("ug").build();
        Area sangre = Area.builder().id(1L).nombre("Sangre").status("nuevo").build();
        Prueba globulosRojos = Prueba.builder().id(1L).limiteInferior(1F).limiteSuperior(5F)
                .precio(18.5).titulo("Globulos Rojos").area(areaService.findByNombre("Sangre")).unidadMedida(unidadMedidaService.getUnidadMedida(1L)).build();


        Mockito.when(areaRepository.findById(1L)).thenReturn(Optional.of(sangre));
        Mockito.when(areaRepository.findByNombreContaining("Sangre")).thenReturn(Optional.of(sangre).orElse(null));
        Mockito.when(pruebaRepository.findByTitulo("Globulos Rojos").get(0)).thenReturn(Optional.of(globulosRojos).orElse(null));
    }


    @Test
    public void whenValidateGetID_ThenReturnArea(){
        Prueba encontrado = pruebaService.findbyTitulo("Globulos").get(0);
        System.out.println(encontrado.getArea());

        Assertions.assertThat(encontrado.getId().equals("Sangre"));
    }




}
