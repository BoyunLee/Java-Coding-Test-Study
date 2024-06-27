import java.util.Arrays;

public class pgs_예산_by {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            int sum = 0;

            Arrays.sort(d);

            for(int i=0; i<d.length; i++){
                sum += d[i];
                if(sum > budget){
                    break;
                }
                answer++;
            }
            return answer;
        }
    }
}