package com.forbitbd.helpline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.forbitbd.helpline.adapter.RecyclerviewAdapter;
import com.forbitbd.helpline.model.Police;

import java.util.ArrayList;

public class AmbulanceActivity extends AppCompatActivity {

    ArrayList<Police> policeList;
    RecyclerView recyclerView;
    RecyclerviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        recyclerView = findViewById(R.id.recyclerview);
        policeList = new ArrayList<>();
        policeList.add(new Police("Md Saimul Hoque","OC,Sandwip Thana","01881269553"));
        policeList.add(new Police("Md Saimul Hoque","OC,Sandwip Thana","01982204475"));
        policeList.add(new Police("Md Saimul Hoque","OC,Sandwip Thana","01821465858"));
        policeList.add(new Police("Md Saimul Hoque","OC,Sandwip Thana","01753606437"));
        policeList.add(new Police("Md Saimul Hoque","OC,Sandwip Thana","01730676936"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        adapter = new RecyclerviewAdapter(getApplicationContext(), policeList, new ItemClickListener() {
            @Override
            public void OnItemClick(Police police) {
                dialcall(police.getPhone());
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void dialcall(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:"+phone));
        startActivity(intent);
    }
}