import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //아이들 수
        int M = Integer.parseInt(st.nextToken()); //색상의 수

        int[] arr = new int[M];
        int max = 0;
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int left = 1, right = max, mid = 0, count = 0; //count = 분배되는 학생 수
        int result = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < M; i++) {
                count += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    count++;
                }

            }

            if (count > N) { //분배되는 수가 학생 수보다 많은 경우
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }

        System.out.println(result);

    }
}
