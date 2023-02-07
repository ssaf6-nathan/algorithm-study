import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17086_�Ʊ���2_�޸��ʰ�2 {
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {			
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		int temp = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1)
					continue;
				temp = bfs(r, c);
				max = Math.max(max, temp);
			}
		}
		System.out.println(max);
		br.close();
	}

	public static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c, 0 });
		visit[r][c] = true;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int i = 0; i < 8; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				int d = cur[2];
				if(isInRange(nr, nc)) continue;
				if(map[nr][nc] == 1) {
					return d + 1;
				}
				visit[nr][nc] = true;
				q.add(new int[] {nr, nc, d+1});
			}
		}
		return 0;
	}
	public static boolean isInRange(int r, int c) {
		return r < 0 || r >= N || c < 0 || c >= M;
	}
}
