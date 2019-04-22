/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc.pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public enum SolState {
	open, closed;

	public static SolState get(Value v) {
		switch (v) {
		case kForward:
			return SolState.open;
		case kReverse:
			return SolState.closed;
		default:
			return null;
		}
	}

	public static SolState get(boolean b) {
		return (b) ? SolState.open : SolState.closed;
	}

	public SolState invert() {
		return ((this == SolState.closed) ? SolState.open : SolState.closed);
	}
}