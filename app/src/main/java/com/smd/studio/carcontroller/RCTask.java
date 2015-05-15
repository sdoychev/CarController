package com.smd.studio.carcontroller;

import android.os.AsyncTask;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

/**
 * Created by Doychev on 13.5.2015 г..
 */
public class RCTask extends AsyncTask {
    @Override
    protected Void doInBackground(Object... params) {

        JSch jsch = new JSch();
        Session session = null;
        String result = "";
        try {
            session = jsch.getSession(Constants.USERNAME, Constants.HOST, 22);
            session.setPassword(Constants.PASSWORD);
            // Avoid asking for key confirmation
            Properties prop = new Properties();
            prop.put("StrictHostKeyChecking", "no");
            session.setConfig(prop);
            session.connect();

            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(Constants.FORWARD);
            channelExec.connect();
            //channelExec.disconnect();     at OnStop()

        } catch (JSchException e) {
            e.printStackTrace();
        }
        return null;
    }
}