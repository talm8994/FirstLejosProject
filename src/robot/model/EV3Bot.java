package robot.model;

import lejos.hardware.lcd.LCD;
import lejos.utility.*;

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
		
	}
	
	public void displayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}

}