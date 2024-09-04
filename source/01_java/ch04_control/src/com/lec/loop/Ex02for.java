package com.lec.loop;
// 1~10 까지 누적합 출력 
public class Ex02for {
	public static void main(String[] args) {
		int total =0;
				for(int i=1; i<=10 ; i++) {
			total += i; //total=total +i;
			if(i == 10) {
				System.out.print(i+"=");
			}else {
				System.out.print(i+"+");
			
			}
		}
		System.out.println(total);
	
	}
}
