package com.github.tulliocba.equilibrium;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EquilibriumTest {
    int[] n;

    @Before
    public void setUp() {
        n = new int[201];
        int point = 0;
        for (int i = -100; i <= 100; i++) {
            n[point++] = i;
        }
    }

    @Test
    public void find_the_equilibrium2_test() {
        int equilibrium = Equilibrium.solution(n);
        assertThat(equilibrium).isEqualTo(200);
    }
}
