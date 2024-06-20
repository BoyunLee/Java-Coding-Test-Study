/*
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
*/
/*
Bottom-Up 방식

1 -> N 로 가는 방식
dp[0] = 0
dp[1] = 0
dp[2] = 1
dp[n] = 일단 -1 하는 경우의 수(dp[n]+1) 저장
        그후 2로 나눠지는 경우의 수와 3으로 나눠지는 경우의 수 
        비교 후 가장 작은 값 저장
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj1463_2_by {
	
	public static void main(String[] args) throws  IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(bottomUp(n));
	}
	
	static int bottomUp(int num) {
        int[] dp = new int[num + 1];
        
        for (int i = 2; i <= num; i++) {

            // 우선 1을 뺀 경우의 수를 현재의 dp[i]에 저장
            dp[i] = dp[i - 1] + 1;
            
            // 2로 나누어 떨어질 때
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            // 3으로 나누어 떨어질 때
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[num];
    }    
}
