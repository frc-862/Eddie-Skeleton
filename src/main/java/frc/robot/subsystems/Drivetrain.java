// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Drivetrain extends SubsystemBase {
    private Victor frontRightMotor;
    private Victor frontLeftMotor;
    private Victor backRightMotor;
    private Victor backLeftMotor;

    /** Creates a new Drivetrain Subsystem. */
    public Drivetrain() {
        frontRightMotor = new Victor(RobotMap.FRONT_RIGHT_DRIVE);
        backRightMotor = new Victor(RobotMap.BACK_RIGHT_DRIVE);

        frontLeftMotor = new Victor(RobotMap.FRONT_LEFT_DRIVE);
        backLeftMotor = new Victor(RobotMap.BACK_LEFT_DRIVE);

        frontLeftMotor.setInverted(true);
        backLeftMotor.setInverted(true);
    }

    @Override
    public void periodic() {}

    /**
     * Sets power to the left side of the drivetrain.
     * @param power
     */
    public void setLeftPower(double power) {
        frontLeftMotor.set(power);
        backLeftMotor.set(power);
    }

    /**
     * Sets power to the right side of the drivetrain.
     * @param power
     */
    public void setRightPower(double power) {
        frontRightMotor.set(power);
        backRightMotor.set(power);
    }

    /**
     * Stops the left side motors of the drivetrain.
     */
    public void stopLeft() {
        frontLeftMotor.stopMotor();
        backLeftMotor.stopMotor();
    }

    /**
     * Stops the right side motors of the drivetrain.
     */
    public void stopRight() {
        frontRightMotor.stopMotor();
        backRightMotor.stopMotor();
    }

    /**
     * Stops all the motors in the drivetrain.
     */
    public void stop() {
        frontRightMotor.stopMotor();
        backRightMotor.stopMotor();
        frontLeftMotor.stopMotor();
        backLeftMotor.stopMotor();
    }
}
