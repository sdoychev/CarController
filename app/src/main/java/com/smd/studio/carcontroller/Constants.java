package com.smd.studio.carcontroller;

/**
 * Created by Doychev on 15.5.2015 ã..
 */
public interface Constants {
    String HOST = "192.168.1.103";
    String USERNAME = "pi";
    String PASSWORD = "raspberry";

    String FORWARD = "sudo python /home/pi/Projects/Car.py w";
    String FORWARD_LEFT = "sudo python /home/pi/Projects/Car.py q";
    String FORWARD_RIGHT = "sudo python /home/pi/Projects/Car.py e";
    String BACKWARD = "sudo python /home/pi/Projects/Car.py s";
    String BACKWARD_LEFT = "sudo python /home/pi/Projects/Car.py a";
    String BACKWARD_RIGHT = "sudo python /home/pi/Projects/Car.py d";
    String LEFT = "sudo python /home/pi/Projects/Car.py z";
    String RIGHT = "sudo python /home/pi/Projects/Car.py c";
    String STOP = "sudo python /home/pi/Projects/Car.py x";
}