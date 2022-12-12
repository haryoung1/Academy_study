package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.Flyimpl;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

public class SuperRobot extends Robot {

	private Flyimpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public SuperRobot() {
		setFly(new FlyYes()); 			// fly = new FlyYes();
		setMissile(new MissileYes()); 	// missile = new MissileYes();
		setKnife(new KnifeLazer()); 	// knife = new KnifeLazer();
	}

	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();

	}

	@Override
	public void actionKnife() {
		knife.knife();

	}
	// setter ÇÊ¿ä

	public void setFly(Flyimpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
}