package com.example.contextualcards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contextualcards.models.Card;
import com.example.contextualcards.models.CardGroup;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Card> cards;

    public CardAdapter(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public int getItemViewType(int position) {
        int res = cards.get(position).getId();
        switch (res) {
//            case 1:
//                return 1;
//            case "HC6":
//                return 2;
//            case "HC5":
//                return 3;
//            case "HC9":
//                return 4;
            default:
                return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View view = inflater.inflate(R.layout.fragment_hc3, parent, false);
            return new HC3ViewHolder(view);
        }
//        else if (viewType == 2) {
//            View view = inflater.inflate(R.layout.item_card_hc6, parent, false);
//            return new HC6ViewHolder(view);
//        } else if (viewType == 3) {
//            View view = inflater.inflate(R.layout.item_card_hc5, parent, false);
//            return new HC5ViewHolder(view);
//        } else if (viewType == 4) {
//            View view = inflater.inflate(R.layout.item_card_hc9, parent, false);
//            return new HC9ViewHolder(view);
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Card card = cards.get(position);
        if (holder instanceof HC3ViewHolder) {
            ((HC3ViewHolder) holder).bind(card);
        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}

