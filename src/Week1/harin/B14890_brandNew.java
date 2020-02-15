package Week1.harin;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14890_brandNew {
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		int result=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/bTemp.txt")));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//좌우
		for(int i=1;i<=N;i++) {
			visited=new boolean[N+1];
			arr[i][0]=arr[i][1];
			int now=arr[i][1];
			int before=arr[i][0];
			visited[1]=true;
			int cnt=0;
			boolean flag=true;
			
			for(int j=1;j<=N;j++) {
				now=arr[i][j];
				before=arr[i][j-1];
				if(now==before) {
					cnt++;
					visited[j]=true;
				}else {
					if(Math.abs(now-before)!=1) {
						flag=false;
						break;
					}
					//값이 올라갈때
					if(now>before) {
						
						if(cnt>=L) {
							cnt=1;
							visited[j]=true;
						}else {
							flag=false;
							break;
						}
						
					}else {
						//값이 내려갈때
						int tmpCnt=1;
						for(int k=j+1;k<=N;k++) {
							if(k<=N && arr[i][k] ==now){
								tmpCnt++;
								visited[k]=true;
							}else {
								break;
							}
						}
						//
						if(tmpCnt<L) {
							flag=false;
							break;
						}else {
							j+=tmpCnt-1;
							cnt=1;
							visited[j]=true;
						}
					}
				}
			}
			if(flag) result++;
		}
		//상하
		for(int i=1;i<=N;i++) {
			visited=new boolean[N+1];
			arr[0][i]=arr[1][i];
			int now=arr[1][i];
			int before=arr[0][i];
			visited[1]=true;
			int cnt=0;
			boolean flag=true;
			
			for(int j=1;j<=N;j++) {
				now=arr[j][i];
				before=arr[j-1][i];
				if(now==before) {
					cnt++;
					visited[j]=true;
				}else {
					if(Math.abs(now-before)!=1) {
						flag=false;
						break;
					}
					//값이 올라갈때
					if(now>before) {
						
						if(cnt>=L) {
							cnt=1;
							visited[j]=true;
						}else {
							flag=false;
							break;
						}
						
					}else {
						//값이 내려갈때
						int tmpCnt=1;
						for(int k=j+1;k<=N;k++) {
							if(k<=N && arr[k][i] ==now){
								tmpCnt++;
								visited[k]=true;
							}else {
								break;
							}
						}
						//
						if(tmpCnt<L) {
							flag=false;
							break;
						}else {
							j+=tmpCnt-1;
							cnt=1;
							visited[j]=true;
						}
					}
				}
			}
			if(flag) result++;
		}
		
		System.out.println(result);
	}
}
