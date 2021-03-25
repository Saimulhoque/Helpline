package com.forbitbd.helpline.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.helpline.ItemClickListener;
import com.forbitbd.helpline.NewsActivity;
import com.forbitbd.helpline.R;
import com.forbitbd.helpline.model.Police;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private Context context;
    private List<Police> policeList;
    private ItemClickListener itemClickListener;

    public RecyclerviewAdapter(Context context, List<Police> policeList, ItemClickListener itemClickListener) {
        this.context = context;
        this.policeList = policeList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recyclerviewlayout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Police police = policeList.get(position);
        holder.text1.setText(police.getName());
        holder.text2.setText(police.getDesignation());
        holder.text3.setText(police.getPhone());
    }

    @Override
    public int getItemCount() {
        return policeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1, text2,text3;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            text1 = itemView.findViewById(R.id.name);
            text2 = itemView.findViewById(R.id.designation);
            text3 = itemView.findViewById(R.id.phone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.OnItemClick(policeList.get(getAdapterPosition()));
                }
            });
        }
    }
}
