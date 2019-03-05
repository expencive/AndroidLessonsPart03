package com.gmail.expencive.cif080architectureexample;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter {

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle, textViewDescription, textViewPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_id_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
