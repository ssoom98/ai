package com.lec.ex;

import java.util.Scanner;

//길동, 현식, 땅땅, 슘당, 대갈 친구의 키를 입력 받고, 평균을 구하고 최장신 친구의 이름과 키, 최단신 친구의 이름과 키
public class EX05height {
	public static void main(String[] args) {
		String[] names = { "길동", "현식", "땅땅", "슘당", "대갈" };
		int[] heights = new int[names.length];
		Scanner sc = new Scanner(System.in);
		int totHeights = 0;// 키 누적 변수
		// 친구들 키 입력받아 heights 배열에 할당, 키 누적
		for (int idx = 0; idx < names.length; idx++) {
			System.out.print(names[idx] + "의 키는 ?");
			heights[idx] = sc.nextInt();
			totHeights += heights[idx]; // 키 누적
		} // for
		for (int idx = 0; idx < names.length; idx++) {
			System.out.printf("%d번재 %s의 키는 %d\n", idx, names[idx], heights[idx]);
		}
		System.out.println("평균키 :" + (double) totHeights / names.length);
		// 최장신(키,이름), 최단신(키,이름)
		int maxHeight = heights[0], maxIdx = 0; // max값 초기화는 아주 작은 값이나 0방
		int minHeight = heights[0], minIdx = 0; // min값 초기화는 아주 큰 값이나 0방
		for (int idx = 0; idx < names.length; idx++) {
			if (heights[idx] > maxHeight) {// 최대값
				maxHeight = heights[idx];
				maxIdx = idx;
			} // if 최대값
			if (heights[idx] < minHeight) {// 최소값
				minHeight = heights[idx];
				minIdx = idx;
			}// if 최소값
		}//for
		System.out.printf("최장신 %s의 키는 %d\n", names[maxIdx], maxHeight);
		System.out.printf("최단신 %s의 키는 %d\n", names[minIdx], minHeight);
		sc.close();
	}
}
