/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc.pneumatics;

import edu.wpi.first.wpilibj.Solenoid;

public class SingleWrapper extends SolWrapper {
	Solenoid base;

	public SingleWrapper(int id) {
		this.base = new Solenoid(id);
		base.set(false);

		set(SolState.closed);
		setBase(base);
	}

	public void set(SolState state) {
		setState(state);
		base.set((state == SolState.open) ? true : false);
	}
}