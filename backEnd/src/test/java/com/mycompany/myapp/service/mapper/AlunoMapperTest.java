package com.mycompany.myapp.service.mapper;

import static com.mycompany.myapp.domain.AlunoAsserts.*;
import static com.mycompany.myapp.domain.AlunoTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoMapperTest {

    private AlunoMapper alunoMapper;

    @BeforeEach
    void setUp() {
        alunoMapper = new AlunoMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getAlunoSample1();
        var actual = alunoMapper.toEntity(alunoMapper.toDto(expected));
        assertAlunoAllPropertiesEquals(expected, actual);
    }
}
