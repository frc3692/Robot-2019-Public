/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	// Pneumatics
	public final static int MAIN_LIFT_0 = 2;
	public final static int MAIN_LIFT_1 = 3;

	public final static int MINI_LIFT_0 = 0;
	public final static int MINI_LIFT_1 = 1;

	public final static int ARMS_0 = 4;
	public final static int ARMS_1 = 5;

	public final static int SHOOT_0 = 6;
	public final static int SHOOT_1 = 7;

	// Drivetrain
	public final static int BL_TALON = 1;
	public final static int FL_TALON = 2;

	public final static int FR_TALON = 3;
	public final static int BR_TALON = 4;

	// Lift
	public final static int BELT_TALON = 5;
	public final static int ANGLE_TALON = 6;
}
