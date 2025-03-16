package com.mycompany.myapp.domain;

import static com.mycompany.myapp.domain.AlunoTestSamples.*;
import static com.mycompany.myapp.domain.MetaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetaTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Meta.class);
        Meta meta1 = getMetaSample1();
        Meta meta2 = new Meta();
        assertThat(meta1).isNotEqualTo(meta2);

        meta2.setId(meta1.getId());
        assertThat(meta1).isEqualTo(meta2);

        meta2 = getMetaSample2();
        assertThat(meta1).isNotEqualTo(meta2);
    }

    @Test
    void metaAlunoTest() {
        Meta meta = getMetaRandomSampleGenerator();
        Aluno alunoBack = getAlunoRandomSampleGenerator();

        meta.setMetaAluno(alunoBack);
        assertThat(meta.getMetaAluno()).isEqualTo(alunoBack);

        meta.metaAluno(null);
        assertThat(meta.getMetaAluno()).isNull();
    }
}
