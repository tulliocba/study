package com.github.tulliocba.cyclic_rotation;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CyclicRotationTest {
    private int A[];

    @Before
    public void setUp() throws Exception {
        A = new int[]{3, 4, 5, 1, 2};
    }

    @Test
    public void rotate_test() {
        A = CyclicRotation.solution(A, 2);
        Assertions.assertThat("[1, 2, 3, 4, 5]").isEqualTo(Arrays.toString(A));
    }

    @Test
    public void calc_index_test() {
        int k = 2;
        for (int i = 0; i < A.length; i++) {
            System.out.println("("+i+"+"+k+")%"+A.length+" = "+ ((i+k)%A.length));
        }
    }
}
