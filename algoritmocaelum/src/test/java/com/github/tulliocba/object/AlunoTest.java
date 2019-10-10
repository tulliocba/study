package com.github.tulliocba.object;

import static org.assertj.core.api.Assertions.*;

import com.github.tulliocba.object.Aluno;
import org.junit.Test;

public class AlunoTest {
    @Test
    public void criar_aluno() {
        Aluno aluno = new Aluno();
        assertThat(aluno).isNotNull();
    }
}
