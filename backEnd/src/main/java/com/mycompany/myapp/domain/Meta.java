package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mycompany.myapp.domain.enumeration.areaDoEnem;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

/**
 * A Meta.
 */
@Entity
@Table(name = "meta")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Meta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "area", nullable = false)
    private areaDoEnem area;

    @NotNull
    @Column(name = "valor", nullable = false)
    private Integer valor;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "metaAlunos" }, allowSetters = true)
    private Aluno metaAluno;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Meta id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public areaDoEnem getArea() {
        return this.area;
    }

    public Meta area(areaDoEnem area) {
        this.setArea(area);
        return this;
    }

    public void setArea(areaDoEnem area) {
        this.area = area;
    }

    public Integer getValor() {
        return this.valor;
    }

    public Meta valor(Integer valor) {
        this.setValor(valor);
        return this;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Aluno getMetaAluno() {
        return this.metaAluno;
    }

    public void setMetaAluno(Aluno aluno) {
        this.metaAluno = aluno;
    }

    public Meta metaAluno(Aluno aluno) {
        this.setMetaAluno(aluno);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Meta)) {
            return false;
        }
        return getId() != null && getId().equals(((Meta) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Meta{" +
            "id=" + getId() +
            ", area='" + getArea() + "'" +
            ", valor=" + getValor() +
            "}";
    }
}
