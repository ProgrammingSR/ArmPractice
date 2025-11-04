
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
import com.revrobotics.spark.SparkLowLevel.MotorType;

 
public class OutakeSubsystem extends SubsystemBase {
     
    private final PIDController controlly = new PIDController(50, 0.001, 0);

    //private final SparkAbsoluteEncoder pivot_encoder = pivot_motor.getAbsoluteEncoder();

    private final SparkFlex top_motor = new SparkFlex(Constants.kTopShooterMotorPort,  SparkLowLevel.MotorType.kBrushless);
    private final SparkFlex bottom_motor = new SparkFlex(Constants.kBottomShooterMotorPort,  SparkLowLevel.MotorType.kBrushless);

    public void periodic() {
        SmartDashboard.putNumber("setpoint", controlly.getSetpoint());
    }

    public OutakeSubsystem() {
        
    }

    public void stop() {
        top_motor.set(0.0);
        bottom_motor.set(0.0);
    }

    public void runRollers() {
        top_motor.set(0.6);
        bottom_motor.set(0.6);
    }

}

