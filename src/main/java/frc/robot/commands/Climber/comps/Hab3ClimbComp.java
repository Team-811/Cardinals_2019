/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climber.comps;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Climber.single.*;

/**
 * This is a command.  A command is used to make actual actions happen on the robot.  It can be a single action or a sequence of actions.  This one is a combination of commands
 * that make the robot do a complete hab3 climb
 */

public class Hab3ClimbComp extends CommandGroup {

  public Hab3ClimbComp() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.

    addSequential(new ClimbUpToHab3());
    addSequential(new MoveRobot());
    addSequential(new RetractStilts());
    addSequential(new FinalMoveForward(1));
  }
}
