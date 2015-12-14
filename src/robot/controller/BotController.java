package robot.controller;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

import robot.model.*;

public class BotController
{
	private String message;
	
	private int xPosition;
	private int yPosition;
	
	private long waitTime;
	
	private EV3Bot thomasBot;
	
	public BotController()
	{
		this.message = "Programing lego robots";
		this.xPosition = 10;
		this.yPosition = 10;
		this.waitTime = 4000;
		
		thomasBot = new EV3Bot();
	}
	
	public void start()
	{
		LCD.drawString(message, xPosition, yPosition);
		Delay.msDelay(waitTime);
		
		thomasBot.driveRoom();
	}

}
