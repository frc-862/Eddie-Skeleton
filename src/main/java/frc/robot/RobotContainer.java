// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.RobotMap;
import frc.robot.commands.Consume;
import frc.robot.commands.Shoot;
import frc.robot.commands.TankDrive;
import frc.robot.commands.autos.Test;
import frc.robot.subsystems.Consumer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.utils.LightningContainer;
import frc.utils.shuffleboard.LightningShuffleboard;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer extends LightningContainer {
    private Drivetrain drivetrain;
    private Shooter shooter;
    private Consumer consumer;

    private static XboxController driver;
    private static XboxController copilot;

    SendableChooser<Command> autoChooser;

    @Override
    protected void initializeSubsystems() {
        drivetrain = new Drivetrain();
        shooter = new Shooter();
        consumer = new Consumer();

        driver = new XboxController(RobotMap.DRIVER_PORT);
        copilot = new XboxController(RobotMap.COPILOT_PORT);
    }

    @Override
    protected void configureButtonBindings() {
        new Trigger(copilot::getAButton).whileTrue(new Shoot(shooter, () -> 1));
    }

    @Override
    protected void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new TankDrive(drivetrain, () -> driver.getLeftY(), () -> driver.getRightY()));

        consumer.setDefaultCommand(new Consume(consumer, () -> (copilot.getRightTriggerAxis() - copilot.getLeftTriggerAxis())));
    }

    @Override
    protected void initializeNamedCommands() {
        autoChooser = new SendableChooser<Command>();
        autoChooser.addOption("test", new Test(drivetrain, shooter));
        LightningShuffleboard.send("Autonomous", "Auto Chooser", autoChooser);
    }

    @Override
    protected Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}
