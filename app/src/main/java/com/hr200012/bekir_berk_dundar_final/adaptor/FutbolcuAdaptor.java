package com.hr200012.bekir_berk_dundar_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hr200012.bekir_berk_dundar_final.R;
import com.hr200012.bekir_berk_dundar_final.model.Futbolcu;
import com.hr200012.bekir_berk_dundar_final.util.GlideUtil;

import java.util.List;

public class FutbolcuAdaptor extends RecyclerView.Adapter<FutbolcuViewHolder> {
    private List<Futbolcu> futbolcuList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public FutbolcuAdaptor(List<Futbolcu> futbolcuList, Context context, OnItemClickListener onItemClickListener) {
        this.futbolcuList = futbolcuList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public FutbolcuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_futbolcu, parent, false);

        FutbolcuViewHolder futbolcuViewHolder = new FutbolcuViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(futbolcuList.get(futbolcuViewHolder.getAdapterPosition()));
            }
        });
        return futbolcuViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FutbolcuViewHolder holder, int position) {
        final Futbolcu footballer = futbolcuList.get(position);
        holder.futbolcuAd.setText(footballer.ad + " " + footballer.soyad);
        holder.futbolcuUlke.setText(footballer.ulke);
        GlideUtil.resmiIndiripGoster(context, footballer.resim, holder.futbolcuResim);
        holder.futbolcuCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(footballer);
            }
        });
    }

    @Override
    public int getItemCount() {
        return futbolcuList.size();
    }
}

class FutbolcuViewHolder extends RecyclerView.ViewHolder {
    public TextView futbolcuAd;
    public TextView futbolcuUlke;
    public ImageView futbolcuResim;
    public CardView futbolcuCard;

    public FutbolcuViewHolder(View itemView) {
        super(itemView);
        futbolcuAd = itemView.findViewById(R.id.futbolcuAd);
        futbolcuUlke = itemView.findViewById(R.id.futbolcuUlke);
        futbolcuResim = itemView.findViewById(R.id.futbolcuResim);
        futbolcuCard = itemView.findViewById(R.id.futbolcuCard);
    }
}