package com.example.contextualcards.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contextualcards.CardAdapter;
import com.example.contextualcards.R;
import com.example.contextualcards.models.Card;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Hc3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Hc3Fragment extends Fragment {
    private static final String ARG_CARDS = "cards";
    private List<Card> hc3Cards;
    public Hc3Fragment() {
        // Required empty public constructor
    }

    @NonNull
    public static Hc3Fragment newInstance(List<Card> cards) {
        Hc3Fragment fragment = new Hc3Fragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CARDS, (Serializable) cards);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            hc3Cards = (List<Card>) getArguments().getSerializable(ARG_CARDS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hc3, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CardAdapter adapter = new CardAdapter(hc3Cards);
        recyclerView.setAdapter(adapter);
    }
}