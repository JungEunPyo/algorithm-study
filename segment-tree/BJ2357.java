package segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2357 {

	public static int[][] answer;
	
	public static int[] fill(int[] numbers, int node, int start, int end) {
		
		if(start == end) {
			answer[node][0] = numbers[start];
			answer[node][1] = numbers[start];
			return answer[node];
		}
		int mid = (start + end)/2;
		int[] a = fill(numbers, node * 2, start, mid);
		int[] b = fill(numbers, node * 2 + 1, mid + 1, end);
		answer[node][0] = Math.min(a[0], b[0]);
		answer[node][1] = Math.max(a[1], b[1]);
		return answer[node];
	}
	public static int[] find(int start, int end, int left, int right, int node) {
		if(left > end || right < start) {
			return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
		}else if(left <= start && end <= right) {
			return answer[node];
		}
		int mid = (start + end)/2;
		int[] a = find(start, mid, left, right, node * 2);
		int[] b = find(mid + 1, end, left, right, node * 2 + 1);
		return new int[] {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N + 1];
		answer = new int[N * 4][2];
		for(int i = 1; i < N + 1; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		fill(numbers, 1, 1, N);
		StringBuilder sb = new StringBuilder();
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] answer = find(1, N, a, b, 1);
			sb.append(answer[0] + " " + answer[1] + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
