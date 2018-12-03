package ru.startandroid.cif022sqliteandrecyclerview;

import android.provider.BaseColumns;

/**
 * Created by Настик on 03.12.2018.
 */

public class GroceryContract {
    private GroceryContract() {}

    public static final class GroceryEntry implements BaseColumns {



        public static final String TABLE_NAME = "groceryList";
        public final static String COLUMN_NAME = "name";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";

    }
}
