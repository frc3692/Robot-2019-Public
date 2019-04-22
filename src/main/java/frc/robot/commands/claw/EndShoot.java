/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.claw;

import edu.wpi.first.wpilibj.command.InstantCommand;

import frc.robot.Robot;
import frc.robot.misc.pneumatics.SolState;

public class EndShoot extends InstantCommand {

	public EndShoot() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.claw);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		if (!Robot.getControlJoy().getXBtn())
			Robot.claw.setShoot(SolState.closed);
	}
}
