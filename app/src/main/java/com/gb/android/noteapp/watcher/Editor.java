package com.gb.android.noteapp.watcher;

import java.util.ArrayList;
import java.util.List;

import com.gb.android.noteapp.Note;

public class Editor {

    private final List<Watcher> watcherList;

    public Editor() {
        this.watcherList = new ArrayList<Watcher>();
    }

    public void subscribe(Watcher watcher){
        watcherList.add(watcher);
    }

    public void unsubscribe(Watcher watcher){
        watcherList.remove(watcher);
    }

    public void notifyTask(Note note){
        for (Watcher watcher:watcherList){
            watcher.updateState(note);
            unsubscribe(watcher);
        }
    }

}
