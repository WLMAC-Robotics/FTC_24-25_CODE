package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "CyberLyons")
public class Tester extends OpMode {
    DcMotor motorArm; // The Arm Motor
    DcMotor motorLFWheel; // Left Front Wheel
    DcMotor motorLBWheel; // Left Back Wheel
    DcMotor motorRFWheel; // Right Front Wheel
    DcMotor motorRBWheel; // Right Back Wheel
    float leftStickX;
    float leftStickY;
    float rightStickX;
    float rightStickY;


    public void initializeStuff(){
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        motorLFWheel = hardwareMap.get(DcMotor.class, "motorLF");
        motorLBWheel = hardwareMap.get(DcMotor.class, "motorLB");
        motorRFWheel = hardwareMap.get(DcMotor.class, "motorRF");
        motorRBWheel = hardwareMap.get(DcMotor.class, "motorRB");
    }

    @Override
    public void init() {
        telemetry.addData("Launch Test:", "Successful");
        telemetry.update();
    }

    @Override
    public void loop() {
        // DEFAULTS
        motorArm.setPower(0);
        motorLFWheel.setPower(0);
        motorLBWheel.setPower(0);
        motorRFWheel.setPower(0);
        motorRBWheel.setPower(0);
        // STICK VALUES
        float leftStickX = gamepad1.left_stick_x;
        float leftStickY = gamepad1.left_stick_y;
        float rightStickX = gamepad1.right_stick_x;
        float rightStickY = gamepad1.right_stick_y ;
        // MOVEMENT
        motorLFWheel.setPower(leftStickY);
        motorLBWheel.setPower(leftStickY);
        motorRFWheel.setPower(leftStickY);
        motorRBWheel.setPower(leftStickY);
        // ARM CONTROL
        if (gamepad1.right_bumper){motorArm.setPower(1);}
        if (gamepad1.left_bumper) {motorArm.setPower(-1);}
    }
}
