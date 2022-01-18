package com.hr200012.bekir_berk_dundar_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hr200012.bekir_berk_dundar_final.R;

public class GlideUtil {
    public static void resmiIndiripGoster(Context context, String resimuRL, ImageView hangiImageView){
        Glide.with(context)
                .load(resimuRL)
                .error(R.drawable.fenerbahce)
                .centerCrop()
                .into(hangiImageView);
    }
}