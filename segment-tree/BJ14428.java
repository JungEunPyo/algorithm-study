import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ14428 {

	public static int[] arr;
	public static int[] tree; //가장 작은 값을 가진 index 저장하는 배열
	public static int minIdx(int node, int a, int b) {
		if(a == -1 || b == -1) {
			return (a==-1)? b: a;
		}
		else if(arr[a] == arr[b]) {
			return Math.min(a, b);
		}else {
			return (arr[a] < arr[b])? a: b;
		}
	}
	public static void initTree(int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
			return;
		} 
		int mid = (start + end) / 2;
		initTree(node * 2, start, mid);
		initTree(node * 2 + 1,mid + 1, end);
		tree[node] = minIdx(node, tree[node * 2], tree[node * 2 + 1]);
		//tree[node] = (arr[tree[node * 2]]<= arr[tree[node * 2 + 1]])? tree[node * 2]: tree[node * 2 + 1];
		return;
	}
	public static void updateTree(int node, int start, int end, int idx, int value) {
		if(idx < start || idx > end)return;
		if(start == end) {
			//tree[node] = idx;
			arr[idx] = value;
			return;
		}
		int mid = (start + end)/2;
		updateTree(node * 2, start, mid, idx, value);
		updateTree(node * 2 + 1, mid + 1, end, idx, value);
		tree[node] = minIdx(node, tree[node * 2], tree[node * 2 + 1]);
		//tree[node] = (arr[tree[node * 2]]<= arr[tree[node * 2 + 1]])? tree[node * 2]: tree[node * 2 + 1];
	}
	public static int findMinIdx(int node, int start, int end, int left, int right) { //tree[node]값 변경하면 안됨!!!!!
		if (left > end || right < start) {
			return -1;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end)/2;
		int a = findMinIdx(node * 2, start, mid, left, right);
		int b = findMinIdx(node * 2 + 1, mid + 1, end, left, right);
		return minIdx(node, a, b);
//		if(a == -1)return b;
//		else if(b == -1)return a;
//		else {
//			return arr[a]<= arr[b]? a: b;
//		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());//배열의 크기
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		tree = new int[N * 4];
		for(int i = 1; i <=N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		initTree(1, 1, N);
		int M = Integer.parseInt(br.readLine());//쿼리의 개수
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
			if(type == 1) {
				updateTree(1, 1, N, a, b);
			}else if(type == 2) {
				sb.append(findMinIdx(1, 1, N, a, b) + "\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
