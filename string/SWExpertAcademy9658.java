import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWExpertAcademy9658 {

	public static void changeToSignificantFigure(int TC, String N) {//�־��� ������ �� �� �ڸ��� ��ȿ���ڷ� �Ͽ� ǥ��
		if(N.charAt(2)-'0' < 5) { //�ݿø��� ���ϴ� ���
			System.out.printf("#%d %d.%d*10^%d\n", TC, N.charAt(0)-'0', N.charAt(1)-'0', N.length()-1);
		}else if(N.charAt(1)-'0'< 9) { //2��° ���ڿ��� �ݿø�->1��° ���� + 1�� ������ ���
			System.out.printf("#%d %d.%d*10^%d\n", TC, N.charAt(0)-'0', N.charAt(1)-'0' + 1, N.length()-1);
		}else if(N.charAt(0)-'0' < 9) { //2��° ���ڿ��� �ݿø�->ù��° ����=0->0��° ���� + 1
			System.out.printf("#%d %d.%d*10^%d\n", TC, N.charAt(0)-'0' + 1, 0, N.length()-1);
		}else {//2��° ���ڿ��� �ݿø�->ù��° ����=0, 0��° ����=10-> 0��° ����=1, 10�� + 1
			System.out.printf("#%d %d.%d*10^%d\n", TC, 1, 0, N.length());
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine()); //test case ��
		for(int i = 1; i <= TC; i++) {
			String N = br.readLine();//( 10�� 2�� �� N �� 10�� 100000��)
			changeToSignificantFigure(i, N);
		}
		br.close();
	}

}
