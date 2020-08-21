package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAO {

    private SqliteHelper sqliteHelper;

    public DienThoaiDAO(SqliteHelper sqliteHelper) {
        this.sqliteHelper = sqliteHelper;
    }

    public void themDienThoai(DienThoai car) {
        // xin quyen
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();
        // ghep cap gia tri
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", car.id);
        contentValues.put("name", car.name);
        contentValues.put("price", car.price);

        // truy van them

        sqLiteDatabase.insert("car", null, contentValues);

    }


    public List<DienThoai> danhSachCar() {
        List<DienThoai> cars = new ArrayList<>();
        String truyVan = "Select * from car";
        // xin quyen
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();
        // truy van
        Cursor cursor = sqLiteDatabase.rawQuery(truyVan, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                DienThoai car = new DienThoai();
                car.id = cursor.getString(0);
                car.name = cursor.getString(1);
                car.price = cursor.getString(2);
                cars.add(car);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return cars;
    }

    public long suaDienThoai(DienThoai dienThoai) {
        // xin quyen
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();
        // ghep cap gia tri
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", dienThoai.name);
        contentValues.put("price", dienThoai.price);

        // truy van them

        return sqLiteDatabase.update("car", contentValues, "id=?"
                , new String[]{dienThoai.id});

    }

    public void xoa(String id) {
        // xin quyen
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();
        sqLiteDatabase.delete("car", "id=?"
                , new String[]{id});
    }
}
