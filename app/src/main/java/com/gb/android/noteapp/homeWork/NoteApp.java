package com.gb.android.noteapp.homeWork;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "notes")
public class NoteApp implements Serializable {
    //первичный ключ
    @PrimaryKey (autoGenerate = true)
    int ID = 0;
    //заголовок
    @ColumnInfo (name = "title")
    String title ="";
    //текст заметки
    @ColumnInfo (name = "notes")
    String notes ="";
    //дата создания
    @ColumnInfo (name = "date")
    String date ="";
    //выбор важных заметок
    @ColumnInfo (name = "pinned")
    boolean pinned = false;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
