/*
평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. 
DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다. 
예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 
이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.

하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 
임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다. 
그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.

임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 
그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자.
이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 
하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.

민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 
그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때 
민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 
단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12891_by {
    public static void main(String[] args) throws IOException{

        // 표준 입력을 문자로 읽고 버퍼링하여 효율적으로 처리할 수 있도록 하는 객체를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 주어진 문자열을 공백을 기준으로 나누는 클래스
		StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 한 줄의 입력을 받아 문자 배열로 변환
        char[] Minho = br.readLine().toCharArray();

        // 새로운 입력 문자열을 읽음
        st = new StringTokenizer(br.readLine());
        int[] alpa = new int[4];
        for (int i = 0; i < 4; i++) {
			alpa[i] = Integer.parseInt(st.nextToken());
		}

        int count = 0;

        // 가능한 모든 부분문자열을 확인
        for (int i = 0; i <= S - P; i++) {
            // 부분문자열을 만들기
            int[] check = new int[4];
            // 조건을 판단하기 위한 초기 설정
            boolean isValid = true;

            // 부분문자열을 순회하며 각 문자의 등장 횟수 세기
            for (int j = i; j < i + P; j++) {
                char currentChar = Minho[j];

                if (currentChar == 'A') {
                    check[0]++;
                } else if (currentChar == 'C') {
                    check[1]++;
                } else if (currentChar == 'G') {
                    check[2]++;
                } else if (currentChar == 'T') {
                    check[3]++;
                }
            }

            // 현재 부분문자열이 조건을 만족하는지 확인
            for (int k = 0; k < 4; k++) {
                if (check[k] < alpa[k]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                count++;
            }
        }
        System.out.println(count);
    }
}
