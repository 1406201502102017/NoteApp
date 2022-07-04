package com.gb.android.noteapp;

import com.google.firebase.Timestamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NoteTranslate {

    public  static class Fields{
        public final static String PICTURE = "picture";
        public final static String DATE = "date";
        public final static String TITLE = "title";
        public final static String DESCRIPTION = "description";
        public final static String DONE = "done";
    }

    public static Note documentToCardData(String id, Map<String,Object> doc){

        Note answer = new Note(
                (String) doc.get(Fields.TITLE),
                (String) doc.get(Fields.DESCRIPTION),
                ImageConverterIndex.getImageByIndex(Math.toIntExact((Long) doc.get(Fields.PICTURE))),
                (boolean) doc.get(Fields.DONE),
                ((Timestamp) Objects.requireNonNull(doc.get(Fields.DATE))).toDate());
        answer.setId(id);
        return answer;
    }

    public static Map<String,Object> cardDataToDocument(Note note){
        Map<String,Object> answer = new HashMap<>();
        answer.put(Fields.TITLE, note.getTitle());
        answer.put(Fields.DESCRIPTION, note.getDescription());
        answer.put(Fields.PICTURE,ImageConverterIndex.getIndexByImage(note.getPicture()));
        answer.put(Fields.DONE, note.isDone());
        answer.put(Fields.DATE, note.getDate());
        return answer;
    }
}
