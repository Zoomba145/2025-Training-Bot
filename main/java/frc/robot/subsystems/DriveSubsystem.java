// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  // TODO: Initialize a DifferentialDrive variable
  private final DifferentialDrive differentialDrive;
  // TODO: Initialize four CANSparkMax motors
  private final CANSparkMax motorFrontRight;
  private final CANSparkMax motorFrontLeft;
  private final CANSparkMax motorBackRight;
  private final CANSparkMax motorBackLeft;
  public ExampleSubsystem() {
    motorFrontLeft = new CANSparkMax (1, MotorType.kBrushless);
    motorFrontRight = new CANSparkMax (2, MotorType.kBrushless);
    motorBackLeft = new CANSparkMax (7, MotorType.kBrushless);
    motorBackRight = new CANSparkMax (8, MotorType.kBrushless);
    SparkMaxConfig allConfig = new SparkMaxConfig();
    SparkMaxConfig.smartCurrentLimit(40);

    motorBackRight.configure(allConfig, null, null);
    motorBackLeft.configure(allConfig, null, null);
    motorFrontRight.configure(allConfig, null, null);
    motorFrontLeft.configure(allConfig, null, null);
    motorBackRight.follow(motorFrontRight);
    motorBackleft.follow(motorFrontLeft);
    motorFrontRight.setInverted(true);

    // TODO: Set motor current limits
    // TODO: Set the rear left and right motors to be followers
    // TODO: Set one side of the motors to be inverted 
    // TODO: Assign the DifferentialDrive variable to a new DifferentialDrive object passing in the two front motors
    differentialDrive = new DifferentialDrive (motorFrontLeft, motorFrontRight);
    // TODO: Pass in a max speed 
    differentialDrive.setMaxOutput(0.7)
  }

  // TODO: Create an arcadeDrive method, taking in speed and rotation 
  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
