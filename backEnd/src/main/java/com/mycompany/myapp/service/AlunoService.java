package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.AlunoDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.Aluno}.
 */
public interface AlunoService {
    /**
     * Save a aluno.
     *
     * @param alunoDTO the entity to save.
     * @return the persisted entity.
     */
    AlunoDTO save(AlunoDTO alunoDTO);

    /**
     * Updates a aluno.
     *
     * @param alunoDTO the entity to update.
     * @return the persisted entity.
     */
    AlunoDTO update(AlunoDTO alunoDTO);

    /**
     * Partially updates a aluno.
     *
     * @param alunoDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<AlunoDTO> partialUpdate(AlunoDTO alunoDTO);

    /**
     * Get the "id" aluno.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AlunoDTO> findOne(Long id);

    /**
     * Delete the "id" aluno.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
