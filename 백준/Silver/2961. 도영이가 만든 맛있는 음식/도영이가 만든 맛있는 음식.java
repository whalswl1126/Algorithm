import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, min = Integer.MAX_VALUE;
	static int[] sins, ssns;
	static int[][] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sins = new int[N];
		ssns = new int[N];
		result = new int[2][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sins[i] = Integer.parseInt(st.nextToken());
			ssns[i] = Integer.parseInt(st.nextToken());
		}
		Select(0);
		System.out.println(min);
	}
	private static void Select(int idx) {
		if(idx == N) {
			int sin=1, ssn=0;
			for (int i = 0; i < N; i++) {
				sin *= result[0][i];
				ssn += result[1][i];
			}
			if(sin == 1 || ssn == 0) return;
			min = Math.min(min, Math.abs(sin - ssn));
			return;
		}
		result[0][idx] = sins[idx];
		result[1][idx] = ssns[idx];
		Select(idx+1);
		result[0][idx] = 1;
		result[1][idx] = 0;
		Select(idx+1);
	}
}