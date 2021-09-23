package com.example.game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.VolumeAutomation;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import in.excogitation.zentone.library.ToneStoppedListener;
import in.excogitation.zentone.library.ZenTone;

public class MainActivity extends AppCompatActivity {

    double fre = 20;
    double min;
    int n,i=-1,j=-1,k,rand,left=-1,right=-1;
    String str;

    Vector<Integer> v;
    Vector<Integer> x;
    int arr[];
    Random random;
    ArrayList<String> list;
    ImageButton button2;
    ImageButton button1;
    ImageView n1;
    ImageView n2;
    ImageView n3;
    ImageView n4;
    ImageView n5;
    ImageView n6;
    ImageView n7;
    ImageView n8;

    @Override
    public void onBackPressed() {
         finishAffinity();
         System.exit(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Ltone ankur = new Ltone();

        v = new Vector<Integer>();
        x = new Vector<Integer>();
        random = new Random();
        list = new ArrayList<String>();

        while(fre <= 10000 ){
           min = fre * Math.sqrt(2);
           v.add((int) min);
           x.add((int) (2*fre-fre));
           fre=min;
        }
        Vector<Integer> y = new Vector<>();
        n=v.size();
        arr = new int[n];

        for(int l=n-1;l>=0;l--) {
              y.add(v.get(l));
        }

        button1 = findViewById(R.id.ibutton1);
        button2 = findViewById(R.id.ibutton2);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);

        TranslateAnimation mAnimation = new TranslateAnimation(TranslateAnimation.INFINITE, 0f, TranslateAnimation.INFINITE, 0f, TranslateAnimation.RELATIVE_TO_PARENT, -1f, TranslateAnimation.RELATIVE_TO_PARENT, 1f);
        mAnimation.setDuration(10000);
        mAnimation.setRepeatCount(-1);
        mAnimation.setRepeatMode(Animation.INFINITE);
        mAnimation.setInterpolator(new LinearInterpolator());
        n1.setAnimation(mAnimation);
        n4.setAnimation(mAnimation);
        n3.setAnimation(mAnimation);
        n5.setAnimation(mAnimation);
        TranslateAnimation nAnimation = new TranslateAnimation(TranslateAnimation.INFINITE, 0f, TranslateAnimation.INFINITE, 0f, TranslateAnimation.RELATIVE_TO_PARENT, -1f, TranslateAnimation.RELATIVE_TO_PARENT, 1f);
        nAnimation.setDuration(8000);
        nAnimation.setRepeatCount(-1);
        nAnimation.setRepeatMode(Animation.INFINITE);
        nAnimation.setInterpolator(new LinearInterpolator());
        n7.setAnimation(nAnimation);
        n8.setAnimation(nAnimation);
        n6.setAnimation(nAnimation);
        n2.setAnimation(nAnimation);

        new CountDownTimer(n*2*5000 ,5000){
            @Override
            public void onTick(long l) {
                rand = random.nextInt(2);

                if((rand==0 || right==n-1)&&(left!=n-1)){
                    left++;
                    Runnable r = new Runnable() {
                        public void run() {
                            ankur.tone(v.get(left),2,1.0f,0.0f);
                        }
                    };
                    new Thread(r).start();
                    j++;
                    list.add(j, String.valueOf(x.get(j)) + "Hz                           0                          ");
                    k=0;
                }else{
                    right++;
                    Runnable r = new Runnable() {
                        public void run() {
                            ankur.tone(y.get(right),2,0.0f,1.0f);
                        }
                    };
                    new Thread(r).start();
                    i++;
                    arr[i]=0;
                    k=1;
                }
                button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(k == 0){
                        list.set(j, String.valueOf(x.get(j))+ "Hz                          +1                          ");
                    }else{
                        arr[i]=-1;
                    }
                }
            });
                button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(k == 0){
                        list.set(j, String.valueOf(x.get(j))+ "Hz                          -1                          ");
                    }else{
                        arr[i]=1;
                    }
                }
            });

            }
            @Override
            public void onFinish() {
                for(int k=0;k<n;k++){
                    str = list.get(k);
                    list.set(k, str + arr[n-1-k]);
                }
                //Log.i("Vinay", String.valueOf(list));
                Intent intent = new Intent(getApplicationContext(),listView.class);
                intent.putStringArrayListExtra("ank", list);
                startActivity(intent);
            }
        }.start();
    }

}