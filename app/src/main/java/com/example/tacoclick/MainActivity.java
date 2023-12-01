package com.example.tacoclick;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {


    private int total_tacos;
    private int running_upgrades;
    private TextView rate_display;
    private TextView total_tacos_display;
    private static final int Upgrades_1_min=10;
    private static final int Upgrades_2_min=50;
    private static final int Upgrades_3_min=100;
    private static final int Upgrades_4_min=200;
    private static final int Upgrades_5_min=300;
    private Handler timing_handler;
    public Runnable timing_runnable;

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
        total_tacos_display = (TextView) findViewById(R.id.TCD);
        Taco_tapper.setOnClickListener(this);
        Upgrade_1.setOnClickListener(this);
        Upgrade_2.setOnClickListener(this);
        Upgrade_3.setOnClickListener(this);
        Upgrade_4.setOnClickListener(this);
        Upgrade_5.setOnClickListener(this);

    }

    @Override

    public void onClick(View v) {
        int IDIf= v.getId();
        if (IDIf==R.id.TT)
        {
            total_tacos=total_tacos+1;
            total_tacos_display.setText(total_tacos + " total tacos");
        }
        else if (IDIf==R.id.U1)
        {
            if(total_tacos>=Upgrades_1_min){
                    total_tacos=total_tacos-Upgrades_1_min;
                    running_upgrades=running_upgrades +1;
                    total_tacos_display.setText(total_tacos + " total tacos");
                    rate_display.setText(running_upgrades/5 + " tacos made per second");
                    timing_handle();
            }
        }
        else if (IDIf==R.id.U2)
        {
            if(total_tacos>=Upgrades_2_min){
                    total_tacos=total_tacos-Upgrades_2_min;
                    running_upgrades=running_upgrades +2;
                    total_tacos_display.setText(total_tacos + " total tacos");
                    rate_display.setText(running_upgrades/5 + " tacos made per second");
                    timing_handle();
            }
        }
        else if (IDIf==R.id.U3)
        {
             if(total_tacos>=Upgrades_3_min){
                    total_tacos=total_tacos-Upgrades_3_min;
                    running_upgrades=running_upgrades +3;
                    total_tacos_display.setText(total_tacos + " total tacos");
                    rate_display.setText(running_upgrades/5 + " tacos made per second");
                    timing_handle();
             }
        }
        else if (IDIf==R.id.U4)
        {
            if(total_tacos>=Upgrades_4_min){
                    total_tacos=total_tacos-Upgrades_4_min;
                    running_upgrades=running_upgrades +4;
                    total_tacos_display.setText(total_tacos + " total tacos");
                    rate_display.setText(running_upgrades/5 + " tacos made per second");
                    timing_handle();
            }
        }
        else if (IDIf==R.id.U5)
        {
             if(total_tacos>=Upgrades_5_min){
                    total_tacos=total_tacos-Upgrades_5_min;
                    running_upgrades=running_upgrades +5;
                    total_tacos_display.setText(total_tacos + " total tacos");
                    rate_display.setText(running_upgrades/5 + " tacos made per second");
                    timing_handle();
             }
        }
        else
        {
                timing_handle();
                rate_display.setText(running_upgrades/5 + " tacos made per second");

            }
        }



    private void timing_handle(){
        timing_handler=new Handler();
        timing_runnable= new Runnable(){
            public void run(){
            total_tacos=total_tacos +running_upgrades;
            total_tacos_display.setText(total_tacos + " total tacos");
            timing_handler.postDelayed(timing_runnable,5000);
        }};
        if (!timing_handler.hasCallbacks(timing_runnable)){
            timing_handler.postDelayed(timing_runnable,5000);
        }
    }


}