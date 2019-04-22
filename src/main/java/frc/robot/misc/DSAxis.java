/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc;

public enum DSAxis {
	lx(0), ly(1), rx(2), rt(3), lt(4), ry(5);

	private int id;

	private DSAxis(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}