/*
피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 
그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
n=17일때 까지 피보나치 수를 써보면 다음과 같다.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

DP로 문제 풀이
*/

import java.math.BigInteger;
import java.io.*;

public class boj10826_1_by {

    // BigInteger : 무한대와 같은 큰 수슬 사용하기 위함
    // 실제 동작은 문자열을 통해 이루어짐
    /*
    A + B = A.add(B)
    A - B = A.subtrat(B)
    A * B = A.multiply(B)
    A / B = A.divide(B)
    A % B = A.remainder(B)
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 값을 정수 n으로 변환
        int n = Integer.parseInt(br.readLine());

        // BigInteger 타입의 배열 dp를 크기 10001로 선언
        BigInteger[] dp = new BigInteger[10001];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-2].add(dp[i-1]);
        }
        System.out.print(dp[n]);
    }
}
    
