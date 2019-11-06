package com.github.tulliocba.max_counter;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxCounterTest {

    @Test
    public void max_conter_test() {
        int[] A = new int[]{3, 4, 4, 6, 1, 4, 4};
        final int[] solution = new MaxConter().solution(5, A);
        assertThat(Arrays.toString(solution)).isEqualTo("[3, 2, 2, 4, 2]");
    }
}
