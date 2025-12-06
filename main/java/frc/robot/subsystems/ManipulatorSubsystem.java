// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ManipulatorSubsystem extends SubsystemBase { 
    // TODO: Create one Talon motor
    private TalonFX manipulator;

    
    public ManipulatorSubsystem() {
        // TODO: Assign the Talon Motor
        manipulator = new TalonFX (5) 
    }

    public void spinFoward(double fowardSpeed) {
        // Set speed of manipulator
        manipulator.set(fowardSpeed);
    }
}