package com.gmail.expencive.cif080architectureexample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities =  {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {

        if (instance==null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;

    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTasc(instance).execute();
        }
    };

    private static class PopulateDbAsyncTasc extends AsyncTask<Void, Void, Void> {

        private NoteDao noteDao;

        private PopulateDbAsyncTasc(NoteDatabase db) {
            noteDao = db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Название 1", "Описание 1", 1));
            noteDao.insert(new Note("Название 2", "Описание 2", 2));
            noteDao.insert(new Note("Название 3", "Описание 3", 3));
            return null;
        }
    }
}
