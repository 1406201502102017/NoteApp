package com.gb.android.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.gb.android.noteapp.watcher.Editor;

import java.util.Objects;
/*
ДЗ №12
1. Приложение SharedPreferences всё ещё работает некорректно:
если добавить в него несколько заметок, то все они называются одинаково.
Более того, если вы открываете приложение с уже созданными заметками,
то при добавлении новой заметки, старые заметки удаляются из списка.
Исправьте эту ситуацию.
2. Сохраняйте список заметок в своём приложении заметок.
3. * Обеспечьте хранение данных приложения через Firestore.
4. * Организуйте аутентификацию пользователя через Google.
5. * Изучите DataStore и замените SharedPreferences. */

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private final Editor editor = new Editor();
    private Navigator navigator;

    public Editor getEditor() {
        return editor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigator = new Navigator(getSupportFragmentManager());
        initToolbar();
        navigator.addFragment(DataOutputFragment.newInstance(), false);
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    public void onBackStackChanged() {
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount() > 0);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public Navigator getNavigator() {
        return navigator;
    }
}