package com.example.saavanclone.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavanclone.R;
import com.example.saavanclone.fragment.HomeFragment;
import com.example.saavanclone.models.BaseObjectModel;
import com.example.saavanclone.models.SectionModel;

import java.util.ArrayList;

public class BaseAdapterRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private ArrayList<SectionModel> sectionData;
private Context context;

    public BaseAdapterRecyclerView( Context context,ArrayList<SectionModel>sectionData) {
        this.sectionData = sectionData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SectionViewHolder(LayoutInflater.from(context).inflate(R.layout.section_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
String sectionName = sectionData.get(position).getSectionName();
ArrayList<BaseObjectModel>objectModels= sectionData.get(position).getAllObject();
SectionViewHolder viewHolder = (SectionViewHolder)holder;
viewHolder.sectionTitle.setText(sectionName);
viewHolder.recyclerView.setHasFixedSize(true);
viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context,
        LinearLayoutManager.HORIZONTAL,false));
HomeRecyclerViewAdapter  adapter = new HomeRecyclerViewAdapter(context,objectModels, position%3);
viewHolder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return sectionData.size();
    }
    class SectionViewHolder extends RecyclerView.ViewHolder{
        TextView sectionTitle;
        RecyclerView recyclerView;
        public SectionViewHolder(View itemView) {
            super(itemView);
            sectionTitle= itemView.findViewById(R.id.album_title_tv);
            recyclerView= itemView.findViewById(R.id.section_rv);
        }
    }

}
