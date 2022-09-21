import java.io.*;
import java.util.*;

class bj_2023_김준환 {    
    static int N;
    static int[] no;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        int start = 1, end = 1;
        for(int i = 0; i < N; i++){
            end *= 10;
        }
        start = end / 10;
        
        sb = new StringBuilder();

        findInterestingPrime("2");
        findInterestingPrime("3");
        findInterestingPrime("5");
        findInterestingPrime("7");

        System.out.println(sb);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }

    static boolean isPrime(int n){
        boolean isPrime = true;

        int nn = (int)Math.sqrt(n);
        for(int i = 2; i <= nn; i++){
            if(n % i == 0){
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    static void findInterestingPrime(String no){
        int n = stoi(no);
        if(isPrime(n)){
            if(no.length() == N){
                sb.append(n).append('\n');
                return;
            }

            for(int i = 0; i < 10; i++){
                findInterestingPrime(no + i + "");
            }
        }
    }
}
