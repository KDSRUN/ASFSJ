import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2023_김기도 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = {1, 2, 3, 5, 7, 9};    //순열, 중복o

        permutation(arr, new int[N], 0);

    }

    private static void permutation(int[] arr, int[] sel, int k) {
        if (k == sel.length) {
            //System.out.println(Arrays.toString(sel));
            boolean flag = false;
            int val = sel[0];

            for (int i = 0; i < N; i++) {
                if (i != 0)
                    val = val * 10 + sel[i];

                //System.out.println("val "+val);
                if (!check((int) (val))) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println(val);
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (k == 0 && arr[i] == 1)
                continue;

            if (k == 0 && arr[i] == 9)
                return;
            sel[k] = arr[i];

            permutation(arr, sel, k + 1);
        }

    }

    private static boolean check(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return false;
        }

        return true;
    }

}
