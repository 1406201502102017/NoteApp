package com.gb.android.noteapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DataOutputFragment extends Fragment {

//    Toolbar toolbar;
//    RecyclerView recyclerView;

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        toolbar = toolbar.findViewById(R.id.toolbar);
//        recyclerView = recyclerView.findViewById(R.id.listOfNotes);
        return inflater.inflate(R.layout.fragment_data_output, container, false);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        toolbar = toolbar.findViewById(R.id.toolbar);
//        recyclerView = recyclerView.findViewById(R.id.listOfNotes);
//
//    }
}