package com.gb.android.noteapp;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;
import com.gb.android.noteapp.watcher.Editor;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

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
        initDatePicker(note.getDate());
    }

    private void initDatePicker(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.datePicker.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                null);
    }

    private Date getDateFromDatePicker() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, this.datePicker.getYear());
        cal.set(Calendar.MONTH, this.datePicker.getMonth());
        cal.set(Calendar.DAY_OF_MONTH, this.datePicker.getDayOfMonth());
        return cal.getTime();
    }

    private void initView(View view) {
        title = view.findViewById(R.id.inputTitle);
        description = view.findViewById(R.id.inputDescription);
        datePicker = view.findViewById(R.id.inputDate);
    }

    public static AddNote newInstance(Note note) {
        AddNote fragment = new AddNote();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CARD_DATA, note);
        fragment.setArguments(args);
        return fragment;
    }

    public static AddNote newInstance() {
        AddNote fragment = new AddNote();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_CARD_DATA);
        }
    }

    private Note collectCardData() {
        String title = Objects.requireNonNull(this.title.getText()).toString();
        String description = Objects.requireNonNull(this.description.getText()).toString();
        Date date = getDateFromDatePicker();

        if (note != null) {
            note.setTitle(title);
            note.setDescription(description);
            note.setDate(date);
            return note;
        } else {
            int picture = ImageConverterIndex.getImageByIndex(ImageConverterIndex.randomImageIndex());
            return new Note(title, description, picture, false, date);
        }
    }

    // данные из views
    @Override
    public void onStop() {
        super.onStop();
        note = collectCardData();
    }

    // данные в editor
    @Override
    public void onDestroy() {
        super.onDestroy();
        editor.notifyTask(note);
    }
}