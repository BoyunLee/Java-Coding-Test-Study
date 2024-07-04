/*
괄호 회전하기 

다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.

(), [], {} 는 모두 올바른 괄호 문자열입니다.
만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 
예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 
예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 
이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
*/

import java.util.Stack;

public class pgs76502_by {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            // 문자열 회전
            for (int i = 0; i < s.length(); i++) {
                String rotatedStr = s.substring(i) + s.substring(0, i);
                if (isValid(rotatedStr)) {
                    answer++;
                }
            }
            return answer;
        }

        // 괄호 짝 검사 메서드
        private boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if (!matches(top, c)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        // 괄호 짝 확인 메서드
        private boolean matches(char open, char close) {
            return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
        }
    }
}

