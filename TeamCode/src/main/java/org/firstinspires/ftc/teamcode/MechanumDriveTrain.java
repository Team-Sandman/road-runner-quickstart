package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class MechanumDriveTrain {
    private DcMotor left_front_drive_motor;
    private DcMotor left_back_drive_motor;
    private DcMotor right_front_drive_motor;
    private DcMotor right_back_drive_motor;

    public void initMechanumDrivetrainTeleOp(HardwareMap hwMap) {
        left_front_drive_motor = hwMap.get(DcMotor.class, "front_left_motor");
        left_back_drive_motor = hwMap.get(DcMotor.class, "back_left_motor");
        right_front_drive_motor = hwMap.get(DcMotor.class, "front_right_motor");
        right_back_drive_motor = hwMap.get(DcMotor.class, "back_right_motor");
        left_front_drive_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_back_drive_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_front_drive_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_back_drive_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_front_drive_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_back_drive_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_front_drive_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_back_drive_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_front_drive_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        left_back_drive_motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void mechanumDrive(double x, double y, double turn) {
        left_front_drive_motor.setPower(x - y + turn);
        right_front_drive_motor.setPower(-x - y - turn);
        left_back_drive_motor.setPower(-x - y + turn);
        right_back_drive_motor.setPower(x - y - turn);
    }

    public double forwardMultiplier(double y) {
        if (y < 0) {
            return (-.3 * y * y + .15 * y - .05);
        } else if (y > 0) {
            return (.3 * y * y + .15 * y + .05);
        } else return (0);
    }

    public double strafeMultiplier(double x) {
        if (x < 0) {
            return (-.3 * x * x + .05 * x - .05);
        } else if (x > 0) {
            return (.3 * x * x + .05 * x + .05);
        } else return (0);
    }

    public double turnMultiplier(double turn) {
        if (turn < 0) {
            return (-.1 * turn * turn + .35 * turn - .05);
        } else if (turn > 0) {
            return (.1 * turn * turn + .35 * turn + .05);
        } else return (0);
    }
}
