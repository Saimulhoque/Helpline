package com.forbitbd.helpline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.forbitbd.helpline.adapter.ViewPagerAdapter;
import com.forbitbd.helpline.fragments.AllergistFragment;
import com.forbitbd.helpline.fragments.CardiologistFragment;
import com.forbitbd.helpline.fragments.NeurologistFragment;
import com.google.android.material.tabs.TabLayout;

public class DoctorActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        CardiologistFragment cardiologistFragment = new CardiologistFragment();
        AllergistFragment allergistFragment = new AllergistFragment();
        NeurologistFragment neurologistFragment = new NeurologistFragment();
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragment(cardiologistFragment, "Cardiologists");
        viewPagerAdapter.addFragment(allergistFragment, "Allergists");
        viewPagerAdapter.addFragment(neurologistFragment, "Neurologists");
        viewPager.setAdapter(viewPagerAdapter);
    }
}