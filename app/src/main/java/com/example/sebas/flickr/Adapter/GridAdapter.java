package com.example.sebas.flickr.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sebas.flickr.Activities.MainActivity;
import com.example.sebas.flickr.Activities.MyApplication;
import com.example.sebas.flickr.Interfaces.OnItemClickListener;
import com.example.sebas.flickr.Models.Photo;
import com.example.sebas.flickr.R;
import com.example.sebas.flickr.Utils.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;



public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GrillaViewHolder> {

    private List<Photo> photos;
    private Context context;
    private OnItemClickListener listener;

    public GridAdapter(Context context) {
        this.context = context;
        this.photos = new ArrayList<>();
    }

    public GridAdapter(List<Photo> photos, Context context, OnItemClickListener onItemClickListener) {
        this.photos = photos;
        this.context = context;
        this.listener = onItemClickListener;
    }



    @Override
    public GridAdapter.GrillaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GrillaViewHolder grillaViewHolder = new GrillaViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grilla,parent,false));
        return grillaViewHolder;
    }

    @Override
    public void onBindViewHolder(GrillaViewHolder holder, int position) {
        final Photo photo = photos.get(position);
        String imageUrl = photo.getUrlS();
        ImageLoader.getInstance().displayImage(imageUrl,holder.photo, MyApplication.options);
        if (photo.getIconfarm()!=null) {
            String urlPicProfile = "http://farm" + photo.getIconfarm() + ".staticflickr.com/" + photo.getIconserver() + "/buddyicons/" + photo.getOwner() + ".jpg";
            ImageLoader.getInstance().displayImage(urlPicProfile, holder.picprofile, MyApplication.optionsRounded);
        }
        holder.username.setText(photo.getOwnername());
        holder.title.setText(photo.getTitle());
        holder.date.setText(Utils.changeDateformat(photo.getDatetaken()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(photo);
            }
        });
        if (!MainActivity.isGrid){
            holder.linearLayout.setVisibility(View.VISIBLE);

        }else {
            holder.linearLayout.setVisibility(View.GONE);
        }
        changeHolderHeigth(holder.itemView,MainActivity.isGrid);

    }

    private void changeHolderHeigth(View view,boolean isGrid) {
        if (!isGrid) {
            view.getLayoutParams().height = context.getResources().getDisplayMetrics().heightPixels / 3;
        }
        else {
            view.getLayoutParams().height = context.getResources().getDisplayMetrics().heightPixels / 5;
        }
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }


    class GrillaViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.photo)
        ImageView photo;
        @BindView(R.id.picprofile)
        ImageView picprofile;
        @BindView(R.id.username)
        TextView username;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.linearsubpadre)
        LinearLayout linearLayout;

        public GrillaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void clear() {
        photos.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Photo> list) {
        photos.addAll(list);
        notifyDataSetChanged();
    }
}
