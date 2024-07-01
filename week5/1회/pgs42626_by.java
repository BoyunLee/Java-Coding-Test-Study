/*
힙(Heap) - 더 맵게

매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 
아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class pgs42626_by {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            // PriorityQueue : 최소힙, 자동으로 원소들을 오름차순으로 정렬
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for(int score : scoville) {
                heap.add(score);
            }

            // 가장 작은 원소가 K 이상이 될 때까지 반복
            while (heap.size() > 1 && heap.peek() < K) {
                int first = heap.poll();
                int second = heap.poll();
                int newScoville = first + (second * 2);
                heap.add(newScoville);
                answer++;
            }

            // 모든 원소가 K 이상인지 확인
            if (heap.peek() < K) {
                return -1;
            }

            return answer;
        }
    }
}
