package com.example.sebas.flickr.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.sebas.flickr.Activities.DetailActivity;
import com.example.sebas.flickr.Activities.MainActivity;
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

/**
 * Created by sebba on 29/11/2016.
 */

public class SearchFragment extends BaseFragment {

    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    FlickrService service;
    private GridAdapter adapter;
    private GridLayoutManager gridLayoutManager;
    private EndlessRecyclerViewScrollListener scrollListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        service = ApiService.getInstance().getService();
        initListeners();
    }

    private void initListeners() {
        ((MainActivity)getActivity()).adviceIsGrid();
        gridLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        scrollListener = new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                nextFetch(page,totalItemsCount,view);
            }
        };
        recyclerView.addOnScrollListener(scrollListener);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Call<MyPhotos> call = ApiService.getInstance().getService().search(FlickrService.METHOD_SEARCH,FlickrService.API_KEY,searchView.getQuery().toString(),FlickrService.EXTRAS,FlickrService.PER_PAGE,1,FlickrService.FORMAT,1);
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
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressBar.setVisibility(View.VISIBLE);
                Call<MyPhotos> call= service.search(FlickrService.METHOD_SEARCH,FlickrService.API_KEY,query,FlickrService.EXTRAS,FlickrService.PER_PAGE,1,FlickrService.FORMAT,1);
                call.enqueue(new Callback<MyPhotos>() {
                    @Override
                    public void onResponse(Call<MyPhotos> call, Response<MyPhotos> response) {
                        progressBar.setVisibility(View.GONE);
                        List<Photo> myPhotos = response.body().getPhotos().getPhoto();
                        adapter = new GridAdapter(myPhotos,getActivity(), new OnItemClickListener() {
                            @Override
                            public void onItemClick(Photo photo) {
                                Intent intent = new Intent(getActivity(),DetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putParcelable(MainActivity.PHOTO,photo);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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

    private void nextFetch(int page, final int startpos, final RecyclerView view) {
        Call<MyPhotos> call = ApiService.getInstance().getService().search(FlickrService.METHOD_SEARCH,FlickrService.API_KEY,searchView.getQuery().toString(),FlickrService.EXTRAS,FlickrService.PER_PAGE,page,FlickrService.FORMAT,1);
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
    public GridAdapter getGridAdapter() {
        return adapter;
    }

    @Override
    public GridLayoutManager getGridLayoutManager() {
        return gridLayoutManager;
    }

}
