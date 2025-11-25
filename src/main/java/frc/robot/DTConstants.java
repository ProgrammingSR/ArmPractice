package frc.robot;

import edu.wpi.first.math.util.Units;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

public class DTConstants {

    // TODO: set motor and encoder constants
    public static final int kFrontLeftDriveMotorPort = 32;
    public static final int kRearLeftDriveMotorPort = 29;
    public static final int kFrontRightDriveMotorPort = 36;
    public static final int kRearRightDriveMotorPort = 34;

    public static final int kFrontLeftTurningMotorPort = 28;
    public static final int kRearLeftTurningMotorPort = 22;
    public static final int kFrontRightTurningMotorPort = 37;
    public static final int kRearRightTurningMotorPort = 26;

    public static final int kFrontLeftTurningEncoderPort = 5;
    public static final int kRearLeftTurningEncoderPort = 6;
    public static final int kFrontRightTurningEncoderPort = 3;
    public static final int kRearRightTurningEncoderPort = 4;

    // TODO: Test motor orientations before driving on an actual robot
    public static final boolean kFrontLeftDriveMotorReversed = false;
    public static final boolean kRearLeftDriveMotorReversed = false;
    public static final boolean kFrontRightDriveMotorReversed = true;
    public static final boolean kRearRightDriveMotorReversed = true;

    /** Distance between centers of right and left wheels on robot (in meters). */
    public static final double kTrackWidth = 0.57785;

    /** Distance between front and back wheels on robot (in meters). */
    public static final double kWheelBase = 0.57785;

    /** Diameter of each wheel in the SDS MK4i swerve module (in meters) */
    public static final double kWheelDiameterMeters = 0.1;

    /** Gear ratio between the motor and the wheel. */
    public static final double kDrivingGearRatio = 8.14; // SDS MK4i's in L1 Configuration
    // public static final double kDrivingGearRatio = 6.75; // SDS MK4i's in L2
    // configuration

    // TODO: Tune this PID before running on a robot on the ground
    public static final double kPModuleTurningController = 0.3;

    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
        new Translation2d(kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

    /** For a a SDS Mk4i L1 swerve base with Neo Vortexes */
    public static final double kMaxSpeedMetersPerSecond = 4.4196;
    /** For a a SDS Mk4i L1 swerve base with Neo Vortexes */
    public static final double kMaxAngularSpeedRadiansPerSecond = 10.8164;
    // ^^ Calculated using the method taken from the old SDS github example

    /** Heading Correction */
    public static final double kHeadingCorrectionTurningStopTime = 0.2;
    // TODO: Tune this PID before running on a robot on the ground
    public static final double kPHeadingCorrectionController = 5;

}