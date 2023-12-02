package com.example.tacoclick;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.media.MediaPlayer;

public class MainActivity extends Activity implements OnClickListener {


    private int total_tacos;
    private int running_upgrades;
    private TextView rate_display;
    private TextView total_tacos_display;
    private TextView upgrade_display1;
    private TextView upgrade_display2;
    private TextView upgrade_display3;
    private TextView upgrade_display4;
    private TextView upgrade_display5;
    private MediaPlayer song;
    private MediaPlayer song2;
    private MediaPlayer song3;
    private MediaPlayer song4;
    private MediaPlayer song5;


    private static  int Upgrades_1_min =10;
    private static  int Upgrades_2_min =100;
    private static  int Upgrades_3_min=1000;
    private static  int Upgrades_4_min=10000;
    private static  int Upgrades_5_min=100000;
    private Handler rate_handler;
    public Runnable rate_runnable;

    public  ImageButton Taco_tapper;

    public  ImageButton Upgrade_1;
    public ImageButton Upgrade_2;
    public ImageButton Upgrade_3;
    public ImageButton Upgrade_4;
    public ImageButton Upgrade_5;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        Taco_tapper = (ImageButton) findViewById(R.id.TT);
        Upgrade_1 = (ImageButton) findViewById(R.id.U1);
        Upgrade_2 = (ImageButton) findViewById(R.id.U2);
        Upgrade_3 = (ImageButton) findViewById(R.id.U3);
        Upgrade_4 = (ImageButton) findViewById(R.id.U4);
        Upgrade_5 = (ImageButton) findViewById(R.id.U5);
        rate_display = (TextView) findViewById(R.id.RD);

        upgrade_display1 = (TextView) findViewById(R.id.UD1);
        upgrade_display2 = (TextView) findViewById(R.id.UD2);
        upgrade_display3 = (TextView) findViewById(R.id.UD3);
        upgrade_display4 = (TextView) findViewById(R.id.UD4);
        upgrade_display5 = (TextView) findViewById(R.id.UD5);

        total_tacos_display = (TextView) findViewById(R.id.TCD);
        Taco_tapper.setOnClickListener(this);
        Upgrade_1.setOnClickListener(this);
        Upgrade_2.setOnClickListener(this);
        Upgrade_3.setOnClickListener(this);
        Upgrade_4.setOnClickListener(this);
        Upgrade_5.setOnClickListener(this);
        song=MediaPlayer.create(this,R.raw.projectsound);
        song2=MediaPlayer.create(this,R.raw.background_song);
        song3=MediaPlayer.create(this,R.raw.background_3);
        song4=MediaPlayer.create(this,R.raw.song4);
        song5=MediaPlayer.create(this,R.raw.song5);
        song2.start();
        song2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (!song3.isPlaying()) {
                    song3.start();
                }
            }

        });
        song3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (!song4.isPlaying()){
                    song4.start();
                }
            }
        });
        song4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (!song5.isPlaying()){
                    song5.start();
                }
            }
        });
        song5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(!song2.isPlaying()){
                    song2.start();
                }
            }
        });
    }

    @Override

    public void onClick(View v) {
        int IDIf= v.getId();
        if (IDIf==R.id.TT)
        {


            total_tacos=total_tacos+1;
            total_tacos_display.setText(total_tacos + " Tacos");
            song.start();
            Animation animation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
            Taco_tapper.startAnimation(animation);
        }
        else if (IDIf==R.id.U1)
        {
            if(total_tacos>=Upgrades_1_min){
                    total_tacos=total_tacos-Upgrades_1_min;
                    running_upgrades=running_upgrades +5;
                    Upgrades_1_min=Upgrades_1_min+10;
                    total_tacos_display.setText(total_tacos + " Tacos");
                    rate_display.setText(running_upgrades/5 + " Tacos per second");
                    upgrade_display1.setText("Price "+ Upgrades_1_min+ " Tacos");

                    timing_handle();
            }
        }
        else if (IDIf==R.id.U2)
        {
            if(total_tacos>=Upgrades_2_min){
                    total_tacos=total_tacos-Upgrades_2_min;
                    running_upgrades=running_upgrades +50;
                    Upgrades_2_min=Upgrades_2_min+100;
                    total_tacos_display.setText(total_tacos + " Tacos");
                    rate_display.setText(running_upgrades/5 + " Tacos per second");
                    upgrade_display2.setText("Price "+Upgrades_2_min+ " Tacos");

                    timing_handle();
            }
        }
        else if (IDIf==R.id.U3)
        {
             if(total_tacos>=Upgrades_3_min){
                    total_tacos=total_tacos-Upgrades_3_min;
                    running_upgrades=running_upgrades +500;
                    Upgrades_3_min=Upgrades_3_min+1000;
                    total_tacos_display.setText(total_tacos + " Tacos");
                    rate_display.setText(running_upgrades/5 + " Tacos per second");
                    upgrade_display3.setText("Price "+Upgrades_3_min+ " Tacos");

                    timing_handle();
             }
        }
        else if (IDIf==R.id.U4)
        {
            if(total_tacos>=Upgrades_4_min){
                    total_tacos=total_tacos-Upgrades_4_min;
                    running_upgrades=running_upgrades +5000;
                    Upgrades_4_min=Upgrades_4_min+10000;
                    total_tacos_display.setText(total_tacos + " Tacos");
                    rate_display.setText(running_upgrades/5 + " Tacos per second");
                    upgrade_display4.setText("Price "+Upgrades_4_min+ " Tacos");

                    timing_handle();
            }
        }
        else if (IDIf==R.id.U5)
        {
             if(total_tacos>=Upgrades_5_min){
                    total_tacos=total_tacos-Upgrades_5_min;
                    running_upgrades=running_upgrades +50000;
                    Upgrades_5_min=Upgrades_5_min+100000;
                    total_tacos_display.setText(total_tacos + " Tacos");
                    rate_display.setText(running_upgrades/5 + " Tacos per second");
                    upgrade_display5.setText("Price "+Upgrades_5_min+ " Tacos");

                    timing_handle();
             }
        }
        else
        {
                timing_handle();
                rate_display.setText(running_upgrades/5 + " Tacos per second");

            }
        }



    private void timing_handle(){
       if (rate_handler!=null)
       {
           rate_handler.removeCallbacks(rate_runnable);
       }
        rate_handler=new Handler();
        rate_runnable= new Runnable(){
            public void run(){
            total_tacos=total_tacos +running_upgrades;
            total_tacos_display.setText(total_tacos + " total tacos");
            rate_handler.postDelayed(rate_runnable,5000);
        }};
        if (!rate_handler.hasCallbacks(rate_runnable)){
            rate_handler.postDelayed(rate_runnable,5000);
        }
    }


}
