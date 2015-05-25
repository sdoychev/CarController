package com.smd.studio.carcontroller;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button forwardLeft, forward, forwardRight, left, stop, right, backward, backwardLeft, backwardRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PressHoldButtonListener pressHoldButtonListener = new PressHoldButtonListener();

        forwardLeft = (Button) findViewById(R.id.btnForwardLeft);
        forwardLeft.setOnTouchListener(pressHoldButtonListener);
        forward = (Button) findViewById(R.id.btnForward);
        forward.setOnTouchListener(pressHoldButtonListener);
        forwardRight = (Button) findViewById(R.id.btnForwardRight);
        forwardRight.setOnTouchListener(pressHoldButtonListener);

        left = (Button) findViewById(R.id.btnLeft);
        left.setOnTouchListener(pressHoldButtonListener);
        stop = (Button) findViewById(R.id.btnStop);
        stop.setOnTouchListener(pressHoldButtonListener);
        right = (Button) findViewById(R.id.btnRight);
        right.setOnTouchListener(pressHoldButtonListener);

        backwardLeft = (Button) findViewById(R.id.btnBackwardLeft);
        backwardLeft.setOnTouchListener(pressHoldButtonListener);
        backward = (Button) findViewById(R.id.btnBackward);
        backward.setOnTouchListener(pressHoldButtonListener);
        backwardRight = (Button) findViewById(R.id.btnBackwardRight);
        backwardRight.setOnTouchListener(pressHoldButtonListener);
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class PressHoldButtonListener implements View.OnTouchListener {
        private Handler mHandler;
        private MoveCarAction mAction;

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (mHandler != null) {
                        return true;
                    }
                    mHandler = new Handler();
                    mAction = new MoveCarAction(v, mHandler);
                    mHandler.post(mAction);
                    break;
                case MotionEvent.ACTION_UP:
                    if (mHandler == null) {
                        return true;
                    }
                    mHandler.removeCallbacks(mAction);
                    mHandler = null;
                    break;
            }
            return true;
        }
    }
}