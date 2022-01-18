package com.hr200012.bekir_berk_dundar_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr200012.bekir_berk_dundar_final.R;
import com.hr200012.bekir_berk_dundar_final.model.Futbolcu;
import com.google.gson.Gson;
import com.hr200012.bekir_berk_dundar_final.util.GlideUtil;

public class ProfileActivity extends AppCompatActivity {
    TextView futbolcuOzgecmis;
    ImageView futbolcuKapak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        komponentleriSetle();

        futbolcuVerisiniAl();
    }

    public void komponentleriSetle() {
        futbolcuOzgecmis = findViewById(R.id.futbolcuOzgecmis);
        futbolcuKapak = findViewById(R.id.futbolcuKapak);
    }

    public void futbolcuVerisiniAl() {
        Gson gson = new Gson();
        String jsonString = getIntent().getStringExtra(getResources().getString(R.string.futbolcu));
        Futbolcu futbolcu = gson.fromJson(jsonString, Futbolcu.class);

        futbolcuVerisiniGoster(futbolcu);
    }

    public void futbolcuVerisiniGoster(Futbolcu futbolcu) {
        getSupportActionBar().setTitle(futbolcu.ad + " " + futbolcu.soyad);

        futbolcuOzgecmis.setText(Html.fromHtml(futbolcu.ozgecmis));

        GlideUtil.resmiIndiripGoster(getApplicationContext(), futbolcu.kapak_foto, futbolcuKapak);
    }
}