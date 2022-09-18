import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        permutation(0,0);
        System.out.println(sb.toString());
    }

    private static void permutation(int cnt, int num){
        if(cnt==N){
            sb.append(num).append("\n");
            return;
        }

        int i = cnt == 0 ? 2 : 1;
        for(; i <= 9; i++){
            if(isPrime(num*10+i)) permutation(cnt+1, num*10+i);
        }

    }

    private static boolean isPrime(int num){
        for(int i=2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

}
