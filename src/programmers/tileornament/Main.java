package programmers.tileornament;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Solution solu = new Solution();
		System.out.print(solu.solution(6));
	}

}

class Solution {
	long dp[];

	public long solution(int N) {
		dp = new long[N + 2];
		// return 2 * fibo(N + 1);
		return 2 * fibonachi(N + 1);
	}
	
	//재귀 
	public long fibonachi(int N) {
		if (N == 1 || N == 0)
			return 1;
		else if (dp[N] != 0) {
			//이미 진행한 숫자를 다시 진행하지 않기 위해 
			return dp[N];
		} else {
			dp[N] = fibonachi(N - 1) + fibonachi(N - 2);
			return dp[N];
		}
	}

	//배열 
	public long fibo(int N) {
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[N];

	}

}
