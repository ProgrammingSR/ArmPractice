package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.SubSystem.IntakeSubsystem;


public class TransferRoller extends Command {
    private IntakeSubsystem m_intakeSubsystem;
    
    public TransferRoller(IntakeSubsystem subsystem) {
        m_intakeSubsystem = subsystem;
        addRequirements(m_intakeSubsystem);
      }
        
      @Override
      public void initialize() {
        m_intakeSubsystem.transferRollers();
      }

      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        
        return false;
      }
    
}  

