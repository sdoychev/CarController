package com.smd.studio.carcontroller;

import android.os.Handler;
import android.view.View;

/**
 * Created by Stefan.Doychev on 25.05.2015.
 */
public class MoveCarAction implements Runnable {
    View mView;
    Handler mHandler;
    String command = "";

    MoveCarAction(View view, Handler handler) {
        mView = view;
        mHandler = handler;
    }

    public void run() {
        moveCar(mView);
        mHandler.postDelayed(this, Constants.COMMAND_DELAY);
    }

    public void moveCar(View v) {
        RCTask rcTask = new RCTask();
        if (v.getId() == R.id.btnForward) {
            command = Constants.FORWARD;
        } else if (v.getId() == R.id.btnForwardLeft) {
            command = Constants.FORWARD_LEFT;
        } else if (v.getId() == R.id.btnForwardRight) {
            command = Constants.FORWARD_RIGHT;
        } else if (v.getId() == R.id.btnBackward) {
            command = Constants.BACKWARD;
        } else if (v.getId() == R.id.btnBackwardLeft) {
            command = Constants.BACKWARD_LEFT;
        } else if (v.getId() == R.id.btnBackwardRight) {
            command = Constants.BACKWARD_RIGHT;
        } else if (v.getId() == R.id.btnLeft) {
            command = Constants.LEFT;
        } else if (v.getId() == R.id.btnRight) {
            command = Constants.RIGHT;
        } else if (v.getId() == R.id.btnStop) {
            command = Constants.STOP;
        }
        rcTask.execute(command);
        return;
    }
}