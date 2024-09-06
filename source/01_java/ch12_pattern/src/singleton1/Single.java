package singleton1;

/* 데이터 영역 메모리 | heap 메모리 영역
 * 클래스(설계도) static |일반 변수 */
public class Single {
	private int i;
	private Single() {}
	private static Single INSTANCE = new Single();
	public static Single getInstance() {
		return INSTANCE;
	}
//	private static Single INSTANCE;
//	public static Single getInstance() {
//		//객체를 생성 안 햇으면 객체를 생성하고 그 주소를 return
//		//객체를 생성했었으면, 그 객체 주소를 return
//		if(INSTANCE == null) {
//			INSTANCE = new Single()	;
//		}
//		return INSTANCE;
//	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
