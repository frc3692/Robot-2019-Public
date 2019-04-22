/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc.drivetrain;

import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

import frc.robot.misc.CircularList;

public class DriveMapManager extends SendableBase {
	String name = "Drive Map Manager", subsystem = "Drivetrain";
	CircularList<DriveMap> mappings;

	public DriveMapManager(DriveMap... mappings) {
		this.mappings = new CircularList<>(mappings);
	}

	@Override
	public void initSendable(SendableBuilder builder) {
		builder.setSmartDashboardType("Drive Map Manager");
		builder.addStringProperty("Map", () -> mappings.get().getName(), this::set);
	}

	public DriveMap getNextMode() {
		mappings.next();
		return mappings.get();
	}

	public DriveMap getCurMode() {
		return mappings.get();
	}

	public void set(String s) {
		DriveMap orig = mappings.get();
		s = s.toLowerCase();
		while (!mappings.get().getName().toLowerCase().equals(s) && !mappings.get().getName().equals(orig.getName()))
			mappings.next();
	}
}