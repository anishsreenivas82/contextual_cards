package com.example.contextualcards;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contextualcards.models.Card;
import com.example.contextualcards.models.CardGroup;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCardGroup#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCardGroup extends Fragment {
    private static final String ARG_CARDS = "cardGroups";
    private static List<CardGroup> cardGroups;
    public FragmentCardGroup() {
        // Required empty public constructor
    }
    public static FragmentCardGroup newInstance(String param1, String param2) {
        FragmentCardGroup fragment = new FragmentCardGroup();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CARDS, (Serializable) cardGroups);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cardGroups = (List<CardGroup>) getArguments().getSerializable(ARG_CARDS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_group, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.cardRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CardAdapter adapter = new CardAdapter(cardGroups);
        recyclerView.setAdapter(adapter);
        return view;
    }
}