import java.io.*;
import java.util.*;

public class Main {
	
	static String N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = br.readLine();
		
		Long[] arr = new Long[N.length()];
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (long) (N.charAt(i) - '0');
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		if(sum % 3 != 0 || arr[0] != 0)
			System.out.println(-1);
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = arr.length - 1; i >= 0; i--)
				sb.append(arr[i]);
			System.out.println(sb);
		}
	}
}