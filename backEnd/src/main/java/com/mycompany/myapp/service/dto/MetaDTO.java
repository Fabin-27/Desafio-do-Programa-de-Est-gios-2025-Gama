package com.mycompany.myapp.service.dto;

import com.mycompany.myapp.domain.enumeration.areaDoEnem;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.Meta} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MetaDTO implements Serializable {

    private Long id;

    @NotNull
    private areaDoEnem area;

    @NotNull
    private Integer valor;

    @NotNull
    private AlunoDTO metaAluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public areaDoEnem getArea() {
        return area;
    }

    public void setArea(areaDoEnem area) {
        this.area = area;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public AlunoDTO getMetaAluno() {
        return metaAluno;
    }

    public void setMetaAluno(AlunoDTO metaAluno) {
        this.metaAluno = metaAluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MetaDTO)) {
            return false;
        }

        MetaDTO metaDTO = (MetaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, metaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MetaDTO{" +
            "id=" + getId() +
            ", area='" + getArea() + "'" +
            ", valor=" + getValor() +
            ", metaAluno=" + getMetaAluno() +
            "}";
    }
}
