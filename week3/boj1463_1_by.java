/*
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
*/
/*
재귀함수 방식 -> Top-Down 방식

N -> 1 로 가는 방식

1. 6(2 와 3 동시)으로 나눠지는 수 찾기
2. 3으로만 나눠지는 수 찾기
3. 2로만 나눠지는 수 찾기
4. 1~3번이 불가능 한 수 찾기

단계별로 N에서 1로 만들기 위해 필요한 최소 연산 횟수를 메모이제이션 배열 dp에 저장하고,
재귀적으로 필요한 값을 계산
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class boj1463_1_by {
 
	static Integer[] dp;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());

		// N+1인 dp 배열을 생성
		// 인덱스를 보다 직관적으로 사용하기 위해 N+1 사용
		// 배열의 인덱스와 입력값 N을 직접적으로 대응시킬 수 있음
		// 동적 프로그래밍을 사용할 때 일반적으로 사용
		dp = new Integer[N + 1];

		// dp[0]과 dp[1]은 연산이 필요 없으므로 0으로 초기화
		dp[0] = dp[1] = 0;
 
		System.out.print(recur(N));
 
	}
 
	static int recur(int N) {

		if (dp[N] == null) {

			// 6으로 나눠지는 경우 
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
			}
			// 3으로만 나눠지는 경우 
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = recur(N - 1) + 1;
			}
		}
		return dp[N];
	}
}