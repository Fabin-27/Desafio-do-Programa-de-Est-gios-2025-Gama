package com.mycompany.myapp.domain;

import static com.mycompany.myapp.domain.AlunoTestSamples.*;
import static com.mycompany.myapp.domain.MetaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class AlunoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Aluno.class);
        Aluno aluno1 = getAlunoSample1();
        Aluno aluno2 = new Aluno();
        assertThat(aluno1).isNotEqualTo(aluno2);

        aluno2.setId(aluno1.getId());
        assertThat(aluno1).isEqualTo(aluno2);

        aluno2 = getAlunoSample2();
        assertThat(aluno1).isNotEqualTo(aluno2);
    }

    @Test
    void metaAlunoTest() {
        Aluno aluno = getAlunoRandomSampleGenerator();
        Meta metaBack = getMetaRandomSampleGenerator();

        aluno.addMetaAluno(metaBack);
        assertThat(aluno.getMetaAlunos()).containsOnly(metaBack);
        assertThat(metaBack.getMetaAluno()).isEqualTo(aluno);

        aluno.removeMetaAluno(metaBack);
        assertThat(aluno.getMetaAlunos()).doesNotContain(metaBack);
        assertThat(metaBack.getMetaAluno()).isNull();

        aluno.metaAlunos(new HashSet<>(Set.of(metaBack)));
        assertThat(aluno.getMetaAlunos()).containsOnly(metaBack);
        assertThat(metaBack.getMetaAluno()).isEqualTo(aluno);

        aluno.setMetaAlunos(new HashSet<>());
        assertThat(aluno.getMetaAlunos()).doesNotContain(metaBack);
        assertThat(metaBack.getMetaAluno()).isNull();
    }
}
