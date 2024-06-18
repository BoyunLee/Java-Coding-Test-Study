import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class boj1940_by {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬, 내림차순 정렬 : Arrays.sort(tmpInts, (a, b) -> b - a)
        Arrays.sort(A);
        int count = 0;
        int i = 0;
        int j = N-1;
        while (i < j) {
            if (A[i] + A[j] < M) {
                i++;
            }else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        bf.close();
    }
}
