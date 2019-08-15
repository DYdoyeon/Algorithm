package programmers.cookiepurchase;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		int[] cookie = { 1, 8, 4, 2, 3, 9, 4, 5 };
		Solution solution = new Solution();
		System.out.println(solution.solution(cookie));

	}

}

class Solution {

	public int solution(int[] cookie) {

		int arrSize = cookie.length;
		int leftTotal = 0;
		int rightTotal = 0;
		int answer = 0;

		for (int j = 1; j < arrSize; j++) {

			int i = j - 1;
			int k = j;

			leftTotal = cookie[i];
			rightTotal = cookie[k];

			while (true) {
				if(i<=0 && k>arrSize)
					break;
				if (leftTotal == rightTotal)
					answer = Math.max(answer, leftTotal);

				if (leftTotal <= rightTotal && i > 0) {
					leftTotal += cookie[--i];
				} else if (leftTotal > rightTotal && k < arrSize - 1) {
					rightTotal += cookie[++k];
				} 
				else	
					break;

			//	System.out.println(
			//			"i : " + i + " j : " + j + " leftTotal : " + leftTotal + " rightTotal : " + rightTotal);
			}
		//	System.out.println("////////////////////////////////////////////////////////");

			leftTotal = 0;
			rightTotal = 0;
		}

		return answer;

	}

}