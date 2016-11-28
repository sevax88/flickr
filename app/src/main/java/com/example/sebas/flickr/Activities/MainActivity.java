package com.example.sebas.flickr.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sebas.flickr.Adapter.GridAdapter;
import com.example.sebas.flickr.Interfaces.EndlessRecyclerViewScrollListener;
import com.example.sebas.flickr.Interfaces.OnItemClickListener;
import com.example.sebas.flickr.Models.MyPhotos;
import com.example.sebas.flickr.Models.Photo;
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

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recycler;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    private FlickrService service;
    private GridLayoutManager gridLayoutManager;
    private EndlessRecyclerViewScrollListener scrollListener;
    private GridAdapter adapter;
    public static String PHOTO = "photo";
    public static boolean isGrid = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = getService();
        initViewsAndListeners();
        firstFetch();
    }


    private void firstFetch() {
        Call<MyPhotos> call = service.getAllPhotos(FlickrService.METHOD_RECENT,FlickrService.API_KEY,FlickrService.EXTRAS,FlickrService.PER_PAGE,1,FlickrService.FORMAT,1);
        call.enqueue(new Callback<MyPhotos>() {
            @Override
            public void onResponse(Call<MyPhotos> call, Response<MyPhotos> response) {
                List<Photo> myPhotos = response.body().getPhotos().getPhoto();
                adapter = new GridAdapter(myPhotos, MainActivity.this, new OnItemClickListener() {
                    @Override
                    public void onItemClick(Photo photo) {
                        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(PHOTO,photo);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
                recycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MyPhotos> call, Throwable t) {
                Log.e("","");
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

    private void initViewsAndListeners() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        gridLayoutManager = new GridLayoutManager(MainActivity.this,3);
        recycler.setLayoutManager(gridLayoutManager);
        scrollListener = new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                nextFetch(page,totalItemsCount,view);
            }
        };
        recycler.addOnScrollListener(scrollListener);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                Call<MyPhotos> call = service.getAllPhotos(FlickrService.METHOD_RECENT,FlickrService.API_KEY,FlickrService.EXTRAS,FlickrService.PER_PAGE,1,FlickrService.FORMAT,1);
                call.enqueue(new Callback<MyPhotos>() {
                    @Override
                    public void onResponse(Call<MyPhotos> call, Response<MyPhotos> response) {
                        List<Photo> refreshPhotos = response.body().getPhotos().getPhoto();
                        adapter.clear();
                        adapter.addAll(refreshPhotos);
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onFailure(Call<MyPhotos> call, Throwable t) {

                    }
                });
            }
        });
    }

    private void nextFetch(int page, final int startpos, final RecyclerView view) {
        Call<MyPhotos> call = service.getAllPhotos(FlickrService.METHOD_RECENT,FlickrService.API_KEY,FlickrService.EXTRAS,FlickrService.PER_PAGE,page,FlickrService.FORMAT,1);
        call.enqueue(new Callback<MyPhotos>() {
            @Override
            public void onResponse(Call<MyPhotos> call, Response<MyPhotos> response) {
                List<Photo> morephotos = response.body().getPhotos().getPhoto();
                adapter = (GridAdapter) view.getAdapter();
                adapter.getPhotos().addAll(morephotos);
                adapter.notifyItemRangeInserted(startpos,FlickrService.PER_PAGE);
            }

            @Override
            public void onFailure(Call<MyPhotos> call, Throwable t) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.estiloLista){
            if (isGrid){
                isGrid = false;
                gridLayoutManager.setSpanCount(1);
                item.setIcon(getResources().getDrawable(android.R.drawable.ic_dialog_dialer));
            }else {
                isGrid = true;
                gridLayoutManager.setSpanCount(3);
                item.setIcon(getResources().getDrawable(android.R.drawable.ic_menu_sort_by_size));
            }
            adapter.notifyDataSetChanged();
        }
        if (item.getItemId() == R.id.search){
            Intent intent = new Intent(this,SearchActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public RecyclerView getRecycler() {
        return recycler;
    }

    public GridLayoutManager getLayoutManager(){
        return this.gridLayoutManager;
    }
}
