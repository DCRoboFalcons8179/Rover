// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.lib.math.Filter;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.TankDrive;

public class RobotContainer {
  // Controller Objects
  private Joystick driverController = new Joystick(Constants.controllerPort);
  

  // Button Objects


  
  // Subsystems
  private TankDrive tankDrive = new TankDrive();

  public RobotContainer() {
    // Drives the robot
    tankDrive.setDefaultCommand(new TeleopDrive(tankDrive, () -> driverController.getRawAxis(XboxController.Axis.kLeftY.value), () -> Filter.powerCurve(driverController.getRawAxis(XboxController.Axis.kRightX.value), 3)));
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
