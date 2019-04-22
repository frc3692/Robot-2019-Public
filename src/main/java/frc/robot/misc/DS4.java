/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc;

import java.util.EnumMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DS4 extends Joystick implements AutoCloseable {
	private double deadband = 0.02;
	private EnumMap<DSButton, Button> buttons;

	public DS4(int port) {
		super(port);
		buttons = new EnumMap<>(DSButton.class);
	}

	public DS4(int port, double deadband) {
		this(port);
		this.deadband = deadband;
	}

	public Button getBtn(DSButton b) {
		if (buttons.containsKey(b))
			return buttons.get(b);
		Button btn = b.isPov() ? new POVButton(this, b.getId()) : new JoystickButton(this, b.getId());
		buttons.put(b, btn);
		return btn;
	}

	public boolean getRawButton(DSButton btn) {
		return getRawButton(btn.getId());
	}

	@Override
	public boolean getRawButton(int id) {
		return super.getRawButton(id);
	}

	public boolean getSqBtn() {
		return getRawButton(1);
	}

	public boolean getXBtn() {
		return getRawButton(2);
	}

	public boolean getCirBtn() {
		return getRawButton(3);
	}

	public boolean getTriBtn() {
		return getRawButton(4);
	}

	public boolean getLb() {
		return getRawButton(5);
	}

	public boolean getRb() {
		return getRawButton(6);
	}

	public boolean getLtBtn() {
		return getRawButton(7);
	}

	public boolean getRbBtn() {
		return getRawButton(8);
	}

	public boolean getShare() {
		return getRawButton(9);
	}

	public boolean getOptions() {
		return getRawButton(10);
	}

	public boolean getPovNone() {
		return getPOV() == -1;
	}

	public boolean getPovU() {
		return getPOV() == 0;
	}

	public boolean getPovR() {
		return getPOV() == 90;
	}

	public boolean getPovD() {
		return getPOV() == 180;
	}

	public boolean getPovL() {
		return getPOV() == 270;
	}

	public double getRawAxis(DSAxis axis) {
		return getRawAxis(axis.getId());
	}

	public double getRawAxis(DSAxis axis, boolean applyDeadband) {
		if (applyDeadband)
			return applyDeadband(getRawAxis(axis.getId()));
		return getRawAxis(axis.getId());
	}

	public double getRawAxis(int id, boolean applyDeadband) {
		if (applyDeadband)
			return applyDeadband(getRawAxis(id));
		return getRawAxis(id);
	}

	public double getX(boolean applyDeadband) {
		if (applyDeadband)
			return applyDeadband(super.getX());
		return getX();
	}

	public double getY(boolean applyDeadband) {
		if (applyDeadband)
			return applyDeadband(getY());
		return getY();
	}

	public double getZ(boolean applyDeadband) {
		if (applyDeadband)
			return applyDeadband(getZ());
		return getZ();
	}

	public double getTwist(boolean applyDeadband) {
		if (applyDeadband)
			return applyDeadband(getTwist());
		return getTwist();
	}

	public double getNetTriggers() {
		return getRawAxis(DSAxis.rt) - getRawAxis(DSAxis.lt);
	}

	public double getNetTriggers(boolean applyDeadband) {
		return getRawAxis(DSAxis.rt, applyDeadband) - getRawAxis(DSAxis.lt, applyDeadband);
	}

	private double applyDeadband(double value) {
		if (Math.abs(value) > deadband) {
			if (value > 0.0) {
				return (value - deadband) / (1.0 - deadband);
			} else {
				return (value + deadband) / (1.0 - deadband);
			}
		} else {
			return 0.0;
		}
	}

	public void close() {
		for (Button b : buttons.values())
			b.close();
		buttons.clear();
	}
}