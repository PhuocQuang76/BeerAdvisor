package com.androiddev.beeradvisor;
import java.util.List;
import java.lang.StringBuffer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
    private BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //tell that they use activity_main as it layout
    }


    public void onClickFindBeer(View view) {
        //Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        //Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        //Get the selected item in the Spinner
        String beerType =  String.valueOf(color.getSelectedItem());

        //Display the selected item
        brands.setText(beerType);

        //Get recomended from the Beer Expert class
        List<String> brandList = expert.getBrands(beerType);
        StringBuffer stringBuffer = new StringBuffer();
        for(String brand:brandList){
            stringBuffer.append(brand).append('\n');
        }
        brands.setText(stringBuffer);

    }
}


