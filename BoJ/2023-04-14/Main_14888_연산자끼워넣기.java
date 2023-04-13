import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int N, nums[], op[], max, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		op = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(nums[0], 1);
		
		sb.append(max + "\n" + min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int num, int idx) {
		if(idx == N) {
			max = Math.max(max, num);
			min = Math.min(num, min);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				if(i == 0)
					dfs(num + nums[idx], idx+1);
				else if (i == 1)
					dfs(num - nums[idx], idx+1);
				else if (i == 2)
					dfs(num * nums[idx], idx+1);
				else
					dfs(num / nums[idx], idx+1);
				op[i]++;
			}
		}
	}
}