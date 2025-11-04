// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

public class Constants {
  public static final int kMotorPort = 0;
  public static final int kEncoderAChannel = 0;
  public static final int kEncoderBChannel = 1;
  public static final int kJoystickPort = 0;

  public static final String kArmPositionKey = "ArmPosition";

  // The P gain for the PID controller that drives this arm.
  public static final double kDefaultArmKp = 50.0;
  public static final double kDefaultArmSetpointDegrees = 75.0;

  // distance per pulse = (angle per revolution) / (pulses per revolution)
  //  = (2 * PI rads) / (4096 pulses)
  public static final double kArmEncoderDistPerPulse = 2.0 * Math.PI / 4096;

  public static final double kArmReduction = 200;
  public static final double kArmMass = 8.0; // Kilograms
  public static final double kArmLength = Units.inchesToMeters(30);
  public static final double kMinAngleRads = Units.degreesToRadians(-75);
  public static final double kMaxAngleRads = Units.degreesToRadians(255);

  public static final int kIntakeMotorID = 25;
  public static final int kArmMotorID = 39;
  public static final int kArmEncoderChannel = 1;

  // In degrees
  public static final double kIntakeLoweredAngle = -0.05;
  public static final double kIntakeRaisedAngle = 0.1;
  public static final double kIntakeAmpScoringAngle = 76; // 193 - 100 (previous angle)

  /** Encoder offset in rotations */
  public static final double kArmEncoderOffset = 98.2;

  public static final double kIntakeSpeed = 0.5;

  public static final int kProximityThreshold = 145;
  // public static final int kIRThreshold = 2;

}
