import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_2785_김다은 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        int answer = 0;
        int start = 0;
        int end = N;

        while (end - start > 1) {
            int front = arr[start];
            int size = end - start;
            if (front == size - 2) {
                answer += size - 2;
                break;
            } else if (front > size - 2) {
                answer += size - 1;
                break;
            } else {
                start++;
                end = end - front;
                answer += front;
            }
        }

        System.out.print(answer);
    }
}