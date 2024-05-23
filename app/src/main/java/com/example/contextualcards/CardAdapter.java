package com.example.contextualcards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contextualcards.fragments.Hc3ViewHolder;
import com.example.contextualcards.fragments.Hc1ViewHolder;
import com.example.contextualcards.fragments.Hc5ViewHolder;
import com.example.contextualcards.fragments.Hc6ViewHolder;
import com.example.contextualcards.fragments.Hc9ViewHolder;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.models.CardGroup;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    private List<Card> cards;
    private List<CardGroup> cardGroups;
    boolean isScrollable;
//    public CardAdapter(List<Card> cards) {
//        this.cards = cards;
//    }

    public CardAdapter(List<CardGroup> cardGroups) {
//        this.cards = cards;
        this.cardGroups = cardGroups;
    }
    static class NonScrollableLLViewHolder extends RecyclerView.ViewHolder {
        LinearLayout nonScrollableLl;

        NonScrollableLLViewHolder(@NonNull View itemView) {
            super(itemView);
            nonScrollableLl = itemView.findViewById(R.id.non_scrollable_linear_layout);
        }
    }

    static class ScrollableViewHolder extends RecyclerView.ViewHolder {
        HorizontalScrollView scrollableHv;
        LinearLayout scrollableLl;

        ScrollableViewHolder(@NonNull View itemView) {
            super(itemView);
            scrollableHv = itemView.findViewById(R.id.horizontal_scrollable_view);
            scrollableLl = itemView.findViewById(R.id.scrollable_linear_layout);
        }
    }

    @Override
    public int getItemViewType(int position) {
        String res = cardGroups.get(position).getDesignType();
        isScrollable = cardGroups.get(position).isScrollable();
        switch (res) {
            case "HC6":
                return 2;
            case "HC5":
                return 3;
            case "HC9":
                return 4;
            case "HC1":
                return 5;
            default:
                return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // Inflate the custom layout
        if(viewType==4) //HC9
            return new ScrollableViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizontal_scroll_layout, parent, false));
        else if (!isScrollable)
            return new NonScrollableLLViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizontal_no_scroll_layout, parent, false));
        else return new ScrollableViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_scroll_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List<Card> card = cardGroups.get(position).getCards();
        Integer viewType = holder.getItemViewType();
        if (viewType == 1) {
            if(isScrollable){
                for(Card c: card)
                    ((ScrollableViewHolder) holder).scrollableLl.addView(new Hc3ViewHolder(LayoutInflater.from(holder.itemView.getContext())
                            .inflate(R.layout.fragment_hc3, ((ScrollableViewHolder) holder).scrollableLl, false)).bind(c));
            } else {
                for(Card c: card)
                    ((NonScrollableLLViewHolder) holder).nonScrollableLl.addView(new Hc3ViewHolder(LayoutInflater.from(holder.itemView.getContext())
                            .inflate(R.layout.fragment_hc3, ((NonScrollableLLViewHolder) holder).nonScrollableLl, false)).bind(c));
            }
        }
        else if (viewType == 2) {
            if(isScrollable){
                for(Card c: card)
                    ((ScrollableViewHolder) holder).scrollableLl.addView(new Hc6ViewHolder(LayoutInflater.from(holder.itemView.getContext())
                            .inflate(R.layout.fragment_hc6, ((ScrollableViewHolder) holder).scrollableLl, false)).bind(c));
            } else {
                for(Card c: card)
                    ((NonScrollableLLViewHolder) holder).nonScrollableLl.addView(new Hc6ViewHolder(LayoutInflater.from(holder.itemView.getContext())
                            .inflate(R.layout.fragment_hc6, ((NonScrollableLLViewHolder) holder).nonScrollableLl, false)).bind(c));
            }

        }
        else if (viewType == 3) {
            if(isScrollable){
                for(Card c: card)
                    ((ScrollableViewHolder) holder).scrollableLl.addView(new Hc5ViewHolder(LayoutInflater.from(holder.itemView.getContext())
                            .inflate(R.layout.fragment_hc5, ((ScrollableViewHolder) holder).scrollableLl, false)).bind(c));
            } else {
                for(Card c: card)
                    ((NonScrollableLLViewHolder) holder).nonScrollableLl.addView(new Hc5ViewHolder(LayoutInflater.from(holder.itemView.getContext())
                            .inflate(R.layout.fragment_hc5, ((NonScrollableLLViewHolder) holder).nonScrollableLl, false)).bind(c));
            }
        }
        else if(viewType ==4){
            for(Card c: card)
                ((ScrollableViewHolder) holder).scrollableLl.addView(new Hc9ViewHolder(LayoutInflater.from(holder.itemView.getContext())
                        .inflate(R.layout.fragment_hc9, ((ScrollableViewHolder) holder).scrollableLl, false)).bind(c));
        }
        else if (viewType == 5) {
            if(isScrollable){
                for(Card c: card)
                    ((ScrollableViewHolder) holder).scrollableLl.addView(new Hc1ViewHolder(LayoutInflater.from(holder.itemView.getContext())
                            .inflate(R.layout.fragment_hc1, ((ScrollableViewHolder) holder).scrollableLl, false)).bind(c));
            } else {
                for(Card c: card)
                    ((NonScrollableLLViewHolder) holder).nonScrollableLl.addView(new Hc1ViewHolder(LayoutInflater.from(holder.itemView.getContext())
                            .inflate(R.layout.fragment_hc1, ((NonScrollableLLViewHolder) holder).nonScrollableLl, false)).bind(c));
            }
        }
    }

    @Override
    public int getItemCount() {
        return cardGroups.size();
    }
}

