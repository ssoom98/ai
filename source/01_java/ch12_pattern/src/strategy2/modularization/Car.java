package strategy2.modularization;

import strategy2.interfaces.EngineImpl;
import strategy2.interfaces.FuelImpl;
import strategy2.interfaces.KmImpl;

public abstract class Car {
	private EngineImpl engine;
	private FuelImpl fuel;
	private KmImpl km;
	
	public abstract void shape(); 
	public void drive() {
		System.out.println("드라이브 할 수 있습니다");
	}
	public void isEngine() {
		engine.engine();
	}
	public void isFuel() {
		fuel.Fuel();
	}
	public void isKm() {
		km.Km();
	}
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}
	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}
	public void setKm(KmImpl km) {
		this.km = km;
	}
	
}
