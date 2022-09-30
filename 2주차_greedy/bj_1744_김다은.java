import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj_1744_김다은 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> another = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp > 0) plus.add(temp);
            else if (temp < 0) minus.add(temp);
            else another.add(temp);
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        int answer = 0;

        // (0 * 음수) 보다 (음수 * 음수)가 항상 최댓값
        for (int i = 0; i < plus.size(); i = i + 2) {
            int num1 = plus.get(i);
            if (i + 1 >= plus.size()) {
                answer += num1;
                break;
            }
            int num2 = plus.get(i + 1);

            if (num1 * num2 > num1 + num2) {
                answer += num1 * num2;
            } else {
                answer += num1 + num2;
            }
        }

        for (int i = 0; i < minus.size(); i = i + 2) {
            int num1 = minus.get(i);
            if (i + 1 >= minus.size()) {
                if (another.size() == 0) {
                    answer += num1;
                }
                break;
            }
            int num2 = minus.get(i + 1);
            answer += num1 * num2;
        }

        System.out.print(answer);
    }
}