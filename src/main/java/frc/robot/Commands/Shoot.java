package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubSystem.OutakeSubsystem;


public class Shoot extends Command {
    private OutakeSubsystem m_OutakeSubsystem;
    
    public Shoot(OutakeSubsystem subsystem) {
      m_OutakeSubsystem = subsystem;
        addRequirements(m_OutakeSubsystem);
      }
        
      @Override
      public void initialize() {
        m_OutakeSubsystem.runRollers();
      }

      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        
        return false;
      }
    
}  

