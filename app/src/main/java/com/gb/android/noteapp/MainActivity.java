package com.gb.android.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import androidx.fragment.app.FragmentTransaction;

/*
ДЗ №6
1. Почитайте документацию методов requireActivity(), requireContext(), getActivity(), getContext() и объясните разницу между ними;
2. Создайте класс данных со структурой заметок: название заметки, описание заметки, дата создания и т. п.
3. Создайте фрагмент для вывода этих данных.
4. Встройте этот фрагмент в активити. У вас должен получиться экран с заметками,
который мы будем улучшать с каждым новым уроком.
5. Добавьте фрагмент, в котором открывается заметка. По аналогии с примером из урока: если нажать на элемент списка в портретной ориентации — открывается новое окно, если нажать в ландшафтной — окно открывается рядом.
6. * Разберитесь, как можно сделать, и сделайте корректировку даты создания при
помощи DatePicker.
ДЗ №7
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        DataOutputFragment dataOutputFragment = new DataOutputFragment();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, dataOutputFragment);
//        fragmentTransaction.addToBackStack("");
//        fragmentTransaction.commit();
//    }
}

    public void onShowNotes(View view) {
        Intent intent = new Intent(this, NotesActivity.class);
        startActivity(intent);
    }
}