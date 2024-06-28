/*
완전탐색/수학 - 소수 만들기

주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때, 
소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

제한사항
nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
*/

import java.util.ArrayList;
import java.util.List;

public class pgs12977_by {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            List<Integer> sums = new ArrayList<>();
            
            for(int i=0; i<nums.length; i++) {
                for(int j=0; j<i; j++){
                    for(int k=0; k<j; k++){
                        sums.add(nums[i] + nums[j] + nums[k]);
                    }
                }
            }

            for(int sum : sums){
                int count=0;
                for(int n=1; n<=sum; n++){
                    if (sum%n == 0){
                        count++;
                    }
                }
                if(count == 2){
                    answer++;
                }
            }
            return answer;
        }
    }
}
