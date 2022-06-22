package com.gb.android.noteapp;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NoteSourceLocalImpl implements NoteSource {

    private List<Note> dataSource;
    private Resources resources;    // ресурсы приложения

    public NoteSourceLocalImpl(Resources resources) {
        dataSource = new ArrayList<>(7);
        this.resources = resources;
    }

    public NoteSource init(NoteSourceResponse noteSourceResponse) {
        String[] titles = resources.getStringArray(R.array.titles);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        int[] pictures = getImageArray();
        for (int i = 0; i < descriptions.length; i++) {
            dataSource.add(new Note(titles[i], descriptions[i], pictures[i], false,
                    Calendar.getInstance().getTime()));
        }

        if(noteSourceResponse != null){
            noteSourceResponse.initialized(this);
        }
        return this;
    }

    private int[] getImageArray(){
        TypedArray pictures = resources.obtainTypedArray(R.array.pictures);
        int length = pictures.length();
        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            answer[i] = pictures.getResourceId(i, 0);
        }
        return answer;
    }

    public Note getNote(int position) {
        return dataSource.get(position);
    }

    public int size(){
        return dataSource.size();
    }

    @Override
    public void deleteNote(int position) {
        dataSource.remove(position);
    }

    @Override
    public void updateNote(int position, Note newNote) {
        dataSource.set(position, newNote);
    }

    @Override
    public void addNote(Note newNote) {
        dataSource.add(newNote);
    }

    @Override
    public void clearNote() {
        dataSource.clear();
    }
}
