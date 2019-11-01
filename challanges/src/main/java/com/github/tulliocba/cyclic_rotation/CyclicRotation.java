package com.github.tulliocba.cyclic_rotation;

public class CyclicRotation {
    public static int[] solution(int[] A, int k) {
        int B[] = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            B[(i+k)%A.length] = A[i];
        }
        return B;
    }
}
