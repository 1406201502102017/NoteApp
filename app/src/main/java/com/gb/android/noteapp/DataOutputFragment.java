package com.gb.android.noteapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gb.android.noteapp.watcher.Editor;

public class DataOutputFragment extends Fragment {
    private NoteSource data;
    private NoteAdapter adapter;
    private RecyclerView recyclerView;

    private Navigator navigator;
    private Editor editor;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        navigator = activity.getNavigator();
        editor = activity.getEditor();
    }

    @Override
    public void onDetach() {
        navigator = null;
        editor = null;
        super.onDetach();
    }

    public static DataOutputFragment newInstance() {
        return new DataOutputFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_data_output, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_lines);
        initRecyclerView(recyclerView, data);

        if (false) {
            data = new NoteSourceLocalImpl(getResources()).init((NoteSourceResponse) notesSource -> {
            });
        } else {
            data = new NoteSourceRemoteImpl().init((NoteSourceResponse) notesSource -> adapter.notifyDataSetChanged());
        }

        adapter.setDataSource(data);
        return view;
    }

    private void initRecyclerView(RecyclerView recyclerView, NoteSource data) {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NoteAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}