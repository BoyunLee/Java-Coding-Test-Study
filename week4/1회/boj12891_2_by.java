/*
시간초과 발생하지 않도록 투포인터 사용

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

import java.io.*;
import java.util.*;

public class boj12891_2_by {
    static int S, P;
    static int[] dna, dp;
    static char[] list = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        Queue<String> q = new LinkedList<>();
        
        String arr = br.readLine();

        int result = 0;
        dna = new int[4];
        dp = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            dna[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P-1; i++) {
            q.add(arr.charAt(i) + "");
            updateDp(arr.charAt(i));
        }

        for (int i = P-1; i < S; i++) {
            q.add(arr.charAt(i) + "");
            updateDp(arr.charAt(i));
            if (check()) {
                result++;
            }
            deleteDp(q.poll().charAt(0));
        }
        


        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void updateDp(char c) {
        for (int i = 0; i < 4; i++) {
                if (c == list[i]) {
                    dp[i]++;
                }
            }
    }

    public static void deleteDp(char c) {
        for (int i = 0; i < 4; i++) {
            if (c == list[i]) {
                dp[i]--;
            }
        }
    }
    
    public static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (dp[i] < dna[i]) {
                return false;
            }
        }
        return true;
    }
}

