package com.example.eric.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class StopwatchActivity extends AppCompatActivity {
    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
    }

    public void onClickStart( View view ) {
        running = true;
    }

    public void onClickStop( View view ) {
        running = false;
    }

    public void onClickReset( View view ) {
        running = false;
        seconds = 0;
    }

    private void runTimer() {
        final TextView tv = (TextView) findViewById( R.id.time_view );
        final Handler handler = new Handler() {
            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord logRecord) {

            }
        };

        handler.post( new Runnable() ) {

        }
        int hours = seconds / 3600;
        int minutes = ( seconds % 3600 ) / 60;
        int secs = seconds % 60;

        String time = String.format( "%d:%02d:%02d", hours, minutes, secs );
        tv.setText( time );

        if ( running ) {
            seconds++;
        }
    }
}
