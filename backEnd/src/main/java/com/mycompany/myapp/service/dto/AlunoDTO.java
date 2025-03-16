package com.mycompany.myapp.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.Aluno} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AlunoDTO implements Serializable {

    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @Pattern(regexp = "(^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$)")
    private String email;

    @NotNull
    private LocalDate dtNascimento;

    @NotNull
    @Pattern(regexp = "([0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?([0-9]){2})")
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlunoDTO)) {
            return false;
        }

        AlunoDTO alunoDTO = (AlunoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, alunoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AlunoDTO{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", dtNascimento='" + getDtNascimento() + "'" +
            ", cpf='" + getCpf() + "'" +
            "}";
    }
}
