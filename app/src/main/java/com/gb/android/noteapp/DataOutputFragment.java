package com.gb.android.noteapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gb.android.noteapp.watcher.*;

public class DataOutputFragment extends Fragment {

    private NoteSource data;
    private NoteAdapter adapter;

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

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_data_output, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_lines);
        initRecyclerView(recyclerView, data);

        data = new NoteSourceRemoteImpl().init(noteSource -> adapter.notifyDataSetChanged());
        adapter.setDataSource(data);
        return view;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initRecyclerView(RecyclerView recyclerView, NoteSource data) {
        this.data = data;
        recyclerView.setHasFixedSize(true);
        //встроенным менеджер
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NoteAdapter(this);
        recyclerView.setAdapter(adapter);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(700);
        defaultItemAnimator.setChangeDuration(700);
        defaultItemAnimator.setRemoveDuration(700);
        recyclerView.setItemAnimator(defaultItemAnimator);
        //разделитель карточек
        DividerItemDecoration itemDecoration = new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.separator, null));
        recyclerView.addItemDecoration(itemDecoration);

        adapter.SetOnItemClickListener((view, position) -> {
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);
    }

    @SuppressLint({"NotifyDataSetChanged", "NonConstantResourceId"})
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                navigator.addFragment(AddNote.newInstance(), true);
                editor.subscribe(note -> {
                    data.addNote(note);
                    adapter.notifyItemInserted(data.size() - 1);
                });
                return true;
            case R.id.action_clear:
                data.clearNote();
                adapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        requireActivity().getMenuInflater().inflate(R.menu.note_menu, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int position = adapter.getMenuContextClickPosition();
        switch (item.getItemId()) {
            case R.id.action_update:
                navigator.addFragment(AddNote.newInstance(data.getNote(position)), true);
                editor.subscribe(note -> {
                    data.updateNote(position, note);
                    adapter.notifyItemChanged(position);
                });
                return true;
            case R.id.action_delete:
                data.deleteNote(position);
                adapter.notifyItemRemoved(position);
                return true;
        }

        return super.onContextItemSelected(item);
    }
}