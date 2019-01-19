/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonSRX rightFrontMotor;
  private TalonSRX rightBackMotor;
  private TalonSRX leftFrontMotor;
  private TalonSRX leftBackMotor;

  public Drive() {
    rightFrontMotor = new TalonSRX(robot.RobotMap.RIGHT_FRONT_MOTOR);
    leftFrontMotor  = new TalonSRX(robot.RobotMap.LEFT_FRONT_MOTOR);
    rightBackMotor  = new TalonSRX(robot.RobotMap.RIGHT_BACK_MOTOR);
    leftBackMotor   = new TalonSRX(robot.RobotMap.LEFT_BACK_MOTOR);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
