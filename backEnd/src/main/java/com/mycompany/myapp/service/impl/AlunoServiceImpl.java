package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Aluno;
import com.mycompany.myapp.repository.AlunoRepository;
import com.mycompany.myapp.service.AlunoService;
import com.mycompany.myapp.service.dto.AlunoDTO;
import com.mycompany.myapp.service.mapper.AlunoMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.mycompany.myapp.domain.Aluno}.
 */
@Service
@Transactional
public class AlunoServiceImpl implements AlunoService {

    private static final Logger LOG = LoggerFactory.getLogger(AlunoServiceImpl.class);

    private final AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper;

    public AlunoServiceImpl(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    @Override
    public AlunoDTO save(AlunoDTO alunoDTO) {
        LOG.debug("Request to save Aluno : {}", alunoDTO);
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        aluno = alunoRepository.save(aluno);
        return alunoMapper.toDto(aluno);
    }

    @Override
    public AlunoDTO update(AlunoDTO alunoDTO) {
        LOG.debug("Request to update Aluno : {}", alunoDTO);
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        aluno = alunoRepository.save(aluno);
        return alunoMapper.toDto(aluno);
    }

    @Override
    public Optional<AlunoDTO> partialUpdate(AlunoDTO alunoDTO) {
        LOG.debug("Request to partially update Aluno : {}", alunoDTO);

        return alunoRepository
            .findById(alunoDTO.getId())
            .map(existingAluno -> {
                alunoMapper.partialUpdate(existingAluno, alunoDTO);

                return existingAluno;
            })
            .map(alunoRepository::save)
            .map(alunoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AlunoDTO> findOne(Long id) {
        LOG.debug("Request to get Aluno : {}", id);
        return alunoRepository.findById(id).map(alunoMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Aluno : {}", id);
        alunoRepository.deleteById(id);
    }
}
