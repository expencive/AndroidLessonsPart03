package ru.startandroid.recycleviewtestapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Настик on 08.11.2018.
 */

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {

    private static int viewHolderCount;
    private int numberItems;
    private Context parent;

    public NumbersAdapter (int numberOfItems, Context parent) {
        numberItems = numberOfItems;
        viewHolderCount = 0;

        this.parent = parent;


    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.number_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        NumberViewHolder viewHolder = new NumberViewHolder(view);
        viewHolder.viewHolderIndex.setText("ViewHolderIndex" + viewHolderCount);
        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView listItemNumberView;
        TextView viewHolderIndex;

        public NumberViewHolder(View itemView) {
            super(itemView);
            listItemNumberView = itemView.findViewById(R.id.tvNumberItem);
            viewHolderIndex = itemView.findViewById(R.id.tvViewHolderNumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int positionIndex = getAdapterPosition();
                    Toast.makeText(parent, "Element: " +positionIndex, Toast.LENGTH_SHORT).show();
                }
            });
        }
        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
