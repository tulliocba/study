package com.github.tulliocba.brackets;

import java.util.Stack;

public class Brackets {
    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for(Character c : S.toCharArray()) {
            if(c == '[' || c == '(' || c == '{') {
                stack.push(c);
            }else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return 0;
            }else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return 0;
            }else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
