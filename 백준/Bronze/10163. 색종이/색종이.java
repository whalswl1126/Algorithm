import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] area = new int[1001][1001];
		int[] size = new int[N];
		int max_x = Integer.MIN_VALUE;
		int max_y = Integer.MIN_VALUE;
		int min_x = Integer.MAX_VALUE;
		int min_y = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()) + x1;
			int y2 = Integer.parseInt(st.nextToken()) + y1;

			max_x = Math.max(x1, Math.max(max_x, x2));
			max_y = Math.max(y1, Math.max(max_y, y2));
			min_x = Math.min(x1, Math.min(min_x, x2));
			min_y = Math.min(y1, Math.min(min_y, y2));

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					area[x][y] = i+1;
				}
			}
		}
		for (int x = min_x; x < max_x; x++) {
			for (int y = min_y; y < max_y; y++) {
				size[area[x][y]-1]++;
			}
		}
		
		for (int j : size) {
			System.out.println(j);
		}
	}
}