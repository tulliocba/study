package com.github.tulliocba.equilibrium;


import lombok.Getter;

public class Equilibrium {
    @Getter
    private int point;
    @Getter
    private int absDiff;

    public Equilibrium(int point, int absDiff) {
        this.point = point;
        this.absDiff = absDiff;
    }

    static Equilibrium findEquilibrium(int[] n) {
        int absDiff = 0;
        int point = 0;

        for (int i = 1; i < n.length; i++) { // {1, 2, 3}; i = 1; value = 2;
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) { // j = 0; value = 1;
                left += n[j];
            }
            for (int j = n.length - 1; j >= i; j--) {
                right += n[j];
            }

            final int abs = left - right;
            if(i == 1) {
                absDiff = Math.abs(abs);
            }
            if(Math.abs(abs) < absDiff) {
                absDiff = abs;
                point = i;
            }

        }
        return new Equilibrium(point, absDiff);
    }

    public static Equilibrium findEquilibrium2(int[] n) {
        int right = 0;
        int left = 0;
        int point = 0;
        int absDiff = 0;
        for (int i = 0; i < n.length; i++) {
            right += n[i];
        }

        absDiff = Math.abs(n[0] - right);

        for (int i = 1; i < n.length; i++) {
            left += n[i-1];
            right = (right - n[i-1]);
            int abs = Math.abs(left - right);
            if(abs < absDiff) {
                absDiff = abs;
                point = i;
            }
        }
        return new Equilibrium(point, absDiff);
    }
}
