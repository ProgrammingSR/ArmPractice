package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.controllers.PPHolonomicDriveController;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;

import frc.robot.Commands.*;
import frc.robot.SubSystem.IntakeSubsystem;
import frc.robot.SubSystem.OutakeSubsystem;
import pabeles.concurrency.IntRangeTask;

import frc.robot.RobotContainer;

import frc.robot.SubSystem.DrivetrainSubsystem;;



public class RobotContainer {

    private static final String kDefaultAuto = "Default";
    private static final String kCustomAuto = "My Auto";
    private String m_autoSelected;
    private final SendableChooser<String> m_chooser = new SendableChooser<>();

    private final XboxController gameController = new XboxController(0);

    private final IntakeSubsystem m_IntakeSubsystem = new IntakeSubsystem();

    private final OutakeSubsystem m_OutakeSubsystem = new OutakeSubsystem();

    private final DrivetrainSubsystem m_robotDrive = new DrivetrainSubsystem();
   
    private final XboxController m_driverController = new XboxController(Constants.kDriverControllerPort);
    private final XboxController m_operatorController = new XboxController(Constants.kOperatorControllerPort);

    public RobotContainer() {

        m_robotDrive.setDefaultCommand(
        new RunCommand(
            () -> m_robotDrive.drive(
                MathUtil.applyDeadband(
                    m_driverController.getLeftX(), IOConstants.kControllerDeadband)
                    * DTConstants.kMaxSpeedMetersPerSecond
                    * (1 - m_driverController
                        .getRightTriggerAxis()
                        * IOConstants.kSlowModeScalar),
                // * 0.8,
                MathUtil.applyDeadband(
                    m_driverController.getLeftY(), IOConstants.kControllerDeadband)
                    * DTConstants.kMaxSpeedMetersPerSecond
                    * (1 - m_driverController
                        .getRightTriggerAxis()
                        * IOConstants.kSlowModeScalar),
                // * 0.8,
                MathUtil.applyDeadband(
                    -m_driverController.getRightX(),IOConstants.kControllerDeadband)
                    * DTConstants.kMaxAngularSpeedRadiansPerSecond
                    * (1 - m_driverController
                        .getRightTriggerAxis()
                        * IOConstants.kSlowModeScalar)
                    * 0.7,
                true),
            m_robotDrive));


            SequentialCommandGroup runIntake = new SequentialCommandGroup(new IntakeDown(m_IntakeSubsystem), new IntakeRoller(m_IntakeSubsystem));
            SequentialCommandGroup upIntake = new SequentialCommandGroup(new IntakeRollerStop(m_IntakeSubsystem), new IntakeUp(m_IntakeSubsystem));

            new JoystickButton(gameController, Button.kA.value)
            .whileTrue(runIntake)
            .whileFalse(upIntake);

            ParallelCommandGroup shoot = new ParallelCommandGroup(new TransferRoller(m_IntakeSubsystem), new Shoot(m_OutakeSubsystem));
            ParallelCommandGroup shootstop = new ParallelCommandGroup(new ShootStop(m_OutakeSubsystem), new IntakeRollerStop(m_IntakeSubsystem));

            new JoystickButton(gameController, Button.kB.value)
            .whileTrue(shoot)
            .whileFalse(shootstop);

            

    }

    public void resetAllSubsystems() {
        m_robotDrive.reset();
        m_IntakeSubsystem.reset();
        m_OutakeSubsystem.reset();
      }

    

}



