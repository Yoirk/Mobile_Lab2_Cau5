package com.example.lab2bai5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends BaseAdapter {
    private Context context;
    private List<Dish> dishList;

    public DishAdapter(Context context, List<Dish> dishList) {
        this.context = context;
        this.dishList = dishList;
    }

    @Override
    public int getCount() {
        return dishList.size();
    }

    @Override
    public Object getItem(int position) {
        return dishList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, parent, false);
        }

        // Lấy dữ liệu của món ăn hiện tại
        Dish currentDish = dishList.get(position);

        // Gán hình ảnh và tên món ăn
        ImageView dishImage = convertView.findViewById(R.id.dishImage);
        TextView dishName = convertView.findViewById(R.id.dishName);
        ImageView promotionStar = convertView.findViewById(R.id.promotionStar);

        dishImage.setImageResource(currentDish.getThumbnail());
        dishName.setText(currentDish.getName());

        // Kiểm tra xem món ăn có khuyến mãi không
        if (currentDish.isPromotion()) {
            promotionStar.setVisibility(View.VISIBLE);
        } else {
            promotionStar.setVisibility(View.GONE);
        }

        return convertView;
    }

}

