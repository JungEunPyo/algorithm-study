import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWExpertAcademy9658 {

	public static void changeToSignificantFigure(int TC, String N) {//주어진 정수의 앞 두 자리를 유효숫자로 하여 표기
		if(N.charAt(2)-'0' < 5) { //반올림을 안하는 경우
			System.out.printf("#%d %d.%d*10^%d\n", TC, N.charAt(0)-'0', N.charAt(1)-'0', N.length()-1);
		}else if(N.charAt(1)-'0'< 9) { //2번째 숫자에서 반올림->1번째 숫자 + 1로 끝나는 경우
			System.out.printf("#%d %d.%d*10^%d\n", TC, N.charAt(0)-'0', N.charAt(1)-'0' + 1, N.length()-1);
		}else if(N.charAt(0)-'0' < 9) { //2번째 숫자에서 반올림->첫번째 숫자=0->0번째 숫자 + 1
			System.out.printf("#%d %d.%d*10^%d\n", TC, N.charAt(0)-'0' + 1, 0, N.length()-1);
		}else {//2번째 숫자에서 반올림->첫번째 숫자=0, 0번째 숫자=10-> 0번째 숫자=1, 10승 + 1
			System.out.printf("#%d %d.%d*10^%d\n", TC, 1, 0, N.length());
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine()); //test case 수
		for(int i = 1; i <= TC; i++) {
			String N = br.readLine();//( 10의 2승 ≤ N ≤ 10의 100000승)
			changeToSignificantFigure(i, N);
		}
		br.close();
	}

}
