// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

 
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

 
/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */ 
  public class Robot extends TimedRobot
{
  
 
private static final int kJoystickChannel = 0;
  
 
private MecanumDrive m_robotDrive;
  
private Joystick m_stick;
  
 
@Override 
 public void robotInit ()
  {
    
WPI_TalonFX motor1 = new WPI_TalonFX (1);	// 1 is the CAN ID of the motor
    WPI_TalonFX motor2 = new WPI_TalonFX (2);	// 2 is the CAN ID of the motor
    WPI_TalonFX motor3 = new WPI_TalonFX (3);	// 3 is the CAN ID of the motor
    WPI_TalonFX motor4 = new WPI_TalonFX (4);	// 4 is the CAN ID of the motor
    
      // Invert the right side motors.
      // You may need to change or remove this to match your robot.
      motor3.setInverted (true);
    
motor1.setInverted (true);
    
 
 
m_robotDrive = new MecanumDrive (motor4, motor2, motor3, motor1);
    
 
 
 
m_stick = new Joystick (kJoystickChannel);
  
 
 
} 
 
@Override 
 public void teleopPeriodic ()
  {
    
      // Use the joystick X axis for lateral movement, Y axis for forward
      // movement, and Z axis for rotation.
      
m_robotDrive.driveCartesian (-m_stick.getY (), m_stick.getX (),
				    m_stick.getZ (), 0.0);

} 
} 
 