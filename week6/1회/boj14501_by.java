import java.util.Scanner;

public class boj14501_by {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // n개의 숫자 쌍을 저장할 배열 선언
        int[][] days = new int[N][2];

        // 데이터 입력받기
        for (int i = 0; i < N; i++) {
            days[i][0] = sc.nextInt();
            days[i][1] = sc.nextInt();
            sc.nextLine();
        }

        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            // i번째 일의 종료일 계산
            int time = days[i][0] + i;

            // 작업이 끝나는 날이 주어진 기간 내에 있는지 확인
            if (time <= N) {
                // i번째 일을 수행했을 때의 최대 수익 업데이트
                // dp[time]은 (현재 최대 수익, i번째 일 수행 후의 수익) 중 큰 값으로 업데이트
                dp[time] = Math.max(dp[time], dp[i] + days[i][1]);
            }

            // 현재 일을 하지 않고 그냥 넘어가는 경우
            // 다음 날의 최대 수익은 (현재 날의 최대 수익, 다음 날의 기존 최대 수익) 중 큰 값으로 업데이트
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        int answer = 0;
        for (int i = 0; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

        sc.close();
    }
}
