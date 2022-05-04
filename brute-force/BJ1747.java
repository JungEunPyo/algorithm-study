package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1747 {
	
	public static StringBuilder sb = new StringBuilder();
	public static boolean allFinished = false;
	public static boolean fill(int[] arr, int idx, int length, int num) {
		if(allFinished)return true;
		if(idx == arr.length) {
			if(findCase(arr, length, num)) {
				allFinished = true;
				return true;
			}
			return false;
		}
		boolean isFinish = false;

		for(int i = 0; i < 10; i++) {
			arr[idx] = i;
			if(idx == 0 && i == 0)continue;
			isFinish |= fill(arr, idx + 1, length, num);
		}
		return isFinish;
	}
	public static boolean findCase(int[] arr, int length, int num) {
		
		String front = "", back = "";
		for(int i = 0; i < arr.length; i++) {
			front += arr[i];
			if(length % 2 == 1 && i == arr.length-1)continue;
			back = arr[i] + back;
		}
		int temp = Integer.parseInt(front + back);
		if(temp >= num &&isSosu(temp)) {
			System.out.println(temp);
			return true;
		}
		else return false;
		                                         
	}
	
	public static boolean isSosu(int N) {
		if(N< 2)return false;
		else if(N==2)return true;
		for(int i = 2; i < Math.sqrt(N) + 1; i++)
			if(N % i == 0)return false;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int N = Integer.parseInt(num);//(1 ¡Â N ¡Â 1,000,000)
		int len = num.length();
		
		while(true) {
			int[] arr = new int[(int)(len+1)/2];
			if(fill(arr, 0, len, N))break;
			len++;
		}
		
		
	}

}
