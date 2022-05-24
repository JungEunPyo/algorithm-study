import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWExpertAcademy_1767 {
	public static final int[] up = new int[] {-1, 0};
	public static final int[] down = new int[] {1, 0};
	public static final int[] right = new int[] {0, 1};
	public static final int[] left = new int[] {0, -1};
	public static final int[][] dx = {up, down, right, left};
	public static int maxCount = 0, minLength = Integer.MAX_VALUE;
	public static int check(int[] direction, int row, int col, int[][] board) {
		int nrow = row + direction[0], ncol = col + direction[1];
		int length = 0;
		while(true) {
			if(board[nrow][ncol] != 0) {
				int[] nDirection = new int[] {-direction[0], -direction[1]};
				reset(nDirection, nrow, ncol, board);
				return 0;
			}
			length++;
			board[nrow][ncol] = 2;
			if(nrow == 0 || ncol == 0 || nrow == board.length-1 || ncol == board[0].length-1)break;
			nrow += direction[0];
			ncol += direction[1];
		}
		return length;
	}
	public static void reset(int[] direction, int row, int col, int[][] board) {
		int nrow = row + direction[0], ncol = col + direction[1];
		while(true) {
			if(board[nrow][ncol] == 1)break;
			board[nrow][ncol] = 0;
			if(nrow == 0 || ncol == 0 || nrow == board.length-1 || ncol == board[0].length-1)break;
			nrow += direction[0];
			ncol += direction[1];
		}
	}
	public static void dfs(List<int[]> processorList, int idx, int[][] board, int count, int length){
		if(idx == processorList.size()) {
			if(maxCount==count) {
				minLength = Math.min(minLength, length);
			}else if(maxCount < count) {
				maxCount = count;
				minLength = length;
			}
			return;
		}
		int[] processor = processorList.get(idx);
		if(processor[0] == 0 || processor[1] == 0 || processor[0] == board.length-1 || processor[1] == board[0].length-1) {//가장자리에 위치한 Core는 이미 전원이 연결된 것으로 간주
			dfs(processorList, idx + 1, board, count + 1, length);
		}else {
			if(processorList.size()-idx + count < maxCount)return;
			for(int i = 0; i < dx.length; i++) {
				int addLength = check(dx[i], processor[0], processor[1], board);
				if(addLength!=0) {
					dfs(processorList, idx + 1, board, count + 1, length + addLength);
					reset(dx[i], processor[0], processor[1], board);	
				}
			}
			dfs(processorList, idx + 1, board, count, length);
			return;
		}
	}
	public static String printBoard(int[][] board) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++){
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());//test case 수
		
 		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());//N * N 배열 입력
			List<int[]> processorList = new ArrayList<>();//프로세서의 위치 저장하는 리스트
			maxCount = 0; minLength = Integer.MAX_VALUE;
			int[][] board = new int[N][N];
			for(int r = 0; r < board.length; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < board[r].length; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
					if(board[r][c] == 0)continue;
					processorList.add(new int[] {r, c});//프로세서의 위치 저장
				}
			}
			dfs(processorList, 0, board,0, 0);
			sb.append("#" + i + " " + minLength + "\n");
			//sb.append(printBoard(board));
		}
 		bw.write(sb.toString());
 		bw.flush();
 		bw.close();
		br.close();
	}

}
