import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] area = new int[1001][1001];
		int[] cnt = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()) + x1;
			int y2 = Integer.parseInt(st.nextToken()) + y1;

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					area[x][y] = i;
				}
			}
		}
		for (int x = 0; x < 1001; x++) {
			for (int y = 0; y < 1001; y++) {
				cnt[area[x][y]]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {			
			System.out.println(cnt[i]);
		}
	}
}