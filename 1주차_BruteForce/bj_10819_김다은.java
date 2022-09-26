import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_10819_김다은 {

    static int N, answer;
    static int[] arr, select;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        select = new int[N];
        v = new boolean[N];
        permutation(0);

        System.out.print(answer);
    }

    private static void permutation(int cnt) {
        if (cnt == N) {
            int total = 0;
            for (int i = 0; i < N - 1; i++) {
                total += Math.abs(select[i] - select[i + 1]);
            }
            answer = Math.max(answer, total);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(v[i]) continue;
            v[i] = true;
            select[cnt] = arr[i];
            permutation(cnt + 1);
            v[i] = false;
        }
    }
}