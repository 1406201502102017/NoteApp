package com.gb.android.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
/*
ДЗ №6
1. Почитайте документацию методов requireActivity(), requireContext(), getActivity(), getContext()
и объясните разницу между ними;
2. Создайте класс данных со структурой заметок: название заметки, описание заметки, дата создания и т. п.
3. Создайте фрагмент для вывода этих данных.
4. Встройте этот фрагмент в активити. У вас должен получиться экран с заметками,
который мы будем улучшать с каждым новым уроком.
5. Добавьте фрагмент, в котором открывается заметка. По аналогии с примером из урока: если нажать
на элемент списка в портретной ориентации — открывается новое окно, если нажать в ландшафтной — окно открывается рядом.
6. * Разберитесь, как можно сделать, и сделайте корректировку даты создания при
помощи DatePicker.
*/
/*
ДЗ №7
1. Разберитесь в различиях между serializable и parcelable;
2. Подумайте о функционале вашего приложения заметок. Какие экраны там могут быть, помимо
основного со списком заметок? Не обязательно сразу пытаться реализовать весь этот
функционал, достаточно создать макеты и структуру, а реализацию пока заменить на
заглушки или всплывающие уведомления (Toast). Используйте подход Single Activity для
отображения экранов.
В качестве примера: на главном экране приложения у вас список всех заметок, при нажатии
на заметку открывается экран с этой заметкой.
3. * Сделайте UI более сложным, создайте начальный экран приложения с переходами на список
городов, настройки, сведения о приложении. Добавьте в свое приложение child-фрагменты.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataOutputFragment dataOutputFragment = new DataOutputFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, dataOutputFragment).commit();

        AddNote addNote = new AddNote();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, addNote).commit();

    }
}