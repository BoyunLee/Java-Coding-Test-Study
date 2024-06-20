/*
피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 
그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
n=17일때 까지 피보나치 수를 써보면 다음과 같다.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

재귀로 문제 풀이
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj10826_2_by {

    // 배열을 이용하여 계산된 피보나치 수를 저장
    // 저장 안할 경우 시간이 오래걸림 -> 시간초과
    public static BigInteger[] memo;

    public static BigInteger fibo(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        // 이미 계산된 값이 있으면 반환
        if (memo[n] != null) return memo[n];
        // 계산 후 배열에 저장
        memo[n] = fibo(n - 1).add(fibo(n - 2));
        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 배열 초기화
        memo = new BigInteger[n + 1];

        BigInteger result = fibo(n);

        System.out.println(result);
    }
}


