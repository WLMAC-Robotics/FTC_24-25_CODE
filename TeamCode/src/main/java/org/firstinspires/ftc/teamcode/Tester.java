package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "CyberLyons")
public class Tester extends OpMode {
    // MATERIALS
    DcMotor motorArm;
    DcMotor motorLFWheel;
    DcMotor motorLBWheel;
    DcMotor motorRFWheel;
    DcMotor motorRBWheel;
    Servo clawServoRight;
    Servo clawServoLeft;
    public
    // JOYSTICK VARS
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
        clawServoRight = hardwareMap.get(Servo.class, "clawRight");
        clawServoLeft = hardwareMap.get(Servo.class, "clawLeft");
    }

    @Override
    public void init() {
        initializeStuff();
        telemetry.addData("Launch Test:", "Successful");
        telemetry.update();
    }

    @Override
    public void loop() {
        // DEFAULTS
        motorArm.setPower(0);
        // STICK VALUES
        float leftStickX = gamepad1.left_stick_x;
        float leftStickY = gamepad1.left_stick_y;
        float rightStickX = gamepad1.right_stick_x;
        float rightStickY = gamepad1.right_stick_y ;
        // MOVEMENT
        if (leftStickX>0){
            motorLFWheel.setPower(leftStickY);
            motorLBWheel.setPower(leftStickY);
            motorRFWheel.setPower(leftStickY+(leftStickX));
            motorRBWheel.setPower(leftStickY+(leftStickX));
        } else {
            motorLFWheel.setPower(leftStickY-(leftStickX));
            motorLBWheel.setPower(leftStickY-(leftStickX));
            motorRFWheel.setPower(leftStickY);
            motorRBWheel.setPower(leftStickY);
        }
        // ARM CONTROL
        if (gamepad1.right_bumper){motorArm.setPower(1);}
        if (gamepad1.left_bumper){motorArm.setPower(-1);}
        // CLAW
        if (gamepad1.a){clawServoRight.setPosition(0);clawServoLeft.setPosition(0);}
        if (gamepad1.b){clawServoRight.setPosition(0.3);clawServoLeft.setPosition(-0.3);}
    }
}
