import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWExpertAcademy14361 {

	public static boolean makeMultiple(int N, int length, int[] cnt, int temp) {
		if(length == 0) {
			if(temp > N && temp % N == 0)return true;
			return false;
		}
		boolean canMake = false;
		for(int i = cnt.length-1; i >=0; i--) {
			if(cnt[i] == 0)continue;
			cnt[i]--;
			canMake |= makeMultiple(N, length-1, cnt, temp * 10 + i);
			if(canMake)return canMake;
			cnt[i]++;
		}
		return canMake;
	}
	public static boolean canMakeMultipleByRearrangement(int N) {// true�̸� ��possible�����, false�̸� ��impossible���� ����Ѵ�.
		int[] cnt = new int[10]; //0 ~9������ ������ �����ϴ� �迭
		int temp = N;
		int length = 0;
		while(temp!=0) {
			cnt[temp % 10]++;
			temp /= 10;
			length++;
		}
		return makeMultiple(N, length, cnt, 0);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());//test ��
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());//�ڿ��� N (1 ��N �� 10�� 6��) 
			if(canMakeMultipleByRearrangement(N)) {
				sb.append("#" + (i +1) + " possible\n");
			}else {
				sb.append("#" + (i +1) + " impossible\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
