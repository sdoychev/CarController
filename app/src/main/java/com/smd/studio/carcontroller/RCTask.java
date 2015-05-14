package com.smd.studio.carcontroller;

import android.os.AsyncTask;
import android.util.Log;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Doychev on 13.5.2015 г..
 */
public class RCTask extends AsyncTask {
    @Override
    protected Void doInBackground(Object... params) {

        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession("pi", "192.168.1.103", 22);
            session.setPassword("raspberry");
            // Avoid asking for key confirmation
            Properties prop = new Properties();
            prop.put("StrictHostKeyChecking", "no");
            session.setConfig(prop);
            session.connect();

            // SSH Channel
            ChannelExec channelssh = (ChannelExec) session.openChannel("exec");
            // Execute command
            channelssh.setCommand("ls");
            //channelssh.setCommand("sudo python /home/pi/Projects/Car.py");
            channelssh.connect();

            InputStream input = channelssh.getInputStream();
            String result = "";
            int data = input.read();
            while (data != -1) {
                result += (char) data;
                data = input.read();
            }
            Log.e("RASPBERRY RESPONSE", result);
            channelssh.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
