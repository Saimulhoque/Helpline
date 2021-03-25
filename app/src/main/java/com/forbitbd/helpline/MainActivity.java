package com.forbitbd.helpline;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.forbitbd.helpline.adapter.SliderAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements  View.OnClickListener  {

    CardView cardView1, cardView2, cardView3,cardView4, cardView5, cardView6, cardView7,ccardView8,cardView9;
    ViewPager viewPager;
    int images[] = {R.drawable.ggg,R.drawable.one,R.drawable.three,R.drawable.two,R.drawable.four};
    int currentPageCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView1 = findViewById(R.id.police);
        cardView2 = findViewById(R.id.fireservice);
        cardView3 = findViewById(R.id.doctor);
        cardView6 = findViewById(R.id.ambulance);
        cardView7 = findViewById(R.id.news);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView6.setOnClickListener(this);
        cardView7.setOnClickListener(this);

        viewPager = findViewById(R.id.slideview);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(new SliderAdapter(images, MainActivity.this));
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPageCounter == images.length) {
                    currentPageCounter = 0;
                }
                viewPager.setCurrentItem(currentPageCounter++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 4000, 4000);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.police) {
            Intent intent = new Intent(MainActivity.this, PoliceActivity.class);
            startActivity(intent);
        }else if (id == R.id.doctor){
            Intent intent = new Intent(MainActivity.this, DoctorActivity.class);
            startActivity(intent);
        }else if (id == R.id.fireservice){
            Intent intent = new Intent(MainActivity.this, FireService.class);
            startActivity(intent);
        }else if (id == R.id.news){
            Intent intent = new Intent(MainActivity.this, NewsActivity.class);
            startActivity(intent);
        }else if (id == R.id.ambulance){
            Intent intent = new Intent(MainActivity.this, AmbulanceActivity.class);
            startActivity(intent);
        }
    }
}