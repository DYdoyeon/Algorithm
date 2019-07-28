package programmers.kakaocoloring;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int m = 13;
		int n = 16;
		int[][] picture = { { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0 },
				{ 0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 } };

//		 m=5;
//		 n=5;

//		 int[][] picture = {{1, 1, 1,0, 0},{2,1,2,0,0}};

		Solution2 solu = new Solution2();
		int[] ans = solu.solution(m, n, picture);
		System.out.println(ans[0] + "," + ans[1]);
	}

}

class Solution {
	int dx[] = { 0, 1, 0, -1 };
	int dy[] = { 1, 0, -1, 0 };
	Stack<Point> stk = new Stack();

	public int[] solution(int m, int n, int[][] picture) {

		int[] answer = { 0, 0 };
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int AreaSize = 0;
		int CurrentArea = 0;
		int topX;
		int topY;
		int nextX;
		int nextY;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				AreaSize = 0;
				if (picture[i][j] != -1 && picture[i][j] != 0) {

					stk.push(new Point(i, j));
					AreaSize++;

					CurrentArea = picture[i][j];
					picture[i][j] = -1;
					numberOfArea++;
				}
				while (!stk.isEmpty()) {

					topX = stk.peek().x;
					topY = stk.peek().y;

					stk.pop();
					for (int k = 0; k < 4; k++) {
						nextX = topX + dx[k];
						nextY = topY + dy[k];
						if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && picture[nextX][nextY] != -1
								&& picture[nextX][nextY] != 0 && CurrentArea == picture[nextX][nextY]) {
							stk.push(new Point(nextX, nextY));
							AreaSize++;

							picture[nextX][nextY] = -1;

						}

					}
				}
				if (maxSizeOfOneArea < AreaSize)
					maxSizeOfOneArea = AreaSize;
			}
		}

		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//런타임에러
class Solution2 {
	boolean flag[][];
	int SizeArea = 0;
	int[] answer = { 0, 0 };
	int numberOfArea = 0;
	int maxSizeOfOneArea = 0;
	int lengthX = 0;
	int lengthY = 0;
	int[][] arr;
	int current;

	public int[] solution(int m, int n, int[][] picture) {
		arr = picture;
		lengthX = picture.length;
		lengthY = picture[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				SizeArea = 0;
				if (picture[i][j] != 0) {
					current = picture[i][j];

					solu(i, j);
					numberOfArea += 1;
					if (SizeArea > maxSizeOfOneArea) {
						maxSizeOfOneArea = SizeArea;
					}
				}

			}
		}
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public void solu(int i, int j) {
		arr[i][j] = 0;
		System.out.println("" + i + "," + j);

		if ((i - 1) >= 0 && arr[i - 1][j] == current)
			solu(i - 1, j);

		if ((i + 1) < lengthX && arr[i + 1][j] == current)
			solu(i + 1, j);

		if ((j - 1) >= 0 && arr[i][j - 1] == current)
			solu(i, j - 1);

		if ((j + 1) < lengthY && arr[i][j + 1] == current)
			solu(i, j + 1);

		SizeArea++;

	}

}
