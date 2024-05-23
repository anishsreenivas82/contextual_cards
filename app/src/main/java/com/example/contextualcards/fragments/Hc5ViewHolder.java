package com.example.contextualcards.fragments;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.contextualcards.R;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.utils.BackgroundUtils;
import com.example.contextualcards.utils.CtaUtils;

public class Hc5ViewHolder extends RecyclerView.ViewHolder{
    LinearLayout linearLayout;

    public Hc5ViewHolder(@NonNull View itemView) {
        super(itemView);
        linearLayout = itemView.findViewById(R.id.hc5_linear_layout);

    }

    public View bind(Card card) {
        // Bind background
        BackgroundUtils.setBackground(linearLayout, card.getBgColor(), card.getBgGradient(), card.getBgImage().getWebpImageUrl());
        linearLayout.setOnClickListener(v->{
            if(card.getUrl()!=null)
                CtaUtils.openUrl(card.getUrl(),v.getContext());
        });
        return itemView;
    }
}
