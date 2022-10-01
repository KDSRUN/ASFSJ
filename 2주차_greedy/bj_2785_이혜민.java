
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        while (true) {
            if (list.size() <= 1) break;

            list.set(0, list.get(0) - 1);

            if (list.get(0) == 0) list.remove(0);

            list.remove(list.size() - 1);

            result++;
        }

        System.out.println(result);

    }
}
