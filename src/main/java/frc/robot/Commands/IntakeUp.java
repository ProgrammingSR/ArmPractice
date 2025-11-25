package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.SubSystem.IntakeSubsystem;


public class IntakeUp extends Command {
    private IntakeSubsystem m_intakeSubsystem;
    
    public IntakeUp(IntakeSubsystem subsystem) {
        m_intakeSubsystem = subsystem;
        addRequirements(m_intakeSubsystem);
      }
        
      @Override
      public void initialize() {
        m_intakeSubsystem.setpointValue(Constants.kIntakeRaisedAngle);
      }

      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return m_intakeSubsystem.armAtSetpoint();
      }
    
}  

