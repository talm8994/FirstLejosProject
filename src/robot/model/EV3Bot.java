package robot.model;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
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
	private EV3UltrasonicSensor distanceSensor;
	private float [] ultrasonicSamples;
	
	public void EV3Bot()
	{
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
		setupPilot();
	}
	
	public void driveRoom()
	{
		ultrasonicSamples = new float [distanceSensor.sampleSize()];
		distanceSensor.fetchSample(ultrasonicSamples, 0);
		if(ultrasonicSamples[0] < 2.5)
		{
			botPilot.travel(23.00);
			botPilot.rotate(90);
		}
		else
		{
			botPilot.travel(254.00);
		}
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