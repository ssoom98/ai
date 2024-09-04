package com.lec.loopQuiz;

// 2*1=2 3*1...9*1=9
//...
//....9*9=81
public class Quiz04 {
	public static void main(String[] args) {
		for (int j = 1; j <= 9; j++) {
			for (int i = 2; i <= 9; i++) {
				System.out.printf("%d * %d = %2d\t", i, j, i * j);
			}
			System.out.println();
		}
	}
}
