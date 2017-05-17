package com.example.zeltr.codehero.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.zeltr.codehero.R;

public class BackgroundSoundService extends Service{

    MediaPlayer player;

    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.soundtrack);
        player.setLooping(true);
        player.setVolume(100 , 100);

    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return START_STICKY_COMPATIBILITY;
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }
}
