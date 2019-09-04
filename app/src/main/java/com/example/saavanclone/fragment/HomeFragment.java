package com.example.saavanclone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavanclone.R;
import com.example.saavanclone.adapters.BaseAdapterRecyclerView;
import com.example.saavanclone.models.BaseObjectModel;
import com.example.saavanclone.models.SectionModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment  {
    RecyclerView recyclerView;
    BaseAdapterRecyclerView adapter;
    ArrayList<SectionModel>sections;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,null);
        recyclerView = view.findViewById(R.id.home_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        sections= createDummySet();
        adapter = new BaseAdapterRecyclerView(getActivity(),sections);
        recyclerView.setAdapter(adapter);
        return view ;
    }
    public ArrayList<SectionModel> createDummySet(){
        ArrayList<SectionModel> sectionObjects =new ArrayList<>();
        for (int i = 0 ;i<10;i++){
            ArrayList<BaseObjectModel> objects= new ArrayList<>();
            for (int j = 0 ;j<10;j++){
                BaseObjectModel baseObjectModel =new BaseObjectModel("song " +j);
                objects.add(baseObjectModel);
            }
            System.out.println("objs" + objects.size());
            SectionModel sectionModel= new SectionModel("Genre "+i ,objects);
            sectionObjects.add(sectionModel);
        }
        System.out.println("section" + sectionObjects.size());
        return sectionObjects;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
