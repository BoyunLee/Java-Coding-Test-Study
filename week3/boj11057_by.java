/*
오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.
예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.
수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
 */
/*
1. BufferedReader 선언: BufferedReader를 사용하여 입력을 받습니다. 
   throws IOException을 이용하여 예외 처리를 하지 않고 메서드 내부에서 처리하도록 합니다.

2. N 값 입력: br.readLine()을 통해 입력받은 값을 정수로 변환하여 변수 N에 저장합니다. 
   이 값은 오르막 수의 길이를 나타냅니다.

3. dp 배열 초기화: dp[i][j]는 길이가 i이고 마지막 자리 수가 j인 오르막 수의 개수를 저장하는 배열입니다. 
   초기에는 길이가 1인 경우 모든 자리 수는 자기 자신 하나만 가능하므로 dp[1][i] = 1로 초기화합니다.

4. 오르막 수 개수 계산: 중첩된 반복문을 사용하여 길이가 2부터 N까지 각각의 길이와 끝 자리 수에 대해 가능한 오르막 수의 개수를 계산합니다.

5. dp[i][j]는 이전 길이(i-1)일 때 끝 자리 수가 j보다 작거나 같은 모든 수들의 오르막 수 개수를 합한 값입니다.
   나머지 연산: dp[i][j]에 값을 더할 때마다 10007로 나눈 나머지를 계산하여 오버플로우를 방지합니다.

6. 최종 결과 계산: 길이가 N이고 모든 자리 수가 오르막 수인 경우의 수를 구하기 위해 dp[N][0]부터 dp[N][9]까지의 값을 모두 더하여 answer에 저장합니다.

7. 결과 출력: 계산된 answer를 10007로 나눈 나머지를 출력합니다.
 */
import java.io.*;

public class boj11057_by {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 길이가 1 -> 모두 자기 자신이라서 오르막 수는 1개씩 있음
		long[][] dp = new long[N + 1][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		// 길이가 i일 때 오르막 수 구하기
		for (int i = 2; i <= N; i++) {
			// 끝 자리가 j일 때 오르막 수 구하기
			for (int j = 0; j < 10; j++) {
				// 이전 길이(i-1)일 때 끝 자리가 j보다 작은 모든 수들을 더함
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j] %= 10007;
			}
		}
		
        // 길이가 N이고 모든 자리 수가 오르막 수일 경우의 수를 구함
		long answer = 0;
		for(int i=0; i<10; i++) {
			answer += dp[N][i];
		}
		
		System.out.println(answer % 10007);
        
    }
}
