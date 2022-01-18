package com.hr200012.bekir_berk_dundar_final.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.hr200012.bekir_berk_dundar_final.util.Constants.BASE_URL;

public class Service {

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    private static ServiceApi serviceApi;

    private static OkHttpClient getOkHttpClient(){
        if(okHttpClient == null){
            okHttpClient = new OkHttpClient().newBuilder().build();
        }
        return okHttpClient;
    }

    private static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public ServiceApi getServiceApi(){
        if(serviceApi == null){
            serviceApi = getRetrofit().create(ServiceApi.class);
        }
        return serviceApi;
    }
}