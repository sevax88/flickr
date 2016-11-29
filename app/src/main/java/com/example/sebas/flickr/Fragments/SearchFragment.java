package com.example.sebas.flickr.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebas.flickr.Activities.DetailActivity;
import com.example.sebas.flickr.Activities.MainActivity;
import com.example.sebas.flickr.Activities.SearchActivity;
import com.example.sebas.flickr.Adapter.GridAdapter;
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

public class SearchFragment extends Fragment {

    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    FlickrService service;
    private GridAdapter adapter;

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
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Call<MyPhotos> call= service.search(FlickrService.METHOD_SEARCH,FlickrService.API_KEY,query,FlickrService.EXTRAS,FlickrService.PER_PAGE,1,FlickrService.FORMAT,1);
                call.enqueue(new Callback<MyPhotos>() {
                    @Override
                    public void onResponse(Call<MyPhotos> call, Response<MyPhotos> response) {
                        List<Photo> myPhotos = response.body().getPhotos().getPhoto();
                        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
                        adapter = new GridAdapter(myPhotos,getActivity(), new OnItemClickListener() {
                            @Override
                            public void onItemClick(Photo photo) {
                                Intent intent = new Intent(getActivity(),DetailActivity.class);
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

}
