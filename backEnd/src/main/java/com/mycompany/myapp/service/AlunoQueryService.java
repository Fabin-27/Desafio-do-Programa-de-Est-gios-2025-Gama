package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.*; // for static metamodels
import com.mycompany.myapp.domain.Aluno;
import com.mycompany.myapp.repository.AlunoRepository;
import com.mycompany.myapp.service.criteria.AlunoCriteria;
import com.mycompany.myapp.service.dto.AlunoDTO;
import com.mycompany.myapp.service.mapper.AlunoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Aluno} entities in the database.
 * The main input is a {@link AlunoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link AlunoDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AlunoQueryService extends QueryService<Aluno> {

    private static final Logger LOG = LoggerFactory.getLogger(AlunoQueryService.class);

    private final AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper;

    public AlunoQueryService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    /**
     * Return a {@link Page} of {@link AlunoDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AlunoDTO> findByCriteria(AlunoCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Aluno> specification = createSpecification(criteria);
        return alunoRepository.findAll(specification, page).map(alunoMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AlunoCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Aluno> specification = createSpecification(criteria);
        return alunoRepository.count(specification);
    }

    /**
     * Function to convert {@link AlunoCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Aluno> createSpecification(AlunoCriteria criteria) {
        Specification<Aluno> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Aluno_.id));
            }
            if (criteria.getNome() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome(), Aluno_.nome));
            }
            if (criteria.getEmail() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmail(), Aluno_.email));
            }
            if (criteria.getDtNascimento() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDtNascimento(), Aluno_.dtNascimento));
            }
            if (criteria.getCpf() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCpf(), Aluno_.cpf));
            }
        }
        return specification;
    }
}
