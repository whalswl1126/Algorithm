import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] area = new int[100][100];
		int max_x = Integer.MIN_VALUE;
		int max_y = Integer.MIN_VALUE;
		int min_x = Integer.MAX_VALUE;
		int min_y = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			max_x = Math.max(x1, Math.max(max_x, x2));
			max_y = Math.max(y1, Math.max(max_y, y2));
			min_x = Math.min(x1, Math.min(min_x, x2));
			min_y = Math.min(y1, Math.min(min_y, y2));

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					area[x][y] = 1;
				}
			}
		}

		int answer = 0;
		for (int i = min_x; i < max_x; i++) {
			for (int j = min_y; j < max_y; j++) {
				answer += area[i][j];
			}
		}

		System.out.println(answer);
	}
}