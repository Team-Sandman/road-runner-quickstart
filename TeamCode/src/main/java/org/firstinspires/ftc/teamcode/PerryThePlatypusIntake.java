package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PerryThePlatypusIntake {
    private DcMotor intake_motor;

    public void initIntake( HardwareMap hwMap) {
        intake_motor = hwMap.get(DcMotor.class, "left_side_odometry");
        intake_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intake_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
    public void intake(double speed){

        intake_motor.setPower(speed);
    }
}
