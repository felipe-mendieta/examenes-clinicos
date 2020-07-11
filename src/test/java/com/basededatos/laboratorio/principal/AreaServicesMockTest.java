package com.basededatos.laboratorio.principal;

import com.basededatos.laboratorio.principal.entity.Area;
import com.basededatos.laboratorio.principal.repository.AreaRepository;
import com.basededatos.laboratorio.principal.service.AreaService;
import com.basededatos.laboratorio.principal.service.AreaServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class AreaServicesMockTest {

    @Mock
    private AreaRepository areaRepository;

    private AreaService areaService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        areaService = new AreaServiceImpl(areaRepository);
        Area sangre = Area.builder().id(1L).nombre("Sangre").status("nuevo").build();

        Mockito.when(areaRepository.findById(1L)).thenReturn(Optional.of(sangre));
        Mockito.when(areaRepository.findByNombreContaining("Sangre")).thenReturn(Optional.of(sangre).orElse(null));
    }


    @Test
    public void whenValidateGetID_ThenReturnArea(){
        Area encontrado = areaService.findByNombre("Sangre");
        System.out.println(encontrado.getId());

        Assertions.assertThat(encontrado.getId().equals("1"));
    }




}
