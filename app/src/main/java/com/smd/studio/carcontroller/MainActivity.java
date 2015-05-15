package com.smd.studio.carcontroller;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void moveCar(View v) {
        RCTask rcTask = new RCTask();
        if (v.getId() == R.id.btnForward) {
            rcTask.execute(Constants.FORWARD);
        } else if (v.getId() == R.id.btnForwardLeft) {
            rcTask.execute(Constants.FORWARD_LEFT);
        } else if (v.getId() == R.id.btnForwardRight) {
            rcTask.execute(Constants.FORWARD_RIGHT);
        } else if (v.getId() == R.id.btnBackward) {
            rcTask.execute(Constants.BACKWARD);
        } else if (v.getId() == R.id.btnBackwardLeft) {
            rcTask.execute(Constants.BACKWARD_LEFT);
        } else if (v.getId() == R.id.btnBackwardRight) {
            rcTask.execute(Constants.BACKWARD_RIGHT);
        } else if (v.getId() == R.id.btnLeft) {
            rcTask.execute(Constants.LEFT);
        } else if (v.getId() == R.id.btnRight) {
            rcTask.execute(Constants.RIGHT);
        } else if (v.getId() == R.id.btnStop) {
            rcTask.execute(Constants.STOP);
        }
        return;
    }
}