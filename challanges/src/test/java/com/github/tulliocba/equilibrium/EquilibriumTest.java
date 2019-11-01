package com.github.tulliocba.equilibrium;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EquilibriumTest {
    int[] n = new int[]{3, 1, 2, 4, 3};

    @Test
    public void find_the_equilibrium_test() {
        Equilibrium equilibrium = Equilibrium.findEquilibrium(n);
        assertThat(equilibrium.getPoint()).isEqualTo(3);
        assertThat(equilibrium.getAbsDiff()).isEqualTo(1);
    }

    @Test
    public void find_the_equilibrium2_test() {
        int equilibrium = Equilibrium.findEquilibrium2(n);
        assertThat(equilibrium).isEqualTo(1);
    }
}
