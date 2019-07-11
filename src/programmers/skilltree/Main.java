package programmers.skilltree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String skill = "CBD";
		String skill_trees[] = { "BACDE", "CBADF", "AECB", "BDA" };
		Solution solu = new Solution();
		System.out.println(solu.solution(skill, skill_trees));
	}

}

class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		int arr[] = new int[skill.length()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = -1;

		int size = skill_trees.length;
		for (int i = 0; i < size; i++) {
			boolean flag = true;

			String skillTreeMember = skill_trees[i];

			// 해당 문자가 문자열 안에 존재하는지 파악
			
			/* 굳이 두개를 비교할 필요 없었어. - 자바함수 사용하기 : indexOf */
			for (int j = 0; j < skillTreeMember.length(); j++) {
				for (int k = 0; k < skill.length(); k++) {
					if (skillTreeMember.charAt(j) == skill.charAt(k)) {
						arr[k] = j;
						break;
					}
				}

			}

			// 오름차순이 아닐 경우, -1이 나온 후에 양수가 나올 경우를 골라내
			for (int j = 1; j < skill.length(); j++) {
				if ((arr[j] < arr[j - 1] && arr[j] != -1 && arr[j - 1] != -1) || (arr[j - 1] == -1 && arr[j] >= 0)) {
					flag = false;
					break;
				}

			}
			for (int j = 0; j < arr.length; j++) {
				arr[j] = -1;
			}
			if (flag == true)
				answer++;

		}
		return answer;
	}
}
