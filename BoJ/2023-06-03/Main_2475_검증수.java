import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2475_검증수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sum = 0;
		while(st.hasMoreTokens()) {
			sum += Math.pow(Double.parseDouble(st.nextToken()), 2);
		}
		System.out.println((int)sum%10);
	}
}