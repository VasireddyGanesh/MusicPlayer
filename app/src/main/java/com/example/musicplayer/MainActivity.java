package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    MediaPlayer mp;
    Button start_btn;
    TextView msgTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_btn=findViewById(R.id.start_btn);
        msgTxt=findViewById(R.id.msg_tv);
    }

    public void stop(View view) {
        if (mp!=null){
            if("Resume".equals(start_btn.getText())){
                start_btn.setText("Start");
            }
            mp.release();
            mp=null;
            Toast.makeText(this,"Music Stopped",Toast.LENGTH_LONG).show();
            msgTxt.setText("Music Stopped");
        }
    }

    public void play(View view) {
        if(mp==null){
            mp=MediaPlayer.create(this,R.raw.song);
        }
        if("Resume".equals(start_btn.getText())){
            start_btn.setText("Start");
        }
        mp.start();
        Toast.makeText(this,"Music Playing",Toast.LENGTH_LONG).show();
        msgTxt.setText("Music Playing");
    }

    public void pause(View view) {
        if (mp!= null){
            mp.pause();
            start_btn.setText("Resume");
            Toast.makeText(this,"Music Paused",Toast.LENGTH_LONG).show();
            msgTxt.setText("Music Paused");
        }
    }
}