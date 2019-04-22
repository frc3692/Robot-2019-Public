/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc.pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class DoubleWrapper extends SolWrapper {
	DoubleSolenoid base;

	public DoubleWrapper(int fwd, int rev) {
		this.base = new DoubleSolenoid(fwd, rev);
		base.set(Value.kReverse);

		set(SolState.closed);
		setBase(base);
	}

	public void set(SolState state) {
		setState(state);
		base.set((state == SolState.open) ? Value.kForward : Value.kReverse);
	}
}