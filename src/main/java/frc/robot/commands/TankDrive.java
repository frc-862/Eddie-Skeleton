// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TankDrive extends Command {
  // The drivetrain we are controlling
  private Drive drivetrain;
  
  // Powers
  private DoubleSupplier leftPower;
  private DoubleSupplier rightPower;

  /** Creates a new TankDrive. */
  public TankDrive(Drive drivetrain, DoubleSupplier leftPower, DoubleSupplier rightPower) {
    // Set the drivetrain
    this.drivetrain = drivetrain;

    // Set the powers
    this.leftPower = leftPower;
    this.rightPower = rightPower;

    // Add requirements for the drivetrain
    addRequirements(this.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Actuallyset the powers
    drivetrain.setLeftPower(leftPower.getAsDouble());
    drivetrain.setRightPower(rightPower.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
