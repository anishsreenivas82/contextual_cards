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
import com.example.contextualcards.models.CardGroup;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Hc6Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Hc6Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CARDS = "cardGroups";
    private List<CardGroup> hc6CardGroup;

    public Hc6Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHc6.
     */
    // TODO: Rename and change types and number of parameters
    public static Hc6Fragment newInstance(List<CardGroup> cards) {
        Hc6Fragment fragment = new Hc6Fragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CARDS, (Serializable) cards);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            hc6CardGroup = (List<CardGroup>) getArguments().getSerializable(ARG_CARDS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hc6, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CardAdapter adapter = new CardAdapter(hc6CardGroup);
        recyclerView.setAdapter(adapter);
    }
}