package com.example.amir.app_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Myservice extends Service {
    private Toast toast;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Timer timer= new Timer();
        toast = new Toast(this);
        toast = Toast.makeText(getApplicationContext(),"servic run",Toast.LENGTH_SHORT);

        timer.schedule(new TimerTask()
        {

            @Override
            public void run() {

                toast.show();

            }

        }, 10000);


        MediaPlayer player = MediaPlayer.create(Myservice.this, R.raw.negar);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}