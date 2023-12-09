import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] all = new int[9];
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			all[i] = Integer.parseInt(br.readLine());
			sum += all[i];
		}
	
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if(sum - all[i] - all[j] == 100) {
					all[i] = all[j] = 0;
					Arrays.sort(all);
					for (int k = 2; k < 9; k++)
						System.out.println(all[k]);
					return;
				}
			}
		}
	}
}