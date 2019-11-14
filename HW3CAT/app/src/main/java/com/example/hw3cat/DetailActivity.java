package com.example.hw3cat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hw3cat.database.DBUtil;
import com.example.hw3cat.model.Cat;

public class DetailActivity extends AppCompatActivity {


    DBUtil db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Cat cat = (Cat) getIntent().getExtras().getSerializable("cat");
        Cat.BreedsBean breedsBean = cat.getBreeds().get(0);
        db = new DBUtil(this);
        Glide.with(this).load(cat.getUrl()).into(((ImageView) findViewById(R.id.iv_img)));
        ((TextView) findViewById(R.id.tv_name)).setText(breedsBean.getId() + "-" + breedsBean.getName());
        ((TextView) findViewById(R.id.tv_description)).setText(breedsBean.getDescription());
        ((TextView) findViewById(R.id.tv_weight)).setText(breedsBean.getWeight().getImperial());
        ((TextView) findViewById(R.id.tv_tem)).setText(breedsBean.getTemperament());
        ((TextView) findViewById(R.id.tv_origin)).setText(breedsBean.getOrigin());
        ((TextView) findViewById(R.id.tv_life)).setText(breedsBean.getLife_span());
        ((TextView) findViewById(R.id.tv_wiki)).setText(breedsBean.getWikipedia_url());
        ((TextView) findViewById(R.id.tv_level)).setText(breedsBean.getDog_friendly() + "");
        if (cat.getIndex_id() == null) {
            ((ImageView) findViewById(R.id.iv_unfav)).setImageResource(R.drawable.ic_favorite_border_black_24dp);

            findViewById(R.id.iv_unfav).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(DetailActivity.this, "Add Fav Success", Toast.LENGTH_SHORT).show();
                    ((ImageView) findViewById(R.id.iv_unfav)).setImageResource(R.drawable.ic_favorite_black_24dp);
                    db.add(cat);
                }
            });
        } else {

            findViewById(R.id.iv_unfav).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(DetailActivity.this, "Remove Success", Toast.LENGTH_SHORT).show();
                    ((ImageView) findViewById(R.id.iv_unfav)).setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    db.delete(cat);
                }
            });
        }
    }
}
