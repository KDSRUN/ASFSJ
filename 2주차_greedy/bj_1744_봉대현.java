import java.util.*;
import java.io.*;

public class bj_1744_봉대현 {
    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> zeros = new ArrayList<>();
        int ans = 0;


        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(in.readLine());

            if(num <= 0){
                minus.add(num);
            }else if (num > 0){
                numList.add(num);
            }
        }
        
        Collections.sort(numList,Collections.reverseOrder());
        Collections.sort(minus);

        //양수
        ArrayDeque<Integer> plusq = new ArrayDeque<>(numList);
        while(!plusq.isEmpty()){
            if(plusq.size() == 1){
                ans +=  plusq.pop();
                break;
            }
            int fn = plusq.poll();
            int tn = plusq.poll();
            if(fn + tn < fn * tn){
                ans += fn * tn;
            }else{
                ans += fn + tn;
            }
        }

        //음수
        ArrayDeque<Integer> minusq = new ArrayDeque<>(minus);
        while(!minusq.isEmpty()){
            if(minusq.size() == 1){
                ans += minusq.pop();
                break;
            }
            ans += minusq.poll() * minusq.poll();
        }
        System.out.println(ans);
    }
}
