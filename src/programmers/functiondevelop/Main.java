package programmers.functiondevelop;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		int[] progresses = { 93, 30, 55 };

		int[] speeds = { 1, 30, 5 };

		Solution solution = new Solution();

		solution.solution(progresses, speeds);

	}

}

class Solution {
	
	public int[] solu(int[] progresses,int[] speeds) {
		int[] answer = {};
		
		
		return answer;
	}
	
	//arrayList 나 Queue 사용 가
	public int[] solution(int[] progresses, int[] speeds) {

		int[] answer = {};

		int arrSize = progresses.length;

		int days[] = new int[arrSize];

		int preElement = 0;
		int elementCount = 1;
		int arrIdx = 0;
		
		// 각 기능별 걸리는 시간 및 일수 파악 
		for (int i = 0; i < arrSize; i++) {
			days[i] = (int) Math.ceil((float) (100 - progresses[i]) / (float) speeds[i]);
			if (i == 0) {
				preElement = days[i];
				continue;
			}
			if (preElement < days[i]) {
				preElement = days[i];
				elementCount++;
			}
		}
		
		preElement = days[0];
		answer = new int[elementCount];

		//days배열이 0이 아닐 경우 해당 일수 파악 
		for (int i = 0; i < arrSize; i++) {
			if (preElement >= days[i])
				answer[arrIdx] += 1;
			else {
				answer[++arrIdx] = 1;
				preElement = days[i];
			}
		}

		return answer;

	}

}
