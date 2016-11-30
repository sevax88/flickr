package com.example.sebas.flickr.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebas.flickr.Models.Photo;
import com.example.sebas.flickr.R;
import com.example.sebas.flickr.Utils.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imagePhoto)
    ImageView imagePhoto;
    @BindView(R.id.profilePic)
    ImageView profilePic;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.place)
    TextView place;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.photoDescription)
    TextView photoDescription;
    @BindView(R.id.botomPlace)
    TextView botomPlace;
    private Photo photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        photo = bundle.getParcelable(MainActivity.PHOTO);
        loadUi();
    }

    private void loadUi() {
        ImageLoader.getInstance().displayImage(photo.getUrlM(),imagePhoto,MyApplication.options);
        String urlPicProfile = null;
        urlPicProfile = "http://farm" + photo.getIconfarm() + ".staticflickr.com/" + photo.getIconserver() + "/buddyicons/" + photo.getOwner()+ ".jpg";
        ImageLoader.getInstance().displayImage(urlPicProfile,profilePic,MyApplication.optionsRounded);
        username.setText(photo.getOwnername());
        place.setText(photo.getTitle());
        date.setText(Utils.changeDateformat(photo.getDatetaken()));
        if (!photo.getDescription().getContent().equals("")) {
            photoDescription.setText(photo.getDescription().getContent());
        }
        else if(!photo.getMachineTags().equals("")) {
            photoDescription.setText(photo.getMachineTags());
        }else {
           photoDescription.setHint("Empty description");
//           photoDescription.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
        }
        if (photo.getLatitude()!=null && photo.getLongitude()!=null) {
//            botomPlace.setText(getCity());
        }else {
            botomPlace.setHint("The user doesn´t provide any location");
        }
    }

}
