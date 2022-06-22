package com.gb.android.noteapp;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter
        extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private final static String TAG = "SocialNetworkAdapter";

    @SuppressLint("NotifyDataSetChanged")
    public void setDataSource(NoteSource dataSource) {
        this.dataSource = dataSource;
        notifyDataSetChanged();
    }

    private NoteSource dataSource;
    private OnItemClickListener itemClickListener;

    private final Fragment fragment;
    private int menuContextClickPosition;

    public int getMenuContextClickPosition() {
        return menuContextClickPosition;
    }

    public NoteAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        Log.d(TAG, "onCreateViewHolder");
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setData(dataSource.getNote(i));
        Log.d(TAG, "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public void SetOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView description;
        private final AppCompatImageView image;
        private final CheckBox box;
        private final TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.note_body);
            image = (AppCompatImageView) itemView.findViewById(R.id.imageView);
            box = itemView.findViewById(R.id.done);
            date = itemView.findViewById(R.id.date);

            fragment.registerForContextMenu(image);

            image.setOnClickListener(v -> {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, getAdapterPosition());
                }
            });
            image.setOnLongClickListener(view -> {
                menuContextClickPosition = getAdapterPosition();
                itemView.showContextMenu();
                return false;
            });
        }

        public void setData(Note note) {
            title.setText(note.getTitle());
            date.setText(note.getDate().toString());
            description.setText(note.getDescription());
            box.setChecked(note.isDone());
            image.setImageResource(note.getPicture());
        }
    }
}
