/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc;

public enum DSButton {
	sq(1), x(2), o(3), tri(4), lb(5), rb(6), lt(7), rt(8), share(9), options(10), psBtn(13), povNone(-1, true),
	povU(0, true), povR(90, true), povD(180, true), povL(270, true);

	private int id;
	private boolean isPov = false;

	private DSButton(int id) {
		this.id = id;
	}

	private DSButton(int id, boolean isPov) {
		this.id = id;
		this.isPov = isPov;
	}

	public int getId() {
		return id;
	}

	public boolean isPov() {
		return isPov;
	}
}