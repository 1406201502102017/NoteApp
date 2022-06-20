package com.gb.android.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

//import com.gb.android.noteapp.DataOutputFragment;
import com.gb.android.noteapp.watcher.Editor;

import java.util.Objects;
/*
ДЗ №9
1. Используйте уведомления или диалоговые окна в своем приложении. К примеру, перед выходом
из приложения уточните у пользователя в диалоговом окне, действительно ли он хочет это сделать.
И отображайте Toast при закрытии приложения.
2. * Возвращайте данные из диалога в активити через интерфейс, но не передавая интерфейс
через отдельный метод фрагмента, а приводя контекст к типу этого интерфейса.
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