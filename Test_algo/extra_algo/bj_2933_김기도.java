package Algo;

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.LinkedList;
 import java.util.Queue;

 public class 미네랄 {
 	static int R,C,N;
 	static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
 	static boolean[][] visit;
 	static char[][] map;
 	static ArrayList<int[]> cluster;
 	public static void main(String[] args) throws IOException {
 		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

 		String[] s = br.readLine().split(" ");
 		R = Integer.parseInt(s[0]);
 		C = Integer.parseInt(s[1]);
 		map = new char[R][C];

 		for (int i = 0; i < R; i++) {
 			String s2 = br.readLine();
 			for(int j=0;j<C;j++)
 			{
 				map[i][j] = s2.charAt(j);
 			}
 		}
 //		for (int i = 0; i < R; i++)
 //		{
 //			System.out.println(Arrays.toString(map[i]));
 //		}
 //		System.out.println("==================");
 		N = Integer.parseInt(br.readLine());
 		s = br.readLine().split(" ");

 		for(int i=1;i<=N;i++)
 		{
 			int oper = Integer.parseInt(s[i-1]);
 			brkMineral(i,oper);
 			visit = new boolean[R][C];
 			boolean flag = true;
 			for(int j=0;j<R;j++)
 			{
 				for(int k=0;k<C;k++)
 				{
 					if(map[j][k] != '.' && !visit[j][k])
 					{
 						visit[j][k] = true;
 						if(bfs(j,k))
 						{
 //							System.out.println(j+" "+k+" 클러스터가 떠있음! ");
 							down();
 							flag = false;
 //							for (int a = 0; a < R; a++)
 //							{
 //								System.out.println(Arrays.toString(map[a]));
 //							}
 //							System.out.println("==================");

 							break;
 						}
 					}
 				}
 				if(!flag)
 					break;
 			}
 		}

 //		System.out.println("-------------------------");
 //		for (int a = 0; a < R; a++)
 //		{
 //			System.out.println(Arrays.toString(map[a]));
 //		}
 		for(int i=0;i<R;i++)
 		{
 			for(int j=0;j<C;j++)
 			{
 				System.out.print(map[i][j]);
 			}
 			System.out.println();
 		}
 	}
 	private static void down() {
 		int cnt = 1;
 		for (int i = 0; i < cluster.size(); i++) {
 //			System.out.print(Arrays.toString(cluster.get(i)));
 			int x = cluster.get(i)[0];
 			int y = cluster.get(i)[1];
 			map[x][y] = '.';
 		}
 //		System.out.println();
 		while(true)
 		{
 			boolean flag = true;

 			for (int i = 0; i < cluster.size(); i++) {
 				int x = cluster.get(i)[0];
 				int y = cluster.get(i)[1];

 				if(x+cnt >= R)
 				{
 					flag = false;
 					break;
 				}
 				if(map[x+cnt][y] != '.')
 				{
 					flag = false;
 					break;
 				}
 			}
 			if(!flag)
 				break;

 			cnt++;
 		}

 		cnt--;
 //		System.out.println(cnt+"칸 내려가기 가능");

 		for (int i = 0; i < cluster.size(); i++) {
 //			System.out.println(Arrays.toString(cluster.get(i)));
 			int x = cluster.get(i)[0];
 			int y = cluster.get(i)[1];
 			map[x+cnt][y] = 'x';
 		}
 	}
 	private static void brkMineral(int n, int oper) {
 		int brk=-1;

 		if(n%2!=0)
 		{
 			for(int i=0;i<C;i++)
 			{
 				if(map[R-oper][i]!='.')
 				{
 					brk = i;
 					break;
 				}
 			}
 		}
 		else
 		{
 			for(int i=C-1;i>=0;i--)
 			{
 				if(map[R-oper][i]!='.')
 				{
 					brk = i;
 					break;
 				}
 			}
 		}
 		if(brk != -1)
 			map[R-oper][brk] = '.';
 	}
 	private static boolean bfs(int x, int y) {
 		Queue<int[]> q = new LinkedList();
 		q.add(new int[] {x,y});
 		boolean re= true;
 		cluster = new ArrayList();
 		while(!q.isEmpty())
 		{
 			int tx = q.peek()[0];
 			int ty = q.peek()[1];
 			q.poll();
 			cluster.add(new int[] {tx,ty});
 			for(int i=0;i<4;i++)
 			{
 				int ax = tx + dx[i];
 				int ay = ty + dy[i];
 				if(ax >= 0 && ax<R && ay>=0 && ay<C)
 				{
 					if(map[ax][ay] !='.' && !visit[ax][ay])
 					{
 						visit[ax][ay] = true;
 						q.add(new int[] {ax,ay});
 						if(ax==R-1)
 							re = false;
 					}
 				}
 			}
 		}

 		return re;
 	}

 }
