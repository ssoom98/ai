package strategy2.modularization;

import strategy2.interfaces.*;

public class Sonata extends Car {

	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}

	@Override
	public void shape() {
		System.out.println("소나타 문 시트 핸들로 이루어져있습니다.");

	}

}
