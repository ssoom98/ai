package strategy2.modularization;
import strategy2.interfaces.*;
public class CarTestMain {
	public static void main(String[] args) {
		Genesis genesis = new Genesis()	;
		Sonata sonata = new Sonata()	;
		Casper casper = new Casper()	;
		Car[] cars = {genesis,sonata,casper}; //위에 없애고 new로 넣어서 해도 된다.
		for(Car car : cars){
			car.shape();
			car.drive();
			car.isEngine();
			car.isKm();
			car.isFuel();	
			System.out.println("---------------------------");
		}
		System.out.println("Sonata의 FuleHybrid로 교체하고 연비를 20으로 업그레이드");
		sonata.setFuel(new FuelHybird());
		sonata.setKm(new Km20());
		sonata.isFuel();
		sonata.isKm();
	}	
}
