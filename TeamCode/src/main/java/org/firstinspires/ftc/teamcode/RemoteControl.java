package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.MechanumDriveTrain;
import org.firstinspires.ftc.teamcode.PerryThePlatypusIntake;
import org.firstinspires.ftc.teamcode.AirplaneLauncher;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
@TeleOp
public class RemoteControl extends OpMode {

    MechanumDriveTrain drive = new MechanumDriveTrain();
    PerryThePlatypusIntake  intake = new PerryThePlatypusIntake();
    AirplaneLauncher launch = new AirplaneLauncher();



    @Override
    public void init () {
        drive.initMechanumDrivetrainTeleOp(hardwareMap);
        intake.initIntake(hardwareMap);
        launch.initLaunchMotor(hardwareMap);

    }

    @Override
    public void loop() {

       if (gamepad1.left_bumper) {
           drive.mechanumDrive(gamepad1.right_stick_x, gamepad1.right_stick_y, gamepad1.left_stick_x);
        } else {
           drive.mechanumDrive(drive.strafeMultiplier(gamepad1.right_stick_x), drive.forwardMultiplier(gamepad1.right_stick_y) + drive.forwardMultiplier(gamepad1.left_trigger) - drive.forwardMultiplier(gamepad1.right_trigger), drive.turnMultiplier(gamepad1.left_stick_x));
        }
        intake.intake(gamepad2.right_trigger - gamepad2.left_trigger);
       launch.launch(gamepad2.left_stick_y);
    }
}


