package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "test")
public class Tester extends OpMode {
    DcMotor motorArm;
    DcMotor motorLWheel;
    DcMotor motorRWheel;

    @Override
    public void init() {
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        motorLWheel = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRWheel = hardwareMap.get(DcMotor.class, "motorRight");
        telemetry.addData("Initialization:", "does this work?");
        telemetry.update();
        System.out.println("HELP");
    }

    @Override
    public void loop() {
        motorArm.setPower(0);
        motorLWheel.setPower(0);
        motorRWheel.setPower(0);
        if (gamepad1.right_bumper){
            motorArm.setPower(1);
        }
        if (gamepad1.left_bumper) {
            motorArm.setPower(-1);
        }
        float x = gamepad1.left_stick_y;
        float y = gamepad1.right_stick_y;
        if(gamepad1.left_stick_y>5)
            motorLWheel.setPower(x);
        if(gamepad1.right_stick_y>5)
            motorRWheel.setPower(y);
    }
}
