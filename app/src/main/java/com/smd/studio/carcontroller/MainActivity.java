package com.smd.studio.carcontroller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    String command = "";
    Button forwardLeft, forward, forwardRight, left, stop, right, backward, backwardLeft, backwardRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        forwardLeft = (Button) findViewById(R.id.btnForwardLeft);
        forward = (Button) findViewById(R.id.btnForward);
        forwardRight = (Button) findViewById(R.id.btnForwardRight);
        left = (Button) findViewById(R.id.btnLeft);
        stop = (Button) findViewById(R.id.btnStop);
        right = (Button) findViewById(R.id.btnRight);
        backwardLeft = (Button) findViewById(R.id.btnBackwardLeft);
        backward = (Button) findViewById(R.id.btnBackward);
        backwardRight = (Button) findViewById(R.id.btnBackwardRight);
    }

    @Override
    protected void onResume() {
        super.onResume();

        PressHoldButtonListener pressHoldButtonListener = new PressHoldButtonListener();
        forwardLeft.setOnTouchListener(pressHoldButtonListener);
        forward.setOnTouchListener(pressHoldButtonListener);
        forwardRight.setOnTouchListener(pressHoldButtonListener);
        left.setOnTouchListener(pressHoldButtonListener);
        stop.setOnTouchListener(pressHoldButtonListener);
        right.setOnTouchListener(pressHoldButtonListener);
        backwardLeft.setOnTouchListener(pressHoldButtonListener);
        backward.setOnTouchListener(pressHoldButtonListener);
        backwardRight.setOnTouchListener(pressHoldButtonListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        stopMovingCar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
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
    }

    private void stopMovingCar() {
        RCTask rcTask = new RCTask();
        rcTask.execute(Constants.STOP);
    }

    public class PressHoldButtonListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    moveCar(v);
                    break;
                case MotionEvent.ACTION_UP:
                    stopMovingCar();
                    break;
            }
            return true;
        }
    }
}