package com.lec.ex2_protected;

//private(i,j) / public setter&getter 
// new Child() new Child(1,10)
public class Child extends SuperIJ {
	private int total;

	public Child() {
		System.out.println("매개변수 없는 Child 생성자");
	}

	public Child(int i, int j) {
		//setI(i);
		//setJ(j);
		this.i=i;
		this.j=j;
		System.out.println("매개변수 있는 Child 생성자");
	}
	public void sum() {
		//total = getI()+getJ();
		total = i+j;
		System.out.println("i="+ i //getI()
							+"j=" + j //getJ()
							+"total="+ total);
		
	}

}
