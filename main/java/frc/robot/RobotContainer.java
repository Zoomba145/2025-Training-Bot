// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final ManipulatorSubsystem manipulatorSubsystem = new ManipulatorSubsystem();
  // The robot's subsystems and commands are defined here...
  // TODO: initialize subsystems (driveSubsystem, elevatorSubsystem, manipulatorSubsystem)

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController driver = new CommandXboxController(0);
  private final CommandXboxController Operator = new CommandXboxController(1);
  // TODO: initialize controller (CommandXboxController) 
  private final SendableChooser<Command> m_autoChooser = new SendableChooser<Command>;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    initializeAutoChooser();
    driverSubsystem.setDefaultCommand(new RunCommand(() -> driverSubsystem.driverArcade(-m_driverController.getLeftY(), driverController.getRightX()), driveSubsystem));
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    OperatorController.leftBumper().whileTrue(new ElevatorSetPoint(elevatorSubsystem, 0.7));
    OperatorController.rightBumper().whileTrue(new ElevatorSetPoint(elevatorSubsystem, -0.7));
    OperatorController.a().onTrue(new ManipulatorOutake(manipulatorSubsystem, 0.2).withTimeout(11));
    OperatorController.b().onTrue(new ManipulatorOutake(manipulatorSubsystem, -0.2).withTimeout(11));
    new Trigger(m_exampleSubsystem::exampleCondition ElevatorSubsystem)
        .onTrue(new ExampleCommand(m_exampleSubsystem));
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    
    // TODO: configure bindings for the CommandXboxController. Button bindings are up to you, just ensure that they are valid. Bindings should include Arcade Drive, changing position of elevator, and shooting coral 
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
