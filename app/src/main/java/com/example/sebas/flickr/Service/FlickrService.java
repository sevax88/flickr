package com.example.sebas.flickr.Service;


import com.example.sebas.flickr.Models.MyPhotos;
import com.example.sebas.flickr.Models.Photo;
import com.example.sebas.flickr.Models.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface FlickrService {

    final String BASE_URL = "https://api.flickr.com";
    final String API_KEY = "8180565e985265a9d97e132b18d79c62";
    final String METHOD_RECENT = "flickr.photos.getRecent";
    final String METHOD_SEARCH = "flickr.photos.search";
    final String EXTRAS = "description,date_upload, date_taken, owner_name, icon_server, original_format, last_update, tags, machine_tags, o_dims, views, media, path_alias, url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l, url_o";
    final String FORMAT = "json";
    final int PER_PAGE = 100;

    @GET("services/rest")
    Call<MyPhotos> getAllPhotos(@Query("method") String apimethod,
                                @Query("api_key") String apikey,
                                @Query("extras") String extras,
                                @Query("per_page") int perpage,
                                @Query("page") int page,
                                @Query("format") String format,
                                @Query("nojsoncallback") int jsonformat);

    @GET("services/rest")
    Call<MyPhotos> search(@Query("method") String apimethod,
                        @Query("api_key") String apikey,
                        @Query("text") String textquery,
                        @Query("extras") String extras,
                        @Query("per_page") int perpage,
                        @Query("page") int page,
                        @Query("format") String format,
                        @Query("nojsoncallback") int jsonformat);



}
