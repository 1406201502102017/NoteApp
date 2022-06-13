package com.gb.android.noteapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class AddNote extends Fragment {

//    Toolbar toolbar;
//    EditText noteTitle, noteDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        toolbar = toolbar.findViewById(R.id.toolbar);
//        noteTitle = noteTitle.findViewById(R.id.noteTitle);
//        noteDetails = noteDetails.findViewById(R.id.noteDetails);

        return inflater.inflate(R.layout.fragment_add_note, container, false);

    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        toolbar = toolbar.findViewById(R.id.toolbar);
//        noteTitle = noteTitle.findViewById(R.id.noteTitle);
//        noteDetails = noteDetails.findViewById(R.id.noteDetails);
//    }
}