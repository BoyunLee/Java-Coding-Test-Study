/*
스택/큐 - 다리를 지나는 트럭

트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 
다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 
무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 
트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
*/

import java.util.LinkedList;
import java.util.Queue;

public class pgs_SQ5_by {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {

            // Java에서 Queue 인터페이스를 구현한 LinkedList 클래스의 인스턴스를 생성하는 코드
            // FIFO(First-In-First-Out) 데이터 구조를 나타며 이는 큐에서 가장 먼저 추가된 요소가 가장 먼저 제거되는 원리
            Queue<Integer> queue = new LinkedList<>();

            // 현재 다리 위의 트럭 무게 총합
            int sum = 0;

            // 경과 시간
            int time = 0; 

            for (int i = 0; i < truck_weights.length; i++) {
                int truck = truck_weights[i];

                while(true) {
                    // 다리 위에 트럭이 없는 경우
                    if(queue.isEmpty()) { 
                        queue.add(truck);
                        sum += truck;
                        // 다리에 오를 때만 시간 추가 
                        time++; 
                        break;
                    }else if (queue.size() == bridge_length) {
                        // 다리 위에 트럭이 다 찬 경우
                        sum -= queue.poll();
                    }else {
                        // 다리 위에 트럭이 있지만 아직 다 차지 않은 경우
                        if (sum + truck <= weight) {
                            // 다음 트럭이 다리에 진입할 수 있는 경우
                            queue.add(truck);
                            sum += truck;
                            time++;
                            break;
                        } else {
                            // 다음 트럭이 다리에 진입할 수 없는 경우
                            // 0을 추가하여 트럭이 지나가도록 함
                            queue.add(0);
                            time++;
                        }
                    }
                }
            }
            // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야하기에 + 다리 길이 
            return time + bridge_length; 
        }
    }
}
    
