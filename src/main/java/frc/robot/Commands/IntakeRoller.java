package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubSystem.IntakeSubsystem;


public class IntakeRoller extends Command {
    private IntakeSubsystem m_intakeSubsystem;
    
    public IntakeRoller(IntakeSubsystem subsystem) {
        m_intakeSubsystem = subsystem;
        addRequirements(m_intakeSubsystem);
      }
        
      @Override
      public void initialize() {
        m_intakeSubsystem.runRollers();
      }

      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        
        return false;
      }
    
}  

