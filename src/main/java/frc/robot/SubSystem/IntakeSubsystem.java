
package frc.robot.SubSystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;

import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel;

 
public class IntakeSubsystem extends SubsystemBase {
     
    private final SparkFlex pivot_motor = new SparkFlex(Constants.kArmMotorID,  SparkLowLevel.MotorType.kBrushless);

    private final PIDController controlly = new PIDController(50, 0.001, 0);

    private final SparkAbsoluteEncoder pivot_encoder = pivot_motor.getAbsoluteEncoder();

    private final SparkFlex roller_motor = new SparkFlex(Constants.kIntakeMotorID,  SparkLowLevel.MotorType.kBrushless);


    public void periodic() {
        reachSetpoint();
        SmartDashboard.putNumber("encoder", pivot_encoder.getPosition());
        SmartDashboard.putNumber("setpoint", controlly.getSetpoint());
    }

    public IntakeSubsystem() {
        
    }
  
    public void setpointValue(double set_num) {
        controlly.setSetpoint(set_num);
    }

    public void reachSetpoint() {
        
        double position = controlly.calculate(pivot_encoder.getPosition());
        pivot_motor.set(MathUtil.clamp(position, -0.1, 0.1));

    }

    public void stop() {
        pivot_motor.set(0.0);
    }

    public boolean armAtSetpoint() {
        return controlly.atSetpoint();
    }

    public void runRollers() {
        roller_motor.set(0.1);
    }
    
    public void stopRollers() {
        roller_motor.set(0);
    }

    public void transferRollers() {
        roller_motor.set(-0.1);
    }
    
    public void reset() {
        stopRollers();

    }
}

