package com.example.exa_3er_salvador_as;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    public VideoView vvVideoAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        vvVideoAS = (VideoView) findViewById(R.id.vvVideoAS);
        Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        vvVideoAS.setVideoURI(path);
        vvVideoAS.setMediaController(new MediaController(this));
        vvVideoAS.start();
    }
}