package com.github.tulliocba.equilibrium;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EquilibriumTest {
    @Test
    public void find_the_equilibrium_test() {
        int[] n = new int[]{5, 4, 2, 4};
        Equilibrium equilibrium = Equilibrium.findEquilibrium(n);
        assertThat(equilibrium.getPoint()).isEqualTo(2);
        assertThat(equilibrium.getAbsDiff()).isEqualTo(3);
    }

    @Test
    public void math_abs_method_test() {
        final int point = 3 / 2;
        System.out.println(Math.abs(point));
    }
}
