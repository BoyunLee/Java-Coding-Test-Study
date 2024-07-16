/*
완전탐색 - 소수 찾기
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
*/
import java.util.*;

public class pgs42839_by {
    class Solution {
        public int solution(String numbers) {
            int answer = 0;
            int N = numbers.length();
            int[] arr = new int[N];
            boolean[] visit = new boolean[N];
            Set<Integer> set = new HashSet<>();
    
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(numbers.charAt(i) + "");
            }
    
            for (int i = 1; i <= N; i++) {
                backtrack(arr, i, visit, "", 0, set);
            }
    
            answer = set.size();
            return answer;
        }
    
        public void backtrack(int[] nums, int k, boolean[] visit, String x, int depth, Set<Integer> set) {
            if (x.length() == k) {
                if (isPrime(Integer.parseInt(x))) {
                    set.add(Integer.parseInt(x));
                }
                return;
            }
    
            for (int i = 0; i < nums.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    backtrack(nums, k, visit, x + nums[i], depth + 1, set);
                    visit[i] = false;
                }
            }
        }
    
        public boolean isPrime(int n) {
            if (n <= 1) return false;
            if (n == 2) return true;
            if (n % 2 == 0) return false;
            int sqrt = (int) Math.sqrt(n);
            for (int i = 3; i <= sqrt; i += 2) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }
}
