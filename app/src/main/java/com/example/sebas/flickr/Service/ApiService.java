package com.example.sebas.flickr.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sebba on 29/11/2016.
 */

public class ApiService {

    private static ApiService instance;
    private static FlickrService service;

    public static ApiService getInstance () {
        if (instance == null) {
            instance = new ApiService();
            service = createService();
        }
        return instance;
    }

    private static FlickrService createService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FlickrService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlickrService service = retrofit.create(FlickrService.class);
        return service;
    }

    public FlickrService getService() {
        return service;
    }
}
