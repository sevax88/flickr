package com.example.sebas.flickr.Activities;

import android.content.Intent;
import android.os.Bundle;
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
                HomeFragment homeFragment = ((HomeFragment)getSupportFragmentManager().findFragmentByTag(HomeFragment.class.getName()));
                gridLayoutManager = homeFragment.getGridLayoutManager();
                adapter = homeFragment.getAdapter();
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
            getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new SearchFragment(),SearchFragment.class.getName());
        }

        return super.onOptionsItemSelected(item);
    }

}
