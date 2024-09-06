package strategy2.modularization;

import strategy2.interfaces.*;

public class Genesis extends Car {

	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}

	@Override
	public void shape() {
		System.out.println("제네시스 문 시트 핸들로 이루어져있습니다.");

	}

}
