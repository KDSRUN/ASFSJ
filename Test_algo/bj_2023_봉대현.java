import java.util.*;
import java.io.*;

//1 <= N <= 8
public class bj_2023_봉대현 {
    static int N;


    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        process(0,sb,N);

    }

    private static void process(int start, StringBuilder sb,int size){

        if(start == size ){
            System.out.println(sb.toString());
            return;
        }

        for(int i = 1; i <= 9; i++){
            sb.append(i);
            if(isPrime(stoi(sb.toString()))){
                process(start+1,sb,size);
            }
            sb.setLength(sb.length()-1);
        }

    }

    //소수판별 : 가운데 약수까지만 검사
    private static boolean isPrime(int num){

        if(num == 1 || num == 0) return false;

        for(int i = 2; i < (int)((Math.sqrt((double)num))+1); i++ ){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
