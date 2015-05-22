package com.smd.studio.carcontroller;

import android.os.AsyncTask;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Doychev on 13.5.2015 г..
 */
public class RCTask extends AsyncTask<String, Void, Void> {

    private String hostAddress = "192.168.1.103";

    @Override
    protected Void doInBackground(String... params) {
        try {
            getListOfConnectedDevice();
            JSch jsch = new JSch();
            Session session = jsch.getSession(Constants.USERNAME, hostAddress, 22);
            session.setPassword(Constants.PASSWORD);
            // Avoid asking for key confirmation
            Properties prop = new Properties();
            prop.put("StrictHostKeyChecking", "no");
            session.setConfig(prop);
            session.connect();

            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(params[0]);
            channelExec.connect();
            //channelExec.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getListOfConnectedDevice() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/proc/net/arp"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(" +");
                if (splitted != null && splitted.length >= 4) {
                    hostAddress = splitted[0];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}