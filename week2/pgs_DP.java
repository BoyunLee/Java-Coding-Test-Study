/*
동적계획법(Dynamic Programming) - 정수 삼각형

삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 
아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

제한사항
삼각형의 높이는 1 이상 500 이하입니다.
삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
*/

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
