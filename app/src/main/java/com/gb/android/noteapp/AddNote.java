package com.gb.android.noteapp;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import com.gb.android.noteapp.Note;
import com.gb.android.noteapp.watcher.Editor;
import com.gb.android.noteapp.MainActivity;

public class AddNote extends Fragment {

    private static final String ARG_CARD_DATA = "Param_Note";
    private TextInputEditText title;
    private TextInputEditText description;
    private DatePicker datePicker;


    private Note note;
    private Editor editor;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        editor = ((MainActivity) context).getEditor();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        editor = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_note, container, false);
        initView(view);
        if (note != null) {
            populateView();
        }
        return view;
    }

    private void populateView() {
        title.setText(note.getTitle());
        description.setText(note.getDescription());
    }

    private void initView(View view) {
    }
}