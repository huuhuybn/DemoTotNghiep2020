package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends BaseAdapter {

    private List<DienThoai> carList;

    public CarAdapter(List<DienThoai> carList) {
        this.carList = carList;
    }

    @Override
    public int getCount() {
        return carList.size();
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item,
                        viewGroup, false);

        TextView tvContent = view.findViewById(R.id.textView);

        final DienThoai car = carList.get(i);

        tvContent.setText(car.id + "-" + car.name + "-" + car.price);

        tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SqliteHelper sqliteHelper =
                        new SqliteHelper(viewGroup.getContext());
                DienThoaiDAO dienThoaiDAO =
                        new DienThoaiDAO(sqliteHelper);

                dienThoaiDAO.xoa(car.id);
            }
        });

        return view;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
