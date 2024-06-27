public class pgs_연속된부분수열의합_by {
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
