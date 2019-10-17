package com.github.tulliocba.list;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class AlunoTest {
    @Test
    public void criar_aluno() {
        Aluno aluno = new Aluno();
        assertThat(aluno).isNotNull();
    }
}
