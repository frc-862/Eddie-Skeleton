// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Drive extends SubsystemBase {
    // All the motors
    private Victor frontRightMotor = new Victor(RobotMap.FRONT_RIGHT_DRIVE);
    private Victor frontLeftMotor = new Victor(RobotMap.FRONT_LEFT_DRIVE);
    private Victor backRightMotor = new Victor(RobotMap.BACK_RIGHT_DRIVE);
    private Victor backLeftMotor = new Victor(RobotMap.BACK_LEFT_DRIVE);

    /** Creates a new Drive. */
    public Drive() {}

    // Nothing here
    @Override
    public void periodic() {}

    // Set the left side
    public void setLeftPower(double power) {
        frontLeftMotor.set(power);
        backLeftMotor.set(power);
    }

    // Set the right side
    public void setRightPower(double power) {
        frontRightMotor.set(power);
        backRightMotor.set(power);
    }

    // Stop the drive motors
    public void stop() {
        frontRightMotor.stopMotor();
        backRightMotor.stopMotor();
        frontLeftMotor.stopMotor();
        backLeftMotor.stopMotor();
    }
}
