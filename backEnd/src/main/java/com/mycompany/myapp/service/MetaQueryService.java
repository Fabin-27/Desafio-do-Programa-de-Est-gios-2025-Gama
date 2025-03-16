package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.*; // for static metamodels
import com.mycompany.myapp.domain.Meta;
import com.mycompany.myapp.repository.MetaRepository;
import com.mycompany.myapp.service.criteria.MetaCriteria;
import com.mycompany.myapp.service.dto.MetaDTO;
import com.mycompany.myapp.service.mapper.MetaMapper;
import jakarta.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Meta} entities in the database.
 * The main input is a {@link MetaCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link MetaDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class MetaQueryService extends QueryService<Meta> {

    private static final Logger LOG = LoggerFactory.getLogger(MetaQueryService.class);

    private final MetaRepository metaRepository;

    private final MetaMapper metaMapper;

    public MetaQueryService(MetaRepository metaRepository, MetaMapper metaMapper) {
        this.metaRepository = metaRepository;
        this.metaMapper = metaMapper;
    }

    /**
     * Return a {@link Page} of {@link MetaDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<MetaDTO> findByCriteria(MetaCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Meta> specification = createSpecification(criteria);
        return metaRepository.findAll(specification, page).map(metaMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(MetaCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Meta> specification = createSpecification(criteria);
        return metaRepository.count(specification);
    }

    /**
     * Function to convert {@link MetaCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Meta> createSpecification(MetaCriteria criteria) {
        Specification<Meta> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Meta_.id));
            }
            if (criteria.getArea() != null) {
                specification = specification.and(buildSpecification(criteria.getArea(), Meta_.area));
            }
            if (criteria.getValor() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getValor(), Meta_.valor));
            }
            if (criteria.getMetaAlunoId() != null) {
                specification = specification.and(
                    buildSpecification(criteria.getMetaAlunoId(), root -> root.join(Meta_.metaAluno, JoinType.LEFT).get(Aluno_.id))
                );
            }
        }
        return specification;
    }
}
