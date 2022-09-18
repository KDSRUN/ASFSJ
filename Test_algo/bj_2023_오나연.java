import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2023_오나연 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dfs(0, 0, N);
	}
	
	private static void dfs(int num, int cnt, int N) {
		if(cnt == N) {
			System.out.println(num);
		}
		
		for(int i=1; i<10; i++) {
			int tmp = num * 10 + i;
			if(isPrime(tmp)) {
				dfs(tmp, cnt+1, N);
			}
		}
	}
	
	// 소수 확인
	private static boolean isPrime(int num) {
		if(num==0 || num==1) return false;
		
		int sqrt = (int) Math.sqrt(num);
		
		for(int i=2; i<=sqrt; i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
}