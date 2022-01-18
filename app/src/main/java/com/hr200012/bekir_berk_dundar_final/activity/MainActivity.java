package com.hr200012.bekir_berk_dundar_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.hr200012.bekir_berk_dundar_final.R;
import com.hr200012.bekir_berk_dundar_final.adaptor.FutbolcuAdaptor;
import com.hr200012.bekir_berk_dundar_final.model.Futbolcu;
import com.hr200012.bekir_berk_dundar_final.network.Service;
import com.hr200012.bekir_berk_dundar_final.adaptor.OnItemClickListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    List<Futbolcu> futbolcular;
    FutbolcuAdaptor fulbolcuAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komponentleriSetle();

        futbolcuListesiniAl();
    }

    public void komponentleriSetle(){
        futbolcular = new ArrayList<>();

        fulbolcuAdaptor = new FutbolcuAdaptor(futbolcular, getApplicationContext(), new OnItemClickListener(){
            @Override
            public void onItemClick(Futbolcu futbolcu) {
                Gson gson = new Gson();
                String jsonString = gson.toJson(futbolcu);
                Intent contentIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                contentIntent.putExtra(getResources().getString(R.string.futbolcu), jsonString);
                startActivity(contentIntent);
            }
        });

        RecyclerView recyclerViewFutbolcuList = findViewById(R.id.futbolcuList);
        recyclerViewFutbolcuList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewFutbolcuList.setAdapter(fulbolcuAdaptor);
    }

    public void futbolcuListesiniAl() {
        new Service().getServiceApi().futbolculariGetir()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Futbolcu>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Futbolcu> futbolcuListParam) {
                        futbolcular.addAll(futbolcuListParam);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if (futbolcular.size() > 0) {
                            fulbolcuAdaptor.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        cikmakIstediginizdenEminMisiniz();
    }

    public void cikmakIstediginizdenEminMisiniz() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getResources().getString(R.string.cikis_baslik));
        alertDialogBuilder.setMessage(getResources().getString(R.string.cikis_aciklama));
        alertDialogBuilder.setCancelable(true);

        alertDialogBuilder.setPositiveButton(
                getResources().getString(R.string.evet),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

        alertDialogBuilder.setNegativeButton(
                getResources().getString(R.string.hayir),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialogBuilder.show();
    }
}