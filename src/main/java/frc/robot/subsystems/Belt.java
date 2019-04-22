/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.commands.loops.BeltLoop;

public class Belt extends Subsystem {
	private TalonSRX beltTalon = new TalonSRX(RobotMap.BELT_TALON);
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public Belt() {
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new BeltLoop());
	}

	public void drive(double speed) {
		beltTalon.set(ControlMode.PercentOutput, speed);
	}
}
