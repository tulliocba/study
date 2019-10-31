package com.github.tulliocba.equilibrium;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EquilibriumTest {
    int[] n = new int[]{5, 4, 2, 4};

    @Test
    public void find_the_equilibrium_test() {
        Equilibrium equilibrium = Equilibrium.findEquilibrium(n);
        assertThat(equilibrium.getPoint()).isEqualTo(2);
        assertThat(equilibrium.getAbsDiff()).isEqualTo(3);
    }

    @Test
    public void find_the_equilibrium2_test() {
        Equilibrium equilibrium = Equilibrium.findEquilibrium2(n);
        assertThat(equilibrium.getPoint()).isEqualTo(2);
        assertThat(equilibrium.getAbsDiff()).isEqualTo(3);
    }
}
