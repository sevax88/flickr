package com.example.sebas.flickr.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.example.sebas.flickr.Adapter.GridAdapter;
import com.example.sebas.flickr.Interfaces.OnItemClickListener;
import com.example.sebas.flickr.Models.MyPhotos;
import com.example.sebas.flickr.Models.Photo;
import com.example.sebas.flickr.Models.Photos;
import com.example.sebas.flickr.R;
import com.example.sebas.flickr.Service.FlickrService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    FlickrService service;
    private GridAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        service = getService();
        initListeners();
    }

    private void initListeners() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Call<MyPhotos> call= service.search(FlickrService.METHOD_SEARCH,FlickrService.API_KEY,query,FlickrService.EXTRAS,FlickrService.PER_PAGE,1,FlickrService.FORMAT,1);
                call.enqueue(new Callback<MyPhotos>() {
                    @Override
                    public void onResponse(Call<MyPhotos> call, Response<MyPhotos> response) {
                        List<Photo> myPhotos = response.body().getPhotos().getPhoto();
                        recyclerView.setLayoutManager(new GridLayoutManager(SearchActivity.this,3));
                        adapter = new GridAdapter(myPhotos,SearchActivity.this, new OnItemClickListener() {
                            @Override
                            public void onItemClick(Photo photo) {
                                Intent intent = new Intent(SearchActivity.this,DetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putParcelable(MainActivity.PHOTO,photo);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<MyPhotos> call, Throwable t) {
                        Log.e("","");
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private FlickrService getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FlickrService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlickrService service = retrofit.create(FlickrService.class);
        return service;
    }
}
