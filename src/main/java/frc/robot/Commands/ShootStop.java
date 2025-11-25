package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubSystem.OutakeSubsystem;


public class ShootStop extends Command {
    private OutakeSubsystem m_OutakeSubsystem;
    
    public ShootStop(OutakeSubsystem subsystem) {
      m_OutakeSubsystem = subsystem;
        addRequirements(m_OutakeSubsystem);
      }
        
      @Override
      public void initialize() {
        m_OutakeSubsystem.stop();
      }

      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        
        return false;
      }
    
}  

