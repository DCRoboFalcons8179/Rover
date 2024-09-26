package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;

public class Constants {
    public static int controllerPort = 0;

    public class Drive {
        // Left Side Motors
        public static int leftDriveID = 5;
        public static boolean leftDriveInverted = true;

        public static int leftFollowerID = 3;
        public static boolean leftFollowerInverted = true;

        // Right Side Motors
        public static int rightDriveID = 2;
        public static boolean rightDriveInverted = false;
        
        public static int rightFollowerID = 4;
        public static boolean rightFollowerInverted = false;
    }

    // Constants for the camera
    public class Camera {
        public static String cameraName = "CameraPlaceHolder";
        public static double cameraAngle = Rotation2d.fromDegrees(25).getRadians();
        public static double cameraHeightMeters = 0.40005;
        public static double targetHeightMeters = Units.inchesToMeters(36.5);
    }
}
