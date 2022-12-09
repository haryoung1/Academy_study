package com.lec.ex07_robot;
// Robotorder order = new RobotOrder();
// order.action(robot);
public class RobotOrder {
	public void action(Robot robot) {
		if(robot instanceof DanceRobot) {
			DanceRobot tempRobot = (DanceRobot)robot;
			tempRobot.dance();
		}else if(robot instanceof DrawRobot) {
			DrawRobot temproRobot = (DrawRobot)robot;
			temproRobot.draw();
		}else if(robot instanceof SingRobot) {
			SingRobot tempRobot = (SingRobot)robot;
			tempRobot.Sing();
		}else {
			System.out.println("확장된 로봇 구현이 필요합니다");
		}
		
	}
}
