package com.mycompany.myapp.service.criteria;

import com.mycompany.myapp.domain.enumeration.areaDoEnem;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.mycompany.myapp.domain.Meta} entity. This class is used
 * in {@link com.mycompany.myapp.web.rest.MetaResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /metas?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MetaCriteria implements Serializable, Criteria {

    /**
     * Class for filtering areaDoEnem
     */
    public static class areaDoEnemFilter extends Filter<areaDoEnem> {

        public areaDoEnemFilter() {}

        public areaDoEnemFilter(areaDoEnemFilter filter) {
            super(filter);
        }

        @Override
        public areaDoEnemFilter copy() {
            return new areaDoEnemFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private areaDoEnemFilter area;

    private IntegerFilter valor;

    private LongFilter metaAlunoId;

    private Boolean distinct;

    public MetaCriteria() {}

    public MetaCriteria(MetaCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.area = other.optionalArea().map(areaDoEnemFilter::copy).orElse(null);
        this.valor = other.optionalValor().map(IntegerFilter::copy).orElse(null);
        this.metaAlunoId = other.optionalMetaAlunoId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public MetaCriteria copy() {
        return new MetaCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public Optional<LongFilter> optionalId() {
        return Optional.ofNullable(id);
    }

    public LongFilter id() {
        if (id == null) {
            setId(new LongFilter());
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public areaDoEnemFilter getArea() {
        return area;
    }

    public Optional<areaDoEnemFilter> optionalArea() {
        return Optional.ofNullable(area);
    }

    public areaDoEnemFilter area() {
        if (area == null) {
            setArea(new areaDoEnemFilter());
        }
        return area;
    }

    public void setArea(areaDoEnemFilter area) {
        this.area = area;
    }

    public IntegerFilter getValor() {
        return valor;
    }

    public Optional<IntegerFilter> optionalValor() {
        return Optional.ofNullable(valor);
    }

    public IntegerFilter valor() {
        if (valor == null) {
            setValor(new IntegerFilter());
        }
        return valor;
    }

    public void setValor(IntegerFilter valor) {
        this.valor = valor;
    }

    public LongFilter getMetaAlunoId() {
        return metaAlunoId;
    }

    public Optional<LongFilter> optionalMetaAlunoId() {
        return Optional.ofNullable(metaAlunoId);
    }

    public LongFilter metaAlunoId() {
        if (metaAlunoId == null) {
            setMetaAlunoId(new LongFilter());
        }
        return metaAlunoId;
    }

    public void setMetaAlunoId(LongFilter metaAlunoId) {
        this.metaAlunoId = metaAlunoId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public Optional<Boolean> optionalDistinct() {
        return Optional.ofNullable(distinct);
    }

    public Boolean distinct() {
        if (distinct == null) {
            setDistinct(true);
        }
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final MetaCriteria that = (MetaCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(area, that.area) &&
            Objects.equals(valor, that.valor) &&
            Objects.equals(metaAlunoId, that.metaAlunoId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, valor, metaAlunoId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MetaCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalArea().map(f -> "area=" + f + ", ").orElse("") +
            optionalValor().map(f -> "valor=" + f + ", ").orElse("") +
            optionalMetaAlunoId().map(f -> "metaAlunoId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
