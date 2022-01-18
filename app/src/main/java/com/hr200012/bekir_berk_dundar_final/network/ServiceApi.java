package com.hr200012.bekir_berk_dundar_final.network;

import com.hr200012.bekir_berk_dundar_final.model.Futbolcu;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("futbolcular.json")
    Observable<List<Futbolcu>> futbolculariGetir();
}