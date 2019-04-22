/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc.drivetrain;

public class DriveData {
	private double xSpd, zRot;

	public DriveData(double xSpd, double zRot) {
		this.xSpd = xSpd;
		this.zRot = zRot;
	}

	public double getXSpd() {
		return xSpd;
	}

	public double getZRot() {
		return zRot;
	}
}