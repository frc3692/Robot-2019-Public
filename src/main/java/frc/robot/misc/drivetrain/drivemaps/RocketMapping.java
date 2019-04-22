/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc.drivetrain.drivemaps;

import frc.robot.Robot;
import frc.robot.misc.DS4;
import frc.robot.misc.DSAxis;
import frc.robot.misc.DSButton;
import frc.robot.misc.drivetrain.DriveMap;
import frc.robot.misc.drivetrain.DriveData;

public class RocketMapping implements DriveMap {
	public DriveData drive() {
		DS4 drive = Robot.getDriveJoy();

		double speedmult;
		if (drive.getRawButton(DSButton.o)) // O Button Speed Boost
			speedmult = 1;
		else if (drive.getRawButton(DSButton.tri)) // Triangle Button Slow Speed
			speedmult = .5;
		else // Otherwise Normal Speed
			speedmult = .7;

		double y = drive.getNetTriggers();
		double z = drive.getRawAxis(DSAxis.rx);

		return new DriveData(y * speedmult, z * speedmult);
	}

	public String getName() {
		return "Rocket League";
	}
}