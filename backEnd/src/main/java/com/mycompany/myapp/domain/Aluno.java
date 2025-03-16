package com.mycompany.myapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Aluno.
 */
@Entity
@Table(name = "aluno")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Pattern(regexp = "(^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$)")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dtNascimento;

    @NotNull
    @Pattern(regexp = "([0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?([0-9]){2})")
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Aluno id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public Aluno nome(String nome) {
        this.setNome(nome);
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public Aluno email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDtNascimento() {
        return this.dtNascimento;
    }

    public Aluno dtNascimento(LocalDate dtNascimento) {
        this.setDtNascimento(dtNascimento);
        return this;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Aluno cpf(String cpf) {
        this.setCpf(cpf);
        return this;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Aluno)) {
            return false;
        }
        return getId() != null && getId().equals(((Aluno) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Aluno{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", dtNascimento='" + getDtNascimento() + "'" +
            ", cpf='" + getCpf() + "'" +
            "}";
    }
}
