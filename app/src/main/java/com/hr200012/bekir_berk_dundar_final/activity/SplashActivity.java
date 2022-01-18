package com.hr200012.bekir_berk_dundar_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hr200012.bekir_berk_dundar_final.R;
import com.hr200012.bekir_berk_dundar_final.util.InternetUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        kontrolEtVeAnaEkraniAc();
    }

    public void kontrolEtVeAnaEkraniAc() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                internetControlAndGoToListScreen();
            }
        }, 3000);
    }

    public void internetControlAndGoToListScreen() {
        if (InternetUtil.internetVarMi(getApplicationContext())) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        } else {
            internetYokAyarlaraGit();
        }
    }

    public void internetYokAyarlaraGit() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getResources().getString(R.string.internet_yok_baslik));
        alertDialogBuilder.setMessage(getResources().getString(R.string.internet_yok_aciklama));
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton(
                getResources().getString(R.string.interneti_ac),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent ayarlar = new Intent("android.settings.NETWORK_OPERATOR_SETTINGS");
                        ayarlar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(ayarlar);
                    }
                });

        alertDialogBuilder.setNegativeButton(
                getResources().getString(R.string.kapat),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

        alertDialogBuilder.show();
    }
}