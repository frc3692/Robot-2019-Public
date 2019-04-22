/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;
import frc.robot.commands.loops.DriveLoop;

import frc.robot.misc.drivetrain.drivemaps.*;
import frc.robot.misc.drivetrain.DriveMapManager;

public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public DriveMapManager dMaps = new DriveMapManager(new ArcadeMapping(), new RocketMapping());

	private SpeedControllerGroup left = new SpeedControllerGroup(new WPI_TalonSRX(RobotMap.FL_TALON),
			new WPI_TalonSRX(RobotMap.BL_TALON));
	private SpeedControllerGroup right = new SpeedControllerGroup(new WPI_TalonSRX(RobotMap.FR_TALON),
			new WPI_TalonSRX(RobotMap.BR_TALON));

	private DifferentialDrive drive = new DifferentialDrive(left, right);

	public Drivetrain() {
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

		setDefaultCommand(new DriveLoop());
	}

	public void drive(double xSpeed, double zRotation) {
		drive.arcadeDrive(xSpeed, zRotation);
	}
}
