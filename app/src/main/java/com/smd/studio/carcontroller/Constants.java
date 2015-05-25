package com.smd.studio.carcontroller;

/**
 * Created by Doychev on 15.5.2015.
 */
public interface Constants {
    String TAG = "CAR CONTROLLER";
    String USERNAME = "pi";
    String PASSWORD = "raspberry";
    int COMMAND_DELAY = 400;
    String FORWARD = "sudo python /home/pi/Projects/Car.py w";
    String FORWARD_LEFT = "sudo python /home/pi/Projects/Car.py q";
    String FORWARD_RIGHT = "sudo python /home/pi/Projects/Car.py e";
    String LEFT = "sudo python /home/pi/Projects/Car.py a";
    String RIGHT = "sudo python /home/pi/Projects/Car.py d";
    String STOP = "sudo python /home/pi/Projects/Car.py s";
    String BACKWARD = "sudo python /home/pi/Projects/Car.py x";
    String BACKWARD_LEFT = "sudo python /home/pi/Projects/Car.py z";
    String BACKWARD_RIGHT = "sudo python /home/pi/Projects/Car.py c";
}