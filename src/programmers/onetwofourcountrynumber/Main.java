package programmers.onetwofourcountrynumber;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Solution solu = new Solution();
		System.out.println(solu.solution(3));

	}
}

class Solution {
	String answer = "";

	public String solution(int n) {
		num = n;
		recursive(n);
		answer += num;
		answer = answer.replace('3', '4');
		return answer;
	}

	int idx = 1;
	int bottomSum = 0;
	int pow = 0;
	int num = 0;

	public void recursive(int n) {
		bottomSum += Math.pow(3, idx);
		if (n <= bottomSum)
			return;
		else {

			idx++;
			recursive(n);
			idx--;
			pow = (int) Math.pow(3, idx);

			int quotient = (int) ((int) num / pow);
			num = num - pow * quotient;
			answer += String.valueOf(quotient);

		}

	}

}