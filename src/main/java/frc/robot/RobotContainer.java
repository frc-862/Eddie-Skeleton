// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Collect;
import frc.robot.commands.Shoot;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Shooter;
import frc.utils.LightningContainer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer extends LightningContainer{
    Drive drivetrain;
    Shooter shooter;
    Collector collector;

    XboxController driver;
    XboxController copilot;
  
    @Override
    protected void initializeSubsystems() {
        drivetrain = new Drive();
        shooter = new Shooter();
        collector = new Collector();

        driver = new XboxController(0);
        copilot = new XboxController(1);
    }

    @Override
    protected void initializeNamedCommands() {
        // NOTHINGNNGIN
    }

    @Override
    protected void configureButtonBindings() {
        new Trigger(copilot::getAButton).whileTrue(new Collect(collector, 1));
        new Trigger(copilot::getBButton).whileTrue(new Collect(collector, -1));

        new Trigger(copilot::getYButton).whileTrue(new Shoot(shooter, 1));
    }

    @Override
    protected void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new TankDrive(drivetrain, driver::getLeftY, driver::getRightY));
    }

    @Override
    protected Command getAutonomousCommand() {
        return new InstantCommand();
    }
}
