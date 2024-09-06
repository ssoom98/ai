package strategy1.step2;

public class Robot {

	public void shape() {
		String className = getClass().getName(); // 클래스 이름"strategy1.step2.copy.RobotSuperRobot"
		int idx = className.lastIndexOf("."); // indexOf = .의 위치의 값을 반환 값이 없으면 -1,last는 반대부터
		String name = className.substring(idx + 1); // idx+1번째 부터 끝까지 스트링 추출
		System.out.println(name + "의 외형은 팔,다리,머리,몸통이 있습니다 = = =");
	}

	public void actionWalk() {
		System.out.println("걸을 수 있습니다");
	}

	public void actionRun() {
		System.out.println("달릴 수 있습니다");
	}
}
