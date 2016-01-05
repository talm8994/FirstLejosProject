package robot.model;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

public class EV3Bot
{
	public String botMessage;
	public int xPosition;
	public int yPosition;
	public long waitTime;
	private MovePilot botPilot;
	
	public void EV3Bot()
	{
		
	}
	
	public void driveRoom()
	{
		displayMessage();
		circles();
		drive();
	}
	
	private void displayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}
	
	private void displayMessage (String message)
	{
		LCD.drawString(message, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}
	
	private void circles()
	{
		 Motor.B.setSpeed(900);
		 Motor.A.setSpeed(720);
		 Motor.A.rotateTo(360);
		 Motor.B.rotateTo(360);
	}
	
	private void drive()
	{
		Motor.A.forward();
		Motor.B.forward();
	}
	
	private void setupPilot()
	{
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A, 43.2).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B, 43.2).offset(72);
		Chassis baseChassis = new WheeledChassis(new Wheel []{leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		botPilot = new MovePilot(baseChassis);
	}

}