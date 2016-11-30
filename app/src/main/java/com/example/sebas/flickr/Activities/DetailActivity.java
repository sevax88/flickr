package com.example.sebas.flickr.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sebas.flickr.Models.Photo;
import com.example.sebas.flickr.R;
import com.example.sebas.flickr.Utils.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.moredetailLayout)
    LinearLayout moredetailLayout;
    @BindView(R.id.backbtn)
    ImageButton backbtn;
    @BindView(R.id.detailPhoto)
    ImageView detailPhoto;
    @BindView(R.id.detailUser)
    TextView detailUser;
    @BindView(R.id.detailPlace)
    TextView detailPlace;
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
        initViewsAndListeners();
        Bundle bundle = getIntent().getExtras();
        photo = bundle.getParcelable(MainActivity.PHOTO);
        loadUi();
    }

    private void initViewsAndListeners() {
        imagePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moredetailLayout.setVisibility(View.VISIBLE);
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moredetailLayout.setVisibility(View.GONE);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.this.onBackPressed();
            }
        });
    }

    private void loadUi() {
        ImageLoader.getInstance().displayImage(photo.getUrlM(),imagePhoto,MyApplication.options);
        ImageLoader.getInstance().displayImage(photo.getUrlM(),detailPhoto,MyApplication.options);
        String urlPicProfile = null;
        urlPicProfile = "http://farm" + photo.getIconfarm() + ".staticflickr.com/" + photo.getIconserver() + "/buddyicons/" + photo.getOwner()+ ".jpg";
        ImageLoader.getInstance().displayImage(urlPicProfile,profilePic,MyApplication.optionsRounded);
        username.setText(photo.getOwnername());
        detailUser.setText(photo.getOwnername());
        place.setText(photo.getTitle());
        detailPlace.setText(photo.getTitle());
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
