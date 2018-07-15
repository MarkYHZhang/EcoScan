package com.markyhzhang.shad.ecoscan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;

/**
 * Created by User on 7/24/2017.
 */

public class FavouritesActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_favourites);

        findViewById(R.id.logoImg).setOnClickListener(this);
        findViewById(R.id.favourites).setOnClickListener(this);
        findViewById(R.id.shop).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logoImg) {
            finish();
        }else if (v.getId() == R.id.favourites){
            finish();
        }else if (v.getId() == R.id.shop){
            startActivity(new Intent(this,ShopActivity.class));
        }
    }
}
