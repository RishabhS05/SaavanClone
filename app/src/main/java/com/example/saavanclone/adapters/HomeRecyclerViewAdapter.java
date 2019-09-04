package com.example.saavanclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saavanclone.R;
import com.example.saavanclone.models.BaseObjectModel;

import java.util.ArrayList;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BaseObjectModel> objectModels;
    private Context context;
    int p;
    private IListener listener;

   public interface  IListener {
        void onClick(View view);
    }
    public HomeRecyclerViewAdapter(Context context, ArrayList<BaseObjectModel> objectModels, int p) {
        this.context = context;
        this.listener = (IListener)context;
        this.objectModels = objectModels;
        this.p = p;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        switch (p) {
            case 0:
                return new ImageHolder(LayoutInflater.from(context).inflate(R.layout.cardview_image_layout, null));
            case 1:
                return new ButtonHolder(LayoutInflater.from(context).inflate(R.layout.cardview_button_layout, null));
            case 2:
                return new TextHolder(LayoutInflater.from(context).inflate(R.layout.cardview_text_image_layout, null));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (p) {
            case 0:
                ImageHolder viewHolder1 = (ImageHolder) holder;
                break;
            case 1:
                ButtonHolder buttonHolder = (ButtonHolder) holder;
                buttonHolder.title.setText(objectModels.get(position).getSongName());
                break;
            case 2:
                TextHolder textHolder = (TextHolder) holder;
                textHolder.title.setText(objectModels.get(position).getSongName());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return objectModels.size();
    }


    class ImageHolder extends RecyclerView.ViewHolder {
        ImageView item;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.img_view);
            callListner(itemView);
        }

    }

    class ButtonHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView songIV;
        ImageButton add;

        public ButtonHolder(@NonNull View itemView) {
            super(itemView);
            songIV = itemView.findViewById(R.id.album_song_img);
            title = itemView.findViewById(R.id.album_song_title);
            add = itemView.findViewById(R.id.add);
            callListner(itemView);
        }

    }

    class TextHolder extends RecyclerView.ViewHolder {
        ImageView albumImg;
        TextView title;

        public TextHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.album_tv);
            albumImg = itemView.findViewById(R.id.album_img);
            callListner(itemView);
        }

    }
    public void callListner(View itemView){

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view);
            }
        });
    }
}
