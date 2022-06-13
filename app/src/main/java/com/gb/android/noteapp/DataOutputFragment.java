package com.gb.android.noteapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DataOutputFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data_output, container, false);
    }


//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle
//            savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initList(view);
//    }

//    private void initList(View view) {
//        LinearLayout layoutView = (LinearLayout) view;
//        String[] noteStructure = getResources().getStringArray(R.array.noteStructure);
//
//        //for (String structure : noteStructure)
//        for (int i = 0; i < noteStructure.length; i++) {
//            String structure = noteStructure[i];
//            TextView tv = new TextView(getContext());
//            tv.setText(structure);
//            tv.setTextSize(20);
//            layoutView.addView(tv);
//            final int position = i;
//            tv.setOnClickListener(v -> {
//                showOpenNote(position);
//            });
//        }
//    }

//    private void showOpenNote(int index) {
//        OpenNoteFragment openNoteFragment = OpenNoteFragment.newInstance(index);
//        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fragment_container, openNoteFragment);
//        fragmentTransaction.addToBackStack("");
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        fragmentTransaction.commit();
//    }
}