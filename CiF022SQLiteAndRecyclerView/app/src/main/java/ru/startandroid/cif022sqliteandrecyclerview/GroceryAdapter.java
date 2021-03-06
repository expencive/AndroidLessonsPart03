package ru.startandroid.cif022sqliteandrecyclerview;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Настик on 03.12.2018.
 */

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {

    private Context mContext;
    private Cursor mCursor;

    public GroceryAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView countText;
        public TextView timeStampItem;

        public GroceryViewHolder(View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.tvNameItem);
            countText = itemView.findViewById(R.id.tvAmountItem);
            timeStampItem = itemView.findViewById(R.id.tvTimeStampItem);

        }
    }

    @Override
    public GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.grocery_item, parent, false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroceryViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        String name = mCursor.getString(mCursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_NAME));
        int amount = mCursor.getInt(mCursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_AMOUNT));
        String timeStamp = mCursor.getString(mCursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_TIMESTAMP));

        long id = mCursor.getLong(mCursor.getColumnIndex(GroceryContract.GroceryEntry._ID));

        holder.nameText.setText(name);
        holder.countText.setText(String.valueOf(amount));
        holder.timeStampItem.setText(timeStamp);
        holder.itemView.setTag(id);

    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor !=null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor !=null) {
            notifyDataSetChanged();
        }

    }
}
