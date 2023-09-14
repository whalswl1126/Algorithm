import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	static int N, M, cnt, bcnt, result = Integer.MAX_VALUE;
	static char[][] board, map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		map = new char[8][8];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				
				visited = new boolean[8][8];
				copyMap(i,j);
				cnt = 0;
//				for (int r = 0; r < 8; r++) {
//					for (int c = 0; c < 8; c++) {
//						dfs(r, c);
//					}
//				}
				bfs();
				result = Math.min(result, bcnt);
				
				visited = new boolean[8][8];
				copyMap(i,j);
				change(0,0);
				cnt = 1;
//				for (int r = 0; r < 8; r++) {
//					for (int c = 0; c < 8; c++) {
//						dfs(r, c);
//					}
//				}
				
				bfs();
				result = Math.min(result, bcnt);
			}			
		}
		System.out.println(result);
	}
	static class Node {
		int r, c, cnt;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		visited[0][0] = true;
		queue.offer(new Node(0, 0, 0));
					
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			bcnt = cur.cnt;
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(0 > nr || nr >= 8 || 0 > nc || nc >= 8 || visited[nr][nc] || map[cur.r][cur.c] != map[nr][nc])
					continue;
				visited[nr][nc] = true;
				change(nr, nc);
				queue.offer(new Node(nr, nc, cur.cnt+1));
			}
		}
	}
	private static void copyMap(int r, int c) {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				map[i][j] = board[i + r][j + c];
	}
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(0 > nr || nr >= 8 || 0 > nc || nc >= 8 || visited[nr][nc] || map[r][c] != map[nr][nc])
				continue;
			
			cnt++;
			change(nr, nc);
			dfs(nr, nc);
		}
	}
	private static void change(int r, int c) {
		if(map[r][c] == 'W')
			map[r][c] = 'B';
		else
			map[r][c] = 'W';
	}
}