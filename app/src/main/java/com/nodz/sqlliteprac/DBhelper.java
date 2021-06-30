package com.nodz.sqlliteprac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {

    final static String DB_NAME = "MYDB.db";
    final static String TABLE_NAME = "NotesTable";
    final static String COL_1 = "ID";
    final static String COL_2 = "NOTES";
    final static int DB_VERSION = 1;

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NOTES TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String note){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,note);

        long res = database.insert(TABLE_NAME,null,values);
        if(res == -1)
            return false;
        return true;
    }

    public int deleteNotes(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        return db.delete(TABLE_NAME, "ID=?", new String[]{id});
    }


    public ArrayList<NoteModel> getNotes(){
        ArrayList<NoteModel> notes = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from "+TABLE_NAME,null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                NoteModel model = new NoteModel();
                model.setNote_text(cursor.getString(1));
                notes.add(model);
            }
        }
        cursor.close();
        db.close();
        return notes;
    }
}
