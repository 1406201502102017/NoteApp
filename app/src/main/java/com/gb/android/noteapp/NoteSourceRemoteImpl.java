package com.gb.android.noteapp;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

import java.util.ArrayList;
import java.util.List;

public class NoteSourceRemoteImpl implements NoteSource {

    private static String NOTES_COLLECTION = "cards";
    private FirebaseFirestore store = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = store.collection(NOTES_COLLECTION);
    private List<Note> notes =new ArrayList<Note>();

    @Override
    public NoteSource init(NoteSourceResponse noteSourceResponse) {
        collectionReference.orderBy(NoteTranslate.Fields.DATE, Query.Direction.DESCENDING).get(Source.SERVER)
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            notes = new ArrayList<Note>();
                            for (QueryDocumentSnapshot docFields: task.getResult()) {
                                Note note = NoteTranslate.documentToCardData(docFields.getId(),
                                        docFields.getData());
                                notes.add(note);
                            }
                            noteSourceResponse.initialized(NoteSourceRemoteImpl.this);
                        }
                    }
                });
        return this;
    }

    @Override
    public Note getNote(int position) {
        return notes.get(position);
    }

    @Override
    public int size() {
        return notes.size();
    }

    @Override
    public void clearNote() {
        for (Note note : notes) {
            collectionReference.document(note.getId()).delete();
        }
        notes.clear();
    }

    @Override
    public void deleteNote(int position) {
        collectionReference.document(notes.get(position).getId()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        });
        notes.remove(position);
    }

    @Override
    public void updateNote(int position, Note newNote) {
        collectionReference.document(notes.get(position).getId())
                .update(NoteTranslate.cardDataToDocument(newNote));
    }

    @Override
    public void addNote(Note newNote) {
        collectionReference.add(NoteTranslate.cardDataToDocument(newNote));
    }
}
