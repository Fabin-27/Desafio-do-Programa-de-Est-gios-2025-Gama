package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Aluno;
import com.mycompany.myapp.service.dto.AlunoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Aluno} and its DTO {@link AlunoDTO}.
 */
@Mapper(componentModel = "spring")
public interface AlunoMapper extends EntityMapper<AlunoDTO, Aluno> {}
