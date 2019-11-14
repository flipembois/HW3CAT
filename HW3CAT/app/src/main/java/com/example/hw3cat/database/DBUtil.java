package com.example.hw3cat.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hw3cat.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class DBUtil extends SQLiteOpenHelper {
    private static final String TAG = "DBUtil";

    public DBUtil(Context context) {
        this(context, "db", null, 1);
    }

    private DBUtil(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        Name of cat breed.
//        o Image of the cat breed.
//        o Description
//        o Weight
//        o Temperament
//        o Origin
//        o Life span
//        o Wikipedia link
//        o Dog friendliness level.
        sqLiteDatabase.execSQL("create table favs(id integer primary key autoincrement,beng,name,image,Description ,Weight,Temperament ,Origin,Life,Wikipedia,friendliness)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add(Cat cat) {
        SQLiteDatabase db = getWritableDatabase();
        // database time must +8 hour for true time
        ContentValues cv = new ContentValues();
        Cat.BreedsBean breedsBean = cat.getBreeds().get(0);
        cv.put("beng", breedsBean.getId());
        cv.put("name", breedsBean.getName());
        cv.put("image", cat.getUrl());
        cv.put("name", breedsBean.getName());
        cv.put("Description", breedsBean.getDescription());
        cv.put("Weight", breedsBean.getWeight().getImperial());
        cv.put("Temperament", breedsBean.getTemperament());
        cv.put("Origin", breedsBean.getOrigin());
        cv.put("Life", breedsBean.getLife_span());
        cv.put("Wikipedia", breedsBean.getWikipedia_url());
        cv.put("friendliness", breedsBean.getDog_friendly());
        db.insert("favs", null, cv);
    }

    public void delete(Cat cat) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from favs where id=" + cat.getIndex_id());
    }

    public List<Cat> getFavs() {
        List<Cat> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from favs", new String[]{});
        while (cursor.moveToNext()) {
            Cat cat = new Cat();
            Cat.BreedsBean breedsBean = new Cat.BreedsBean();

            //beng, breed, image, Description, Weight, Temperament, Origin, Life, Wikipedia, friendliness
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String beng = cursor.getString(cursor.getColumnIndex("beng"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String image = cursor.getString(cursor.getColumnIndex("image"));
            String Description = cursor.getString(cursor.getColumnIndex("Description"));
            String Weight = cursor.getString(cursor.getColumnIndex("Weight"));
            String Temperament = cursor.getString(cursor.getColumnIndex("Temperament"));
            String Origin = cursor.getString(cursor.getColumnIndex("Origin"));
            String Life = cursor.getString(cursor.getColumnIndex("Life"));
            String Wikipedia = cursor.getString(cursor.getColumnIndex("Wikipedia"));
            int friendliness = cursor.getInt(cursor.getColumnIndex("friendliness"));
            cat.setIndex_id(id);
            cat.setUrl(image);
            breedsBean.setId(beng);
            breedsBean.setName(name);
            breedsBean.setDescription(Description);
            breedsBean.setWeight(new Cat.BreedsBean.WeightBean(Weight));
            breedsBean.setTemperament(Temperament);
            breedsBean.setOrigin(Origin);
            breedsBean.setLife_span(Life);
            breedsBean.setWikipedia_url(Wikipedia);
            breedsBean.setDog_friendly(friendliness);
            List<Cat.BreedsBean> breedsBeans = new ArrayList<>();
            breedsBeans.add(breedsBean);
            cat.setBreeds(breedsBeans);
            list.add(cat);
        }
        return list;
    }
}
