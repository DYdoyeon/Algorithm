package programmers.tileornament;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Solution solu = new Solution();
		System.out.print(solu.solution(5));
	}

}

class Solution {

	public long solution(int N) {
		return 2 * fibonachi(N + 1);
	}

	public long fibonachi(int N) {
		long result = 0;
		long first = 0;
		long second = 1;
		for (int i = 1; i <= N; i++) {
			result = first + second;
			first = second;
			second = result;
		}
		return result;
	}

	public long fibo(int N) {

		if (N == 1 || N == 0)
			return 1;

		return fibo(N - 1) + fibo(N - 2);

	}

}
