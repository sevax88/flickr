package com.example.sebas.flickr.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebas.flickr.Activities.DetailActivity;
import com.example.sebas.flickr.Adapter.GridAdapter;
import com.example.sebas.flickr.Interfaces.EndlessRecyclerViewScrollListener;
import com.example.sebas.flickr.Interfaces.OnItemClickListener;
import com.example.sebas.flickr.Models.MyPhotos;
import com.example.sebas.flickr.Models.Photo;
import com.example.sebas.flickr.R;
import com.example.sebas.flickr.Service.ApiService;
import com.example.sebas.flickr.Service.FlickrService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sebba on 28/11/2016.
 */

public class HomeFragment extends BaseFragment {


    @BindView(R.id.recyclerview)
    RecyclerView recycler;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    private GridLayoutManager gridLayoutManager;
    private EndlessRecyclerViewScrollListener scrollListener;
    private GridAdapter adapter;
    public static String PHOTO = "photo";
    public static boolean isGrid = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewsAndListeners();
        firstFetch();
    }

    private void firstFetch() {
        Call<MyPhotos> call = ApiService.getInstance().getService().getAllPhotos(FlickrService.METHOD_RECENT,FlickrService.API_KEY,FlickrService.EXTRAS,FlickrService.PER_PAGE,1,FlickrService.FORMAT,1);
        call.enqueue(new Callback<MyPhotos>() {
            @Override
            public void onResponse(Call<MyPhotos> call, Response<MyPhotos> response) {
                List<Photo> myPhotos = response.body().getPhotos().getPhoto();
                adapter = new GridAdapter(myPhotos,getActivity(), new OnItemClickListener() {
                    @Override
                    public void onItemClick(Photo photo) {
                        Intent intent = new Intent(getActivity(),DetailActivity.class);
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


    private void initViewsAndListeners() {
        gridLayoutManager = new GridLayoutManager(getActivity(),3);
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
                Call<MyPhotos> call = ApiService.getInstance().getService().getAllPhotos(FlickrService.METHOD_RECENT,FlickrService.API_KEY,FlickrService.EXTRAS,FlickrService.PER_PAGE,1,FlickrService.FORMAT,1);
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
        Call<MyPhotos> call = ApiService.getInstance().getService().getAllPhotos(FlickrService.METHOD_RECENT,FlickrService.API_KEY,FlickrService.EXTRAS,FlickrService.PER_PAGE,page,FlickrService.FORMAT,1);
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
    public GridLayoutManager getGridLayoutManager() {
        return gridLayoutManager;
    }

    @Override
    public GridAdapter getGridAdapter() {
        return adapter;
    }
}
