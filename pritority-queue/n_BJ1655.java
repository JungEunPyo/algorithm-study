import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class n_BJ1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> bigger = new PriorityQueue<Integer>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			int num = Integer.parseInt(br.readLine());
			if(i % 2 == 0) { //smaller 크기 == bigger 크기 + 1
				if(smaller.size() == 0)smaller.add(num);
				else if(!bigger.isEmpty() && bigger.peek() < num) {
					smaller.add(bigger.poll());
					bigger.add(num);
				}else {
					smaller.add(num);
				}
			}else { //smaller 크기 == bigger 크기 + 1 ------> smaller 크기 == bigger 크기로 변경
				if(smaller.peek() > num) {
					bigger.add(smaller.poll());
					smaller.add(num);
				}else {
					bigger.add(num);
				}
			}
			sb.append(smaller.peek() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
