/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.commands.loops.ClawLoop;
import frc.robot.misc.pneumatics.SolState;
import frc.robot.misc.pneumatics.SolWrapper;
import frc.robot.misc.pneumatics.DoubleWrapper;

public class Claw extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private TalonSRX angleTalon = new TalonSRX(RobotMap.ANGLE_TALON);
	private SolWrapper arms, shoot;

	public Claw() {
		arms = new DoubleWrapper(RobotMap.ARMS_0, RobotMap.ARMS_1);
		shoot = new DoubleWrapper(RobotMap.SHOOT_0, RobotMap.SHOOT_1);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ClawLoop());
	}

	public void driveAngle(double speed) {
		angleTalon.set(ControlMode.PercentOutput, speed);
	}

	public void setArms(SolState state) {
		arms.set(state);
	}

	public void toggleArms() {
		arms.toggle();
	}

	public void setShoot(SolState state) {
		shoot.set(state);
	}

	public void toggleShoot() {
		shoot.toggle();
	}

	public boolean isShootOut() {
		return shoot.getState() == SolState.open;
	}
}
