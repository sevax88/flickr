package com.example.sebas.flickr.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.sebas.flickr.Adapter.GridAdapter;
import com.example.sebas.flickr.Fragments.BaseFragment;
import com.example.sebas.flickr.Fragments.HomeFragment;
import com.example.sebas.flickr.Fragments.SearchFragment;
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
    @BindView(R.id.frameContainer)
    FrameLayout frameLayout;
    private GridLayoutManager gridLayoutManager;
    private GridAdapter adapter;
    public static String PHOTO = "photo";
    public static boolean isGrid = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        initFirstFrag();
    }

    private void initFirstFrag() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.frameContainer,new HomeFragment(),HomeFragment.class.getName());
        fragmentTransaction.commit();
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
                BaseFragment baseFragment = ((BaseFragment)getSupportFragmentManager().findFragmentById(R.id.frameContainer));
                gridLayoutManager = baseFragment.getGridLayoutManager();
                adapter = baseFragment.getGridAdapter();
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
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (fm.findFragmentByTag(HomeFragment.class.getName()).isVisible()){
                //a HomeFragment is visible so I should go to a SearchFragment
                toolbar.getMenu().findItem(R.id.search).setIcon(R.drawable.home_icon);
                if (fm.findFragmentByTag(SearchFragment.class.getName()) == null){
                    ft.add(R.id.frameContainer,new SearchFragment(),SearchFragment.class.getName());
                }
                else {
                    ft.attach(fm.findFragmentByTag(SearchFragment.class.getName()));
                }
                ft.detach(fm.findFragmentByTag(HomeFragment.class.getName()));
                ft.commit();
            }
            else {
                //a SearchFragment is visible so I should go to a HomeFragment
                toolbar.getMenu().findItem(R.id.search).setIcon(getResources().getDrawable(android.R.drawable.ic_menu_search));
                if (fm.findFragmentByTag(HomeFragment.class.getName()) == null){
                    ft.add(R.id.frameContainer,new HomeFragment(),HomeFragment.class.getName());
                }
                else {
                    ft.attach(fm.findFragmentByTag(HomeFragment.class.getName()));
                }
                ft.detach(fm.findFragmentByTag(SearchFragment.class.getName()));
                ft.commit();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
