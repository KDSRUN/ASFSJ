import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static StringBuilder sb = new StringBuilder();

    static int[] arr, result;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        arr = new int[N];
        result = new int[N];
        visited = new boolean[N];
        arr = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();

        permutation(0);

        System.out.println(max);
    }

    private static void permutation(int cnt){
        if(cnt==N){
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(result[i]-result[i+1]);
            }

            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            result[cnt] = arr[i];
            permutation(cnt+1);
            visited[i] = false;
        }

    }
}
