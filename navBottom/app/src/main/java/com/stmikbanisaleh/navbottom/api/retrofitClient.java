package com.stmikbanisaleh.navbottom.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitClient {
    public static final String IMAGE_URL = "http://192.168.43.24/rest/DataBarang/asset/cover";
    private static String BASE_URL= "http://192.168.43.24/rest/DataBarang/";

//    public static final String IMAGE_URL = "http://192.168.22.74/rest/DataBarang/asset/cover";
//    private static String BASE_URL= "http://192.168.22.74/rest/DataBarang/";

    private static retrofitClient retrofitClient;
    private static Retrofit retrofit;

    public retrofitClient() {



        if (retrofit == null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient client = new OkHttpClient.Builder()
                            .addInterceptor(logging)
                            .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
    }

    public static synchronized retrofitClient getInstance(){
        if (retrofitClient==null){
            retrofitClient = new retrofitClient();
        }
        return retrofitClient;
    }

    public static String getBaseUrlImage() {
        return IMAGE_URL;
    }

    public api getApi(){
        return retrofit.create(api.class);
    }
}
