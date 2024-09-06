package strategy2.modularization;

import strategy2.interfaces.*;

public class Casper extends Car {

	public Casper() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}

	@Override
	public void shape() {
		System.out.println("캐스펀 문 시트 핸들로 이루어져있습니다.");

	}

}
