package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context) {
        // tham số 1 : màn hình hiện tại
        // tham số 2 : tên của file chứa csdl
        // tham số 4 : 1  phiên bản của csdl
        super(context, "sql.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String tao_bang = "CREATE TABLE car (id text primary key,name text,price text)";
        sqLiteDatabase.execSQL(tao_bang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
