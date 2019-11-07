package com.github.tulliocba.brackets;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BracketsTest {
    @Test
    public void bracket_test() {
        int result = Brackets.solution("{}()[]");
        Assertions.assertThat(result).isEqualTo(1);
    }
}
