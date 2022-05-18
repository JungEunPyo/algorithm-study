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
		
		PriorityQueue<Integer> smallQueue = new PriorityQueue<Integer>(Collections.reverseOrder()); //���� ���� �������� 
		PriorityQueue<Integer> bigQueue = new PriorityQueue<Integer>(); //ū ���� ��������
		int N = Integer.parseInt(br.readLine());//1���� ũ�ų� ����, 100,000���� �۰ų� ���� �ڿ���
		while(N-->0) {
			int num = Integer.parseInt(br.readLine());//������ -10,000���� ũ�ų� ����, 10,000���� �۰ų� ����.
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
