package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);

        final String id = getIntent().getStringExtra("id");

        final EditText nhapTen = findViewById(R.id.nhapName);
        final EditText nhapGia = findViewById(R.id.nhapPrice);

        Button save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SqliteHelper sqliteHelper =
                        new SqliteHelper(SuaActivity.this);
                DienThoaiDAO dienThoaiDAO =
                        new DienThoaiDAO(sqliteHelper);

                DienThoai dienThoai = new DienThoai();
                dienThoai.id = id;
                dienThoai.name = nhapTen.getText().toString();
                dienThoai.price = nhapGia.getText().toString();

                dienThoaiDAO.suaDienThoai(dienThoai);
            }
        });




    }
}