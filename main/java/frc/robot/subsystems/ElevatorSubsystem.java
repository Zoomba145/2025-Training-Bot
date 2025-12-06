// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ManipulatorSubsystem extends SubsystemBase { 
    // TODO: Create one Talon motor
    private final SparkMax motorRight;
    private final SparkMax motorLeft;

    
    public ElevatorSubsystem() {
        // TODO: Assign the Talon Motor
        motorLeft = new SparkMax (4, MotorType.kBrushless);
        motorRight = new SparkMax (3, MotorType.kBrushless);
        SparkMaxConfig leftConfig = new SparkMaxConfig();
        SparkMaxConfig rightConfig = new SparkMaxConfig();
        leftConfig.smartCurrentLimit(40);
        motorLeft.configure(leftConfig, null, null);
        rightConfig.smartCurrentLimit(40);
        rightConfig.follow(motorLeft, true);
        motorRight.configure(rightConfig, null, null);
        }

    public void moveElevator(double speed) {
        motorLeft.set(speed);
    }  
}