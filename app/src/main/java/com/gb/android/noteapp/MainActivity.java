package com.gb.android.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.gb.android.noteapp.watcher.Editor;

import java.util.Objects;
/*
ДЗ №10
1. Создайте список ваших заметок.
2. Создайте карточку для элемента списка.
3. Класс данных, созданный на шестом уроке, используйте для заполнения
карточки списка.
4. * Создайте фрагмент для редактирования данных в конкретной карточке.
Этот фрагмент пока можно вызвать через основное меню.
 */

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