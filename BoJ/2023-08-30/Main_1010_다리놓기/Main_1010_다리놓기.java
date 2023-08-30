import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
	static int N, M;
	static int[][] numbers = new int[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sb.append(comb(M, N)).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int comb(int n, int r) {
		if(n == r || r == 0)
			numbers[n][r] = 1;
		if(numbers[n][r] > 0)
			return numbers[n][r];
		return numbers[n][r] = comb(n-1, r-1) + comb(n-1, r);
	}
}