package com.github.tulliocba.equilibrium;


public class Equilibrium {

    public static int solution(int[] A) {
        int left = A[0];
        int right = sumLeftToRight(1, A);
        int diff = Math.abs(left - right);

        for (int i = 1; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            int currentDiff = Math.abs(left - right);
            if (currentDiff < diff) diff = currentDiff;
        }
        return diff;
    }

    private static int sumLeftToRight(int initIndex, int[] A) {
        int result = 0;
        for (int i = initIndex; i < A.length; i++) result += A[i];
        return result;
    }
}
