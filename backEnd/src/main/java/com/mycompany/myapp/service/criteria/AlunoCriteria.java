package com.mycompany.myapp.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.mycompany.myapp.domain.Aluno} entity. This class is used
 * in {@link com.mycompany.myapp.web.rest.AlunoResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /alunos?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AlunoCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nome;

    private StringFilter email;

    private LocalDateFilter dtNascimento;

    private StringFilter cpf;

    private LongFilter metaAlunoId;

    private Boolean distinct;

    public AlunoCriteria() {}

    public AlunoCriteria(AlunoCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.nome = other.optionalNome().map(StringFilter::copy).orElse(null);
        this.email = other.optionalEmail().map(StringFilter::copy).orElse(null);
        this.dtNascimento = other.optionalDtNascimento().map(LocalDateFilter::copy).orElse(null);
        this.cpf = other.optionalCpf().map(StringFilter::copy).orElse(null);
        this.metaAlunoId = other.optionalMetaAlunoId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public AlunoCriteria copy() {
        return new AlunoCriteria(this);
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

    public StringFilter getNome() {
        return nome;
    }

    public Optional<StringFilter> optionalNome() {
        return Optional.ofNullable(nome);
    }

    public StringFilter nome() {
        if (nome == null) {
            setNome(new StringFilter());
        }
        return nome;
    }

    public void setNome(StringFilter nome) {
        this.nome = nome;
    }

    public StringFilter getEmail() {
        return email;
    }

    public Optional<StringFilter> optionalEmail() {
        return Optional.ofNullable(email);
    }

    public StringFilter email() {
        if (email == null) {
            setEmail(new StringFilter());
        }
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public LocalDateFilter getDtNascimento() {
        return dtNascimento;
    }

    public Optional<LocalDateFilter> optionalDtNascimento() {
        return Optional.ofNullable(dtNascimento);
    }

    public LocalDateFilter dtNascimento() {
        if (dtNascimento == null) {
            setDtNascimento(new LocalDateFilter());
        }
        return dtNascimento;
    }

    public void setDtNascimento(LocalDateFilter dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public StringFilter getCpf() {
        return cpf;
    }

    public Optional<StringFilter> optionalCpf() {
        return Optional.ofNullable(cpf);
    }

    public StringFilter cpf() {
        if (cpf == null) {
            setCpf(new StringFilter());
        }
        return cpf;
    }

    public void setCpf(StringFilter cpf) {
        this.cpf = cpf;
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
        final AlunoCriteria that = (AlunoCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(nome, that.nome) &&
            Objects.equals(email, that.email) &&
            Objects.equals(dtNascimento, that.dtNascimento) &&
            Objects.equals(cpf, that.cpf) &&
            Objects.equals(metaAlunoId, that.metaAlunoId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, dtNascimento, cpf, metaAlunoId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AlunoCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalNome().map(f -> "nome=" + f + ", ").orElse("") +
            optionalEmail().map(f -> "email=" + f + ", ").orElse("") +
            optionalDtNascimento().map(f -> "dtNascimento=" + f + ", ").orElse("") +
            optionalCpf().map(f -> "cpf=" + f + ", ").orElse("") +
            optionalMetaAlunoId().map(f -> "metaAlunoId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
