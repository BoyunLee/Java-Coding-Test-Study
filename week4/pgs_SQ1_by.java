/*
스택/큐 - 같은 숫자는 싫어

배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 

예를 들면,
arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

제한사항
배열 arr의 크기 : 1,000,000 이하의 자연수
배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
*/

import java.util.*;

public class pgs_SQ1_by {

    public int[] solution(int []arr) {

        // 결과를 담을 리스트
        // 리스트 사용 이유 : 요소를 동적으로 추가하거나 삭제할 수 있고 크기를 늘리거나 줄일 수 있음
        List<Integer> answerList = new ArrayList<>();

        // 첫 번째 원소 추가
        answerList.add(arr[0]);
        
        // 중복 제거하면서 리스트에 추가
        for (int i = 1; i < arr.length; i++) {
            // 현재 결과 리스트의 마지막 원소와 현재 원소가 다른 경우에만 추가
            if (answerList.get(answerList.size() - 1) != arr[i]) {
                answerList.add(arr[i]);
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

