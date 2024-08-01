// BFS - 게임 맵 최단거리

import java.util.*;

public class pgs1844_by {
    class Solution {
        public int solution(int[][] maps) {
            int answer = -1;
            int n = maps.length; // 행
            int m = maps[0].length; // 열
            boolean[][] visited = new boolean[n][m];
            Queue<int[]> queue = new ArrayDeque<>();
            // 시작점 (0,0)에서 출발하여 거리는 1로 설정하고 큐에 추가
            queue.add(new int[] {0, 0, 1});
            visited[0][0] = true;
            int[] dr = { -1, 1, 0, 0 }; // 상하좌우 방향
            int[] dc = { 0, 0, -1, 1 }; // 상하좌우 방향
            while (!queue.isEmpty()) {
                int[] cur = queue.remove();
                int r = cur[0], c = cur[1], dist = cur[2];
                // 목적지에 도달하면 현재 거리를 반환
                if (r == n - 1 && c == m - 1) {
                    return dist;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    // 유효한 범위 내에 있고, 벽이 아니며 방문하지 않은 경우
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                        if (!visited[nr][nc]) {
                            visited[nr][nc] = true;
                            queue.add(new int[]{ nr, nc, dist + 1 });
                        }
                    }
                }
            }
            return answer;
        }
    } 
}
