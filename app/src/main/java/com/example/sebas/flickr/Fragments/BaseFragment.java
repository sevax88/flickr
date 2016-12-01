package com.example.sebas.flickr.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.example.sebas.flickr.Activities.MainActivity;
import com.example.sebas.flickr.Adapter.GridAdapter;

/**
 * Created by sebba on 29/11/2016.
 */

public class BaseFragment extends Fragment {

    private GridLayoutManager gridLayoutManager;
    private GridAdapter gridAdapter;

    public GridLayoutManager getGridLayoutManager() {
        return gridLayoutManager;
    }

    public void setGridLayoutManager(GridLayoutManager gridLayoutManager) {
        this.gridLayoutManager = gridLayoutManager;
    }

    public GridAdapter getGridAdapter() {
        return gridAdapter;
    }

    public void setGridAdapter(GridAdapter gridAdapter) {
        this.gridAdapter = gridAdapter;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity)activity).adviceIsGrid();

    }
}
