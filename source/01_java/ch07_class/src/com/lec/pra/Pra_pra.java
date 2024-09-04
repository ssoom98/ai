package com.lec.pra;

public class Pra_pra {

		public static void main(String[] args) {
			Pra mBmw = new Pra();
			mBmw.setColor("Blue");
			mBmw.setCc(15000);
			
			System.out.println(mBmw.getColor()+"색 차량 배기량은" + mBmw.getCc()+ ", 속도는"+ mBmw.getSpeed());
			
		}
}
