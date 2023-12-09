import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			Map<Integer, Integer> aMap = new HashMap<>();
			Map<Integer, Integer> bMap = new HashMap<>();
			for (int j = 1; j <= 4; j++) {
				aMap.put(j, 0);
				bMap.put(j, 0);
			}
			
			String A = br.readLine();
			String B = br.readLine();
			
			st = new StringTokenizer(A);
			int a = Integer.parseInt(st.nextToken());
			for (int aa = 0; aa < a; aa++) {
				int num = Integer.parseInt(st.nextToken());
				if (aMap.containsKey(num))
					aMap.replace(num, aMap.get(num) + 1);
				else
					aMap.put(num, 0);
			}
			
			st = new StringTokenizer(B);
			int b = Integer.parseInt(st.nextToken());
			for (int bb = 0; bb < b; bb++) {
				int num = Integer.parseInt(st.nextToken());
				if (bMap.containsKey(num))
					bMap.replace(num, bMap.get(num) + 1);
				else
					bMap.put(num, 0);
			}

			System.out.println(getAns(aMap, bMap));
		}
	}

	private static String getAns(Map<Integer, Integer> aMap, Map<Integer, Integer> bMap) {
		if (aMap.get(4) > bMap.get(4))
			return "A";
		else if (aMap.get(4) < bMap.get(4))
			return "B";
		if (aMap.get(3) > bMap.get(3))
			return "A";
		else if (aMap.get(3) < bMap.get(3))
			return "B";
		if (aMap.get(2) > bMap.get(2))
			return "A";
		else if (aMap.get(2) < bMap.get(2))
			return "B";
		if (aMap.get(1) > bMap.get(1))
			return "A";
		else if (aMap.get(1) < bMap.get(1))
			return "B";
		else
			return "D";
	}
}