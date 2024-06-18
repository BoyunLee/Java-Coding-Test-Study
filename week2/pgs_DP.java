import java.util.Arrays;

public class pgs_DP {
    public int solution(int[][] triangle) {
        // Bottom-up 방식으로 각 위치마다 최대 경로의 합을 계산
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    // 맨 왼쪽 열일 경우, 바로 위의 왼쪽 값을 더함
                    triangle[i][j] += triangle[i-1][j];
                } else if (j == triangle[i].length - 1) {
                    // 맨 오른쪽 열일 경우, 바로 위의 오른쪽 값을 더함
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    // 그 외의 경우, 위의 왼쪽 값과 오른쪽 값 중 큰 값을 더함
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        
        // 마지막 행의 최대값을 반환
        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        // 테스트를 위한 삼각형 배열 생성
        int[][] triangle = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        };

        // solution 메서드 호출하여 최대 경로의 합 계산
        pgs_DP dp = new pgs_DP();
        int result = dp.solution(triangle);
        
        // 결과 출력
        System.out.println(result);
    }
}
