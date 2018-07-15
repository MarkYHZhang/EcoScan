package com.markyhzhang.shad.ecoscan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;

/**
 * Created by User on 7/25/2017.
 */

public class ShopActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_shop);

        findViewById(R.id.logoImg).setOnClickListener(this);
        findViewById(R.id.favourites).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logoImg) {
            finish();
        }else if (v.getId() == R.id.favourites){
            startActivity(new Intent(this,FavouritesActivity.class));
        }else if (v.getId() == R.id.shop){
            finish();
        }
    }
}
