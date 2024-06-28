/*
투포인터 - 연속된 부분 수열의 합

비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.

기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
부분 수열의 합은 k입니다.
합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 
위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요. 
이때 수열의 인덱스는 0부터 시작합니다.
*/

public class pgs178870_by {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = {};

            int length = Integer.MAX_VALUE;

            // 투 포인터 설정
            int start = 0;
            int sum = 0;

            for (int end = 0; end < sequence.length; end++) {
                sum += sequence[end];

                // sum이 k 이상이 될 때까지 start 포인터를 옮기며 sum에서 값을 빼줌
                while (sum >= k) {
                    if (sum == k) {
                        // 현재 부분 수열의 길이 계산
                        int currentLength = end - start + 1;

                        // 현재 길이가 기존 length보다 짧으면 업데이트
                        if (currentLength < length) {
                            length = currentLength;
                            answer = new int[]{start, end};
                        }
                    }

                    // start 포인터를 오른쪽으로 한 칸 이동하고 sum에서 sequence[start] 값을 빼줌
                    sum -= sequence[start];
                    start++;
                }
            }

            // List<int[]> answerList = new ArrayList<>();

            // for(int i=0; i<sequence.length; i++){
            //     int sum=0;
            //     for(int j=i; j<sequence.length; j++){
            //         sum += sequence[j];
            //         if(sum == k){
            //             answerList.add(new int[]{i, j});
            //         }
            //     }
            // }

            // // length에 가장 큰 값 넣어둠
            // int length = Integer.MAX_VALUE;

            //  // answerList에서 가장 짧은 길이의 부분 수열을 찾음
            // for (int[] list : answerList) {
            //     int listLength = list[1] - list[0] + 1;
            //     if (listLength < length) {
            //         length = listLength;
            //         answer = list;
            //     }
            // }

            return answer;
        }
    }
}
