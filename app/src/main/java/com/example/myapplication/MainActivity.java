package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SqliteHelper sqliteHelper;

    private ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvList = findViewById(R.id.lvList);

        sqliteHelper = new SqliteHelper(MainActivity.this);

        DienThoai car1 = new DienThoai();
        car1.id = "1";
        car1.name = "Honde Civic";
        car1.price = "800tr";

        DienThoai car2 = new DienThoai();
        car2.id = "2";
        car2.name = "Honde Civic";
        car2.price = "800tr";

        DienThoai car3 = new DienThoai();
        car3.id = "3";
        car3.name = "Honde Civic";
        car3.price = "800tr";

        DienThoai car4 = new DienThoai();
        car4.id = "4";
        car4.name = "Honde Civic";
        car4.price = "800tr";

        DienThoaiDAO carDAO = new DienThoaiDAO(sqliteHelper);

        carDAO.themDienThoai(car1);

        carDAO.themDienThoai(car2);

        carDAO.themDienThoai(car3);

        carDAO.themDienThoai(car4);

        final List<DienThoai> carList = carDAO.danhSachCar();

        Toast.makeText(this, "" + carList.size(), Toast.LENGTH_SHORT).show();

        CarAdapter carAdapter = new CarAdapter(carList);

        lvList.setAdapter(carAdapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                Intent intent = new
                        Intent(MainActivity.this, SuaActivity.class);
                DienThoai dienThoai = carList.get(i);
                intent.putExtra("id",dienThoai.id);
                intent.putExtra("name",dienThoai.name);
                intent.putExtra("price",dienThoai.price);
                startActivity(intent);
            }
        });
    }


}