package frc.robot.SubSystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.MathUtil;
import frc.robot.Constants;
import frc.robot.DTConstants;
import frc.robot.Robot;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;


public class DrivetrainSubsystem extends SubsystemBase {

    private final SwerveModule m_frontLeft = new SwerveModule(
        DTConstants.kFrontLeftDriveMotorPort,
        DTConstants.kFrontLeftTurningMotorPort,
        DTConstants.kFrontLeftTurningEncoderPort,
        DTConstants.kFrontLeftDriveMotorReversed);

    private final SwerveModule m_rearLeft = new SwerveModule(
        DTConstants.kRearLeftDriveMotorPort,
        DTConstants.kRearLeftTurningMotorPort,
        DTConstants.kRearLeftTurningEncoderPort,
        DTConstants.kRearLeftDriveMotorReversed);
    
    private final SwerveModule m_frontRight = new SwerveModule(
        DTConstants.kFrontRightDriveMotorPort,
        DTConstants.kFrontRightTurningMotorPort,
        DTConstants.kFrontRightTurningEncoderPort,
        DTConstants.kFrontRightDriveMotorReversed);
    
    private final SwerveModule m_rearRight = new SwerveModule(
        DTConstants.kRearRightDriveMotorPort,
        DTConstants.kRearRightTurningMotorPort,
        DTConstants.kRearRightTurningEncoderPort,
        DTConstants.kRearRightDriveMotorReversed);

    private SwerveModulePosition[] m_swerveModulePositions = new SwerveModulePosition[] {
        m_frontLeft.getPosition(),
        m_frontRight.getPosition(),
        m_rearLeft.getPosition(),
        m_rearRight.getPosition()
    };

    SwerveModuleState[] swerveModuleStates = { new SwerveModuleState(), new SwerveModuleState(), new SwerveModuleState(), new SwerveModuleState() };

    public DrivetrainSubsystem() {

    } 

    public void periodic() {
        m_swerveModulePositions = new SwerveModulePosition[] {
            m_frontLeft.getPosition(),
            m_frontRight.getPosition(),
            m_rearLeft.getPosition(),
            m_rearRight.getPosition()
        };

        setModuleStates(swerveModuleStates);
    }

    public void reset() {

    }

    public void drive(double xSpeed, double ySpeed, double rotation, boolean fieldRelative) {
        
        var speeds = new ChassisSpeeds(xSpeed, ySpeed, rotation);

        swerveModuleStates = DTConstants.kDriveKinematics.toSwerveModuleStates(ChassisSpeeds.fromFieldRelativeSpeeds(speeds, new Rotation2d(rotation)));

        
    }

    public ChassisSpeeds getChassisSpeeds() {
        return DTConstants.kDriveKinematics.toChassisSpeeds(swerveModuleStates);
    }

    private void setModuleStates(SwerveModuleState[] desiredStates) {
        SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, DTConstants.kMaxSpeedMetersPerSecond);

        //TODO: use m_feedforwards and do null check
        m_frontLeft.setDesiredState(desiredStates[0]);
        m_frontRight.setDesiredState(desiredStates[1]);
        m_rearLeft.setDesiredState(desiredStates[2]);
        m_rearRight.setDesiredState(desiredStates[3]);

        // AdvantageScope Logging
        double[] logData = {
            desiredStates[0].angle.getDegrees(), desiredStates[0].speedMetersPerSecond,
            desiredStates[1].angle.getDegrees(), desiredStates[1].speedMetersPerSecond,
            desiredStates[2].angle.getDegrees(), desiredStates[2].speedMetersPerSecond,
            desiredStates[3].angle.getDegrees(), desiredStates[3].speedMetersPerSecond,
        };
        SmartDashboard.putNumberArray("AdvantageScope Swerve Desired States", logData);

    }
}