import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int garoSize = Integer.parseInt(st.nextToken());
		int seroSize = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> garos = new PriorityQueue<>();
		PriorityQueue<Integer> seros = new PriorityQueue<>();
		
		garos.add(0);
		seros.add(0);
		garos.add(garoSize);
		seros.add(seroSize);
				
		int garo = 0;
		int sero = 0;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("0")) {
				seros.add(Integer.parseInt(st.nextToken()));
			} else {
				garos.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int pre = 0;
		while(!garos.isEmpty()) {
			garo = Math.max(garo, garos.peek() - pre);
			pre = garos.poll();
		}
		pre = 0;
		while(!seros.isEmpty()) {
			sero = Math.max(sero, seros.peek() - pre);
			pre = seros.poll();
		}
		
		System.out.println(garo * sero);
	}
}