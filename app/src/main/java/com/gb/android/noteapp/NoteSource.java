package com.gb.android.noteapp;

public interface NoteSource {

    NoteSource init(NoteSourceResponse noteSourceResponse);
    Note getNote(int position);
    int size();

    void deleteNote(int position);
    void updateNote(int position, Note newNote);
    void addNote(Note newNote);
    void clearNote();
}
