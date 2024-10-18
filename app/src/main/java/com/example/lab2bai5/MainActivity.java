package com.example.lab2bai5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private Spinner spinnerThumbnails;
    private EditText etDishName;
    private CheckBox cbPromotion;
    private Button btnAddDish;
    private List<Dish> dishList;
    private DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        spinnerThumbnails = findViewById(R.id.spinnerThumbnails);
        etDishName = findViewById(R.id.etDishName);
        cbPromotion = findViewById(R.id.cbPromotion);
        btnAddDish = findViewById(R.id.btnAddDish);

        // Tạo dữ liệu ban đầu cho GridView
        dishList = new ArrayList<>();
        dishAdapter = new DishAdapter(this, dishList);
        gridView.setAdapter(dishAdapter);

        // Tạo dữ liệu cho Spinner
        Thumbnail[] thumbnails = Thumbnail.values();
        ThumbnailAdapter thumbnailAdapter = new ThumbnailAdapter(this, thumbnails);
        spinnerThumbnails.setAdapter(thumbnailAdapter);

        // Xử lý sự kiện khi nhấn nút "ADD A NEW DISH"
        btnAddDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewDish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addNewDish() {
        // Lấy thông tin từ các trường input
        String dishName = etDishName.getText().toString().trim();
        Thumbnail selectedThumbnail = (Thumbnail) spinnerThumbnails.getSelectedItem();
        boolean promotion = cbPromotion.isChecked();

        // Kiểm tra tên món ăn không được để trống
        if (dishName.isEmpty()) {
            Toast.makeText(this, "Please enter the dish name", Toast.LENGTH_SHORT).show();
            return;
        }

        // Thêm món ăn mới vào danh sách
        Dish newDish = new Dish(dishName, selectedThumbnail.getImg(), promotion);
        dishList.add(newDish);
        dishAdapter.notifyDataSetChanged();

        // Reset các trường về trạng thái ban đầu
        etDishName.setText("");
        spinnerThumbnails.setSelection(0);
        cbPromotion.setChecked(false);

        // Hiển thị thông báo "Added successfully"
        Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT).show();
    }
}