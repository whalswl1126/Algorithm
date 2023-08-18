import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	static int N, switches[], M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 스위치 개수
		N = Integer.parseInt(br.readLine());
		switches = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			switches[i] = Integer.parseInt(st.nextToken());
		
		// 학생 수
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int snum = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				// gender = 1, 남자라면 배수자리마다 바꿈
				male(snum);
			} else {
				// gender = 2, 여자라면 스위치 번호 좌우대칭값이 일치하지 않을 때까지 바꿈
				female(snum);
			}
		}
		
		// 20개씩 끊어 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(switches[i] + " ");
			if(i%20 == 0)
				System.out.println();
		}
	}
	public static void female(int num) {
		changeStatus(num);
		// 스위치 앞뒤로 적은 범위 찾기
		int scope = Math.min(num - 1, N - num);
		for (int i = 1; i <= scope; i++) {
			if(switches[num-i] == switches[num+i]) {
				changeStatus(num-i);
				changeStatus(num+i);
			} else break;
		}
	}
	public static void male(int num) {
		for (int i = 1; i <= N; i++) {
			if(i % num == 0)
				changeStatus(i);
		}
	}	
	public static void changeStatus(int num) {
		switches[num] = Math.abs(switches[num] - 1);
	}
}
