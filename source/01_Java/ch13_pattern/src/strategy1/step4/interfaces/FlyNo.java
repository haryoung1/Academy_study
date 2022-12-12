package strategy1.step4.interfaces;

public class FlyNo implements Flyimpl {

	@Override
	public void fly() {
		System.out.println("날 수 없습니다");
	}
}