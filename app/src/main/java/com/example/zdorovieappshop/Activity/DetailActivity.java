package com.example.zdorovieappshop.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zdorovieappshop.Adapter.SimilarAdapter;
import com.example.zdorovieappshop.Domain.ItemsDomain;
import com.example.zdorovieappshop.R;

public class DetailActivity extends AppCompatActivity {
    private ItemsDomain object;
    private ImageView backBtn, itemImg;
    private TextView priceKg, titleTxt, descriptionTxt, ratingTxt;
    private RatingBar ratingBar;
    private TextView weightTxt, plusBtn, minusBtn, totalTxt;
    private int weight = 1;
    private RecyclerView.Adapter similarAdapter;
    private RecyclerView recyclerViewSimilar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getBundles();
        initView();
        setVariable();
        setViewsWithData();
        initSimilarList();
    }

    private void initSimilarList() {
        recyclerViewSimilar=findViewById(R.id.similarView);
        recyclerViewSimilar.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        similarAdapter = new SimilarAdapter(new MainActivity().getData());
        recyclerViewSimilar.setAdapter(similarAdapter);
    }

    private void setViewsWithData() {
        int drawableResourceId = getResources().getIdentifier(object.getImgPath(), "drawable", DetailActivity.this.getPackageName());
        Glide.with(DetailActivity.this)
                .load(drawableResourceId)
                .into(itemImg);
        priceKg.setText(object.getPrice() + "₽/кг");
        titleTxt.setText(object.getTitle());
        descriptionTxt.setText(object.getDescription());
        ratingTxt.setText("(" + object.getRate() + ")");
        ratingBar.setRating((float) object.getRate());
        totalTxt.setText((weight * object.getPrice()) + "₽");
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = weight + 1;
                weightTxt.setText(weight + " центеров");
                totalTxt.setText((weight * object.getPrice()) + "₽");
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weight > 1) {
                    weight = weight - 1;
                    weightTxt.setText(weight + " кг");
                    totalTxt.setText((weight * object.getPrice()) + "₽");
                }
            }
        });
    }

    private void setVariable() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                int drawableResourceId = getResources().getIdentifier(object.getImgPath(), "drawable", DetailActivity.this.getPackageName());
                Glide.with(DetailActivity.this)
                        .load(drawableResourceId)
                        .into(itemImg);
                priceKg.setText(object.getPrice() + "₽/кг");
                titleTxt.setText(object.getTitle());
                descriptionTxt.setText(object.getDescription());
                ratingTxt.setText("(" + object.getRate() + ")");
                ratingBar.setRating((float) object.getRate());
                totalTxt.setText((weight * object.getPrice()) + "₽");
                plusBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight = weight + 1;
                        weightTxt.setText(weight + " кг");
                        totalTxt.setText((weight * object.getPrice()) + "₽");
                    }
                });
                minusBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (weight > 1) {
                            weight = weight - 1;
                            weightTxt.setText(weight + " кг");
                            totalTxt.setText((weight * object.getPrice()) + "₽");
                        }
                    }
                });
            }
        });
    }

    private void initView() {
        backBtn = findViewById(R.id.backBtn);
        itemImg = findViewById(R.id.img34);
        priceKg = findViewById(R.id.priceKgTxt);
        titleTxt = findViewById(R.id.titleTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        ratingBar = findViewById(R.id.ratingBar);
        ratingTxt = findViewById(R.id.ratingTxt);
        weightTxt = findViewById(R.id.weightTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusTxt);
        totalTxt = findViewById(R.id.TotalTxt);
    }

    private void getBundles() {
        object = (ItemsDomain) getIntent().getSerializableExtra("object");
    }
}
