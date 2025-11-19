package io.eduardnol.direccions.service;

import io.eduardnol.direccions.dto.ComboCodeDTO;
import io.eduardnol.direccions.entity.PaisEntity;
import io.eduardnol.direccions.mapper.PaisMapper;
import io.eduardnol.direccions.repository.PaisRepository;
import io.eduardnol.direccions.service.impl.DireccioServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DireccioServiceTest {

    @Mock
    private PaisRepository paisRepository;

    @Mock
    private PaisMapper paisMapper;

    @InjectMocks
    private DireccioServiceImpl direccioService;

    @Test
    void getAllPais_ShouldReturnListOfCountries() {
        // Given
        PaisEntity pais1 = PaisEntity.builder()
                .idPais(1L)
                .codi("ESP")
                .nom("España")
                .build();

        PaisEntity pais2 = PaisEntity.builder()
                .idPais(2L)
                .codi("FRA")
                .nom("Francia")
                .build();

        ComboCodeDTO combo1 = ComboCodeDTO.builder()
                .key(1L)
                .code("ESP")
                .value("España")
                .build();

        ComboCodeDTO combo2 = ComboCodeDTO.builder()
                .key(2L)
                .code("FRA")
                .value("Francia")
                .build();

        when(paisRepository.findAll()).thenReturn(Arrays.asList(pais1, pais2));
        when(paisMapper.toDTOComboCode(pais1)).thenReturn(combo1);
        when(paisMapper.toDTOComboCode(pais2)).thenReturn(combo2);

        // When
        List<ComboCodeDTO> result = direccioService.getAllPais();

        // Then
        assertEquals(2, result.size());
        assertEquals("ESP", result.get(0).getCode());
        assertEquals("España", result.get(0).getValue());
    }
}

