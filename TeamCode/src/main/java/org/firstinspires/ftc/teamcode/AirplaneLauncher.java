package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class AirplaneLauncher {
    private DcMotor launch_motor;
    public void initLaunchMotor( HardwareMap hwMap) {
        launch_motor = hwMap.get(DcMotor.class, "right_side_odometry");
        launch_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        launch_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
    public void launch(double speed){
        launch_motor.setPower(speed);
    }
}
