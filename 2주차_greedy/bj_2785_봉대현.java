import java.util.*;
import java.io.*;

public class bj_2785_봉대현 {
    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        ArrayList<Integer> numList = new ArrayList<>();

        for(int i = 0;i < N; i++){
            numList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numList);

        while(numList.size() > 1){
            numList.set(0,numList.get(0)-1);//해당 인덱스에 값 교체
            numList.remove(numList.size()-1);

            if(numList.get(0) == 0){
                numList.remove(0);
            }

            ans++;
        }

        System.out.println(ans);

    }
}
