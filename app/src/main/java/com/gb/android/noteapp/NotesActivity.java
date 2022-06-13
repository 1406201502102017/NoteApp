package com.gb.android.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        NotesFragment frag = (NotesFragment) getSupportFragmentManager().findFragmentById(R.id.notes_frag);
        assert frag != null;
        frag.setNoteApp(1);
    }
}