import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ1655 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> smallQueue = new PriorityQueue<Integer>(Collections.reverseOrder()); //작은 수는 내림차순 
		PriorityQueue<Integer> bigQueue = new PriorityQueue<Integer>(); //큰 수는 오름차순
		int N = Integer.parseInt(br.readLine());//1보다 크거나 같고, 100,000보다 작거나 같은 자연수
		while(N-->0) {
			int num = Integer.parseInt(br.readLine());//정수는 -10,000보다 크거나 같고, 10,000보다 작거나 같다.
			if(smallQueue.size() == 0)smallQueue.add(num);
			else if(smallQueue.peek()< num)bigQueue.add(num);
			else smallQueue.add(num);
			while(smallQueue.size() < bigQueue.size()) {
				smallQueue.add(bigQueue.poll());
			}
			while(smallQueue.size()-bigQueue.size() > 1) {
				bigQueue.add(smallQueue.poll());
			}
			sb.append(smallQueue.peek() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
