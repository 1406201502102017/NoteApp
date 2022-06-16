package com.gb.android.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.gb.android.noteapp.watcher.Editor;

import java.util.Objects;
/*
ДЗ №8
1. Подумайте о функционале вашего приложения заметок. Какие экраны там могут быть, помимо основного со списком заметок? Как можно использовать меню и боковое меню в вашем приложении? Не обязательно сразу пытаться реализовать весь этот функционал, достаточно создать макеты и структуру, а реализацию пока заменить на заглушки. Используйте подход Single Activity для отображения экранов.
2. В качестве примера: на главном экране приложения у вас список всех заметок, при нажатии на заметку открывается экран с этой заметкой. В меню главного экрана у вас есть иконка поиска по заметкам и сортировка. В меню «Заметки» у вас есть иконки «Переслать» (или «Поделиться»), «Добавить ссылку или фотографию к заметке».
3. Создайте боковое навигационное меню для своего приложения и добавьте туда хотя бы один экран, например «Настройки» или «О приложении».
4. * Создайте полноценный заголовок для NavigationDrawer’а. К примеру, аватарка пользователя, его имя и какая-то дополнительная информация.
5. * Изучите context menu
 */



public class MainActivity extends AppCompatActivity {

    private Editor editor = new Editor();

    public Editor getEditor() {
        return editor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        getSupportFragmentManager().addOnBackStackChangedListener((FragmentManager.OnBackStackChangedListener) this);
    }

    public void onBackStackChanged() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        } else {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        }
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}