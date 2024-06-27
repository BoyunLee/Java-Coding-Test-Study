import java.util.HashMap;

public class pgs42576_by {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map = new HashMap<>();
            
            // participant 배열 순회
            for (int i = 0; i < participant.length; i++) {
                String player = participant[i];
                if (map.containsKey(player)) {
                    map.put(player, map.get(player) + 1);
                } else {
                    map.put(player, 1);
                }
            }

            // completion 배열 순회
            for (int i = 0; i < completion.length; i++) {
                String player = completion[i];
                if (map.containsKey(player)) {
                    map.put(player, map.get(player) - 1);
                }
            }
            
            // 해시맵에서 값이 0이 아닌 참가자 찾기
            for (int i = 0; i < participant.length; i++) {
                String player = participant[i];
                if (map.get(player) > 0) {
                    answer = player;
                    break;
                }
            }
            
            return answer;
        }
    }
}