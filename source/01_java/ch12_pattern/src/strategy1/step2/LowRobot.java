package strategy1.step2;

public class LowRobot extends Robot {

	public void actionFly() {
		System.out.println("날 수 없습니다");
	}

	public void actionMssile() {
		System.out.println("미사일을 쏠 수 없습니다");
	}

	public void actionKnife() {
		System.out.println("검도 없습니다");
	}
}
