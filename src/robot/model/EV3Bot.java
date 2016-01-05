package robot.model;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class EV3Bot
{
	public String botMessage;
	public int xPosition;
	public int yPosition;
	public long waitTime;
	
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

}