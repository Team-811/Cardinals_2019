/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * This is a subsystem class.  A subsystem interacts with the hardware components on the robot.
 */
public class Climber extends Subsystem implements ISubsystem{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static Climber instance = new Climber();
                                                                                                                                      
  public static Climber getInstance() {
      return instance;
  }

  private CANSparkMax armMotor;
  private CANSparkMax stiltMotor;
  private TalonSRX wheelMotor;

  private DigitalInput armLimitSwitch;
  private DigitalInput stiltLimitSwitch;
  private DigitalInput habLimitSwitch;

  private AHRS gyro;

  public Climber()
  {

    armMotor = new CANSparkMax(RobotMap.CLIMBER_ARM_MOTOR, MotorType.kBrushless);
    stiltMotor = new CANSparkMax(RobotMap.CLIMBER_STILT_MOTOR, MotorType.kBrushless);
    wheelMotor = new TalonSRX(RobotMap.CLIMBER_WHEEL_MOTOR); 

    armMotor.setInverted(false);
    stiltMotor.setInverted(false);
    wheelMotor.setInverted(false);

    armMotor.setIdleMode(IdleMode.kBrake);
    stiltMotor.setIdleMode(IdleMode.kBrake);
    wheelMotor.setNeutralMode(NeutralMode.Brake);

    armLimitSwitch = new DigitalInput(RobotMap.CLIMBER_ARM_LIMIT_SWITCH);
    stiltLimitSwitch = new DigitalInput(RobotMap.CLIMBER_STILT_LIMIT_SWITCH);
    habLimitSwitch = new DigitalInput(RobotMap.CLIMBER_HAB_LIMIT_SWITCH);

    Drivetrain drivetrain = Drivetrain.getInstance(); //Only used to get gyro instance
    gyro = drivetrain.getGyro();



  }

  //ClimberMethods

  public void setArmMotor(double value)
  {
    armMotor.set(value);
      
  }

  public void setStiltMotor(double value)
  {
    stiltMotor.set(value);
      
  }

  public void setWheelMotor(double rotation)
  {
    wheelMotor.set(ControlMode.PercentOutput, rotation);
      
  }

  public void levelClimb(double value)
  {
      double motorCorrection = gyro.getPitch() * 0.04;

      armMotor.set(value - motorCorrection);
      stiltMotor.set(value + motorCorrection);
  }

  public boolean getArmSwitch() {
    return armLimitSwitch.get();
  }

  public boolean getStiltSwitch() {
    return stiltLimitSwitch.get();
  }

  public boolean getHabSwitch() {
    return habLimitSwitch.get();
  }

  @Override
  public void outputSmartdashboard() 
  {
    
  }

  @Override
  public void zeroSensors() 
  {
    
  }

  @Override
  public void resetSubsystem() 
  {
    
  }



  @Override
  public void testSubsystem() {
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
