package com.markyhzhang.shad.ecoscan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by User on 7/23/2017.
 */

public class ProductActivity extends Activity implements View.OnClickListener{

    private ImageView productImage;
    private RatingBar ratingBar;

    private TextView gasText;
    private TextView coalText;
    private TextView costText;
    private TextView energyText;
    private TextView description;
    private TextView productTitle;

    private TextView reviewA;
    private TextView reviewB;
    private TextView reviewC;

    HashMap<String, Product> db = new HashMap<String, Product>(){{
        put("00000000001",new Product(4,"refrigerator","$150/Year","507kWh/y","5Kg of coal","3L of natural gas","This product is one of the most energy efficient fridge that I bought.","Although this fridge cost a bit more, but its efficiency pays off.","This fridge does not sacrifice capacity for efficiency.","This is a 36 inch frigerator made by LG with a French style door. It is EnergyStar rated.","LG 36\" French Door Refrigerator"));
        put("00000000002",new Product(3,"stove","$100/Year","407kWh/y","3.5Kg of coal","2L of natural gas","The self-cleaning function of this oven answers to my needs very well.","It takes a long time for my burners to cool down once they are turned off.","Ce fourneau est bon, mais je m’attendais à plus.","This is a Samsung electric stove with energy efficiency certification.","Samsung 30\" Self-Clean Stove"));
        put("00000000003",new Product(2,"microwave","$50/Year","230kWh/y","2.4Kg of coal","1.3L of natural gas","I bought this about two years ago, panel broke within the first three months.","It doesn’t take a lot of time to heat up food, and it looks really good in my kitchen.","Je suis vraiment impressionné par ce produit.", "This is a budget microwave manufactured by LG with intuitive design in mind.","LG NeoChef™ Microwave"));
        put("00000000004",new Product(5,"washingmachine","$200/Year","678kWh/y","7Kg of coal","4L of natural gas","This washing machine is by far one of the best I’ve seen in a long time.","I think the pros of this washing machine are not worth the cons.","Ma facture d’électricité a diminué d’environ 15% depuis que j’utilise cette machine.", "This is one of Samsung's premium washing machines that was designed with efficiency in mind.","SAMSUNG ecobubble WM."));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        String barcode = getIntent().getStringExtra("barcode");
        Product product = db.get(barcode);

        setContentView(R.layout.activity_product);

        productImage = (ImageView) findViewById(R.id.productImage);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        gasText = (TextView) findViewById(R.id.gasText);
        coalText = (TextView) findViewById(R.id.coalText);
        costText = (TextView) findViewById(R.id.costText);
        energyText = (TextView) findViewById(R.id.energyText);
        description = (TextView) findViewById(R.id.description);
        productTitle = (TextView) findViewById(R.id.productTitle);

        reviewA = (TextView) findViewById(R.id.reviewA);
        reviewB = (TextView) findViewById(R.id.reviewb);
        reviewC = (TextView) findViewById(R.id.reviewc);

        productImage.setImageResource(getResources().getIdentifier(product.imgName, "drawable", getPackageName()));
        ratingBar.setNumStars(product.rating);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);

        gasText.setText(product.gas);
        coalText.setText(product.coal);
        costText.setText(product.cost);
        energyText.setText(product.energy);
        description.setText(product.description);
        productTitle.setText(product.title);

        reviewA.setText(product.reviewA);
        reviewB.setText(product.reviewB);
        reviewC.setText(product.reviewC);

        findViewById(R.id.logoImg).setOnClickListener(this);
        findViewById(R.id.favourites).setOnClickListener(this);
        findViewById(R.id.shop).setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logoImg) {
            finish();
        }else if (v.getId() == R.id.favourites){
            startActivity(new Intent(this,FavouritesActivity.class));
        }else if (v.getId() == R.id.shop){
            startActivity(new Intent(this,ShopActivity.class));
        }
    }
}

class Product{
    int rating;
    String imgName, gas, coal, cost, energy, reviewA, reviewB, reviewC, description, title;

    public Product(int rating, String imgName, String cost, String energy, String coal, String gas, String reviewA, String reviewB, String reviewC, String description, String title){
        this.rating = rating;
        this.imgName = imgName;
        this.gas = gas;
        this.coal = coal;
        this.cost = cost;
        this.energy = energy;
        this.reviewA = reviewA;
        this.reviewB = reviewB;
        this.reviewC = reviewC;
        this.description = description;
        this.title = title;
    }
}
