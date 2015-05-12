package com.smd.studio.carcontroller;

import android.os.AsyncTask;
import android.util.Log;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

/**
 * Created by Doychev on 13.5.2015 г..
 */
public class MoveTask extends AsyncTask {
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

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            channelssh.setOutputStream(baos);

            // Execute command
            channelssh.setCommand("w");
            channelssh.connect();

            Log.e("CAR", baos.toString());
            channelssh.disconnect();

        } catch (JSchException e) {
            e.printStackTrace();
        }
        return null;
    }
}
