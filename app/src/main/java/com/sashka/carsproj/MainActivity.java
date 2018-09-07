package com.sashka.carsproj;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();


        RecyclerView recyclerViewCategories = findViewById(R.id.recycle_view_categories);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerViewCategories.setLayoutManager(llm);

        llm.setOrientation(LinearLayoutManager.HORIZONTAL);

        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(categoriesList());
        recyclerViewCategories.setAdapter(categoriesAdapter);

        RecyclerView recyclerViewCategoryInfo = findViewById(R.id.recycle_view_category_info);
        LinearLayoutManager llmCI = new LinearLayoutManager(this);
        recyclerViewCategoryInfo.setLayoutManager(llmCI);

        llmCI.setOrientation(LinearLayoutManager.VERTICAL);

        CategoryInfoAdapter categoryInfoAdapter = new CategoryInfoAdapter(categoryInfoList());
        categoryInfoAdapter.setOnItemClickListener(categoryInfo -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("categoryInfo", categoryInfo);
            startActivity(intent);
        });
        recyclerViewCategoryInfo.setAdapter(categoryInfoAdapter);


    }

    private void setToolbar() {
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("OfferDukaan");
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    private ArrayList<Categories> categoriesList() {
        ArrayList<Categories> output = new ArrayList<>();
        output.add(new Categories(getDrawable(R.drawable.clothes), "Clothes"));
        output.add(new Categories(getDrawable(R.drawable.electronics), "Electronics"));
        output.add(new Categories(getDrawable(R.drawable.mobile), "Mobile"));
        output.add(new Categories(getDrawable(R.drawable.spa), "Spa"));
        output.add(new Categories(getDrawable(R.drawable.more), "More"));
        return output;
    }

    private ArrayList<CategoryInfo> categoryInfoList() {
        ArrayList<CategoryInfo> output = new ArrayList<>();
        output.add(new CategoryInfo(R.drawable.care_image, "Product Name999", "Store Name",
                "+48754984733", "5km away", "1 hours left"));
        output.add(new CategoryInfo(R.drawable.car_background, "Product Name", "Store Name",
                "Phone Number +8746525", "15km away", "8 hours left"));
        output.add(new CategoryInfo(R.drawable.care_image, "Product Name", "Store Name",
                "Phone Number", "2km away", "2 hours left"));
        output.add(new CategoryInfo(R.drawable.care_image, "Product Name", "Store Name",
                "Phone Number", "2km away", "2 hours left"));
        output.add(new CategoryInfo(R.drawable.care_image, "Product Name", "Store Name",
                "Phone Number", "2km away", "2 hours left"));
        return output;
    }


}
