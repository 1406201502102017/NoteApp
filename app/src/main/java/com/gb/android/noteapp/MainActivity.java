package com.gb.android.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.gb.android.noteapp.watcher.Editor;

import java.util.Objects;
/*
ДЗ №11
1. Сделайте фрагмент добавления и редактирования данных, если вы ещё не сделали его.
2. Сделайте навигацию между фрагментами, также организуйте обмен данными между фрагментами.
3. Создайте контекстное меню для изменения и удаления заметок.
4. * Изучите, каким образом можно вызывать DatePicker в виде диалогового окна. Создайте текстовое поле,
при нажатии на которое вызывалось бы диалоговое окно с DatePicker.
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