// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Shoot;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class Test extends SequentialCommandGroup {
    private Drivetrain drivetrain;
    private Shooter shooter;

    /** Creates a new test auto. */
    public Test(Drivetrain drivetrain, Shooter shooter) {
        this.drivetrain = drivetrain;
        this.shooter = shooter;

        addCommands(new TankDrive(drivetrain, () -> 0.25, () -> 0.25).withDeadline(new WaitCommand(1)),
        new Shoot(shooter, () -> 1));
    }
}
