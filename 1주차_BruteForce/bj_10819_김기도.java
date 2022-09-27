package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class bj_10819_김기도 {
	static int res=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < s.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		permutation(arr,new int[N],0,new boolean[N]);
		System.out.println(res);
	}

	private static void permutation(int[] arr, int[] sel, int k, boolean[] v) {
		if(sel.length == k)
		{
			//System.out.println(Arrays.toString(sel));
			int val = cal(sel);
			//System.out.println(val);
			res = Math.max(res, val);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!v[i])
			{
				sel[k] = arr[i];
				v[i] = true;
				permutation(arr,sel,k+1,v);
				v[i] = false;
			}
		}
		
	}

	private static int cal(int[] sel) {
		int sum=0;
		for (int i = 0; i < sel.length-1; i++) {
			sum =sum + Math.abs(sel[i] - sel[i+1]);
		}
		return sum;
	}

}
