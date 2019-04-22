/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lifts;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.misc.pneumatics.SolState;

public class OperateMainLift extends Command {

	public OperateMainLift() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lifts);
		setInterruptible(false);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		Robot.lifts.setMainLift(SolState.open);
		Robot.lifts.setMiniLift(SolState.closed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.lifts.setMainLift(SolState.closed);
	}
}
