// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.math.Filter;
import frc.robot.Constants;

public class TankDrive extends SubsystemBase {
  // Left Side Motor Object Creation
  private VictorSPX leftDrive = new VictorSPX(Constants.Drive.leftDriveID);
  private VictorSPX leftFollower = new VictorSPX(Constants.Drive.leftFollowerID);

  // Right Side Motor Object Creation
  private VictorSPX rightDrive = new VictorSPX(Constants.Drive.rightDriveID);
  private VictorSPX rightFollower = new VictorSPX(Constants.Drive.rightFollowerID);  

  /** Creates a new TankDrive. */
  public TankDrive() {
    // Left Side Motors Configuration
    leftDrive.setInverted(Constants.Drive.leftDriveInverted);
    leftFollower.setInverted(Constants.Drive.leftFollowerInverted);

    // Right Side Motors Configuration
    rightDrive.setInverted(Constants.Drive.rightDriveInverted);
    rightFollower.setInverted(Constants.Drive.rightFollowerInverted);
  }

  @Override
  public void periodic() {}

  public void drive(double speed, double turn) {
    // Sets the speeds of the respective sides
    double leftSpeed = speed + turn;
    double rightSpeed = speed - turn;
    
    // Make sure values aren't above 1 or below -1
    leftSpeed = Filter.cutoffFilter(leftSpeed);
    rightSpeed = Filter.cutoffFilter(rightSpeed);
    
    // Set the drive motors to drive
    leftDrive.set(ControlMode.PercentOutput, leftSpeed);
    rightDrive.set(ControlMode.PercentOutput, rightSpeed);

    // Set the follower motors to follow
    leftFollower.follow(leftDrive);
    rightFollower.follow(rightFollower);
  }
}
