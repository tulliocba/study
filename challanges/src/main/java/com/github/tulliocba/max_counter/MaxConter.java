package com.github.tulliocba.max_counter;

public class MaxConter {
    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int startLine = 0;
        int maxCount = 0;

        for (int i : A) {
            int index = i-1;
            if(i > N) startLine = maxCount;
            else if(result[index] < startLine) result[index] = startLine + 1;
            else result[index] += 1;

            if(i <= N && result[index] > maxCount) maxCount = result[index];
        }
        for (int i = 0; i < result.length; i++) if(result[i] < startLine) result[i] = startLine;
        return result;
    }
}
