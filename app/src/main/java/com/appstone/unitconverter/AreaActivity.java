package com.appstone.unitconverter;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AreaActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_activity);
        //this.setTitle("Area");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Area");

        toolbar.setLogo(R.drawable.area_icon);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        from_et= (EditText) findViewById(R.id.from_et);
        to_et= (EditText) findViewById(R.id.to_et);
        from_spinner= (Spinner) findViewById(R.id.from_spinner);
        to_spinner= (Spinner) findViewById(R.id.to_spinner);
        convertBtn= (Button) findViewById(R.id.button);
        //clearBtn= (Button) findViewById(R.id.clearBtn);
        tvResult= (TextView) findViewById(R.id.tvResult);

        ArrayList<String> fromList =new ArrayList<>();
        fromList.clear();

        //fromList.add("square_decimeter(dm²)");
        fromList.add("square_centimeter(cm²)");
        fromList.add("square_meter(m²)");
        fromList.add("square_kilometer(km²)");
        fromList.add("acre");
        fromList.add("square_inch(in²)");
        fromList.add("square_foot(ft²)");
        fromList.add("square_yard(yd²)");
        fromList.add("square_mile(mile²)");
        fromList.add("Gunta");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        //tolist.add("square_decimeter(dm²)");
        tolist.add("square_centimeter(cm²)");
        tolist.add("square_meter(m²)");
        tolist.add("square_kilometer(km²)");
        tolist.add("acre");
        tolist.add("square_inch(in²)");
        tolist.add("square_foot(ft²)");
        tolist.add("square_yard(yd²)");
        tolist.add("square_mile(mile²)");
        tolist.add("Gunta");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,tolist);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        to_spinner.setAdapter(adapter);

        assert convertBtn != null;
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert(v);
            }
        });

       /* assert clearBtn != null;
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear(view);
            }
        });
*/
    }//onCreate(Bundle savedInstanceState)

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String msg="";

        switch (item.getItemId()){

            case R.id.refresh:
                from_et.setText("");
                to_et.setText("");
                tvResult.setText("");
                msg="Refreshed";
                break;
        }
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }

   /* private void clear(View view) {
        from_et.setText("");
        to_et.setText("");
        tvResult.setText("");
    }*/

    public void convert(View v){

        try {
            double data = Double.parseDouble(from_et.getText().toString());
            String s1= String.valueOf(from_et.getText());
            Double d1= Double.valueOf(1000*1000);
            Double d2= d1*10000;

            //square_centimeter(cm²)-->square_centimeter(cm²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " cm² = " + s + " cm²");
            }

            //square_centimeter(cm²)-->square_meter(m²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)")) {
                Double d= data*(0.0001);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm² = " + formattedValue + " m²");
            }

            //square_centimeter(cm²)-->square_kilometer(km²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)")) {
                Double d= data/d2;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm² = " + formattedValue + " km²");
            }

            //square_centimeter(cm²)-->acre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("acre")) {
                Double d= data/(40468564.224);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm² = " + formattedValue + " acre");
            }

            //square_centimeter(cm²)-->square_inch(in²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)")) {
                Double d= data*(0.155);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm² = " + formattedValue + " in²");
            }

            //square_centimeter(cm²)-->square_foot(ft²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)")) {
                Double d= data*(0.001076);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm² = " + formattedValue + " ft²");
            }

            //square_centimeter(cm²)-->square_yard(yd²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)")) {
                Double d= data*(0.00011960);
                String formattedValue = String.format("%.8f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm² = " + formattedValue + " yd²");
            }

            //square_centimeter(cm²)-->square_mile(mile²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)")) {
                Double d= data*((0.386102)/d2);
                String formattedValue = String.format("%.9f", d);
                //String s = String.valueOf(d);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm² = " + formattedValue + " mile²");
            }

            //square_centimeter(cm²)-->Gunta
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta")) {
                Double d= data/(1011700.3141);
                String formattedValue = String.format("%.9f", d);
                //String s = String.valueOf(d);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm² = " + formattedValue + " Gunta");
            }

            //square_meter(m²)-->square_meter(m²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " m² = " + s + " m²");
            }

            //square_meter(m²)-->square_centimeter(cm²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)")) {
                String s = String.valueOf(data*10000);
                to_et.setText(s);
                tvResult.setText(s1 + " m² = " + s + " cm²");
            }

            //square_meter(m²)-->square_kilometer(km²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)")) {
                String s = String.valueOf(data/d1);
                to_et.setText(s);
                tvResult.setText(s1 + " m² = " + s + " km²");
            }

            //square_meter(m²)-->acre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("acre")) {
                Double d= data*(0.000247);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*(0.000247));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m² = " + formattedValue + " acre");
            }

            //square_meter(m²)-->square_inch(in²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)")) {
                Double d= data*(1550.0031);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*(0.000247));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m² = " + formattedValue + " in²");
            }

            //square_meter(m²)-->square_foot(ft²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)")) {
                Double d= data*(10.76391);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*(0.000247));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m² = " + formattedValue + " ft²");
            }

            //square_meter(m²)-->square_yard(yd²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)")) {
                Double d= data*(1.19599);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*(0.000247));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m² = " + formattedValue + " yd²");
            }

            //square_meter(m²)-->square_mile(mile²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)")) {
                Double d= data*(0.00000038610);
                String formattedValue = String.format("%.9f", d);
                //String s = String.valueOf(data*(0.000247));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m² = " + formattedValue + " mile²");
            }

            //square_meter(m²)-->Gunta
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta")) {
                Double d= data*(0.009884);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*(0.000247));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m² = " + formattedValue + " Gunta");
            }

            //square_kilometer(km²)-->square_kilometer(km²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " km² = " + s + " km²");
            }

            //square_kilometer(km²)-->square_centimeter(cm²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)")) {
                String s = String.valueOf(data*d2*10);
                to_et.setText(s);
                tvResult.setText(s1 + " km² = " + s + " cm²");
            }

            //square_kilometer(km²)-->square_meter(m²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)")) {
                String s = String.valueOf(data*d1);
                to_et.setText(s);
                tvResult.setText(s1 + " km² = " + s + " m²");
            }

            //square_kilometer(km²)-->acre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("acre")) {
                Double d= data*(247.105381);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*(247.105381));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km² = " + formattedValue + " acre");
            }

            //square_kilometer(km²)-->square_inch(in²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)")) {
                /*Double d= data*(15500031);
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*1550003100);
                to_et.setText(s);
                tvResult.setText(s1 + " km² = " + s + " in²");
            }

            //square_kilometer(km²)-->square_foot(ft²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)")) {
                Double d= data*(10763910.4);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data*1550003100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km² = " + formattedValue + " ft²");
            }

            //square_kilometer(km²)-->square_yard(yd²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)")) {
                Double d= data*(1195990.05);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data*1550003100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km² = " + formattedValue + " yd²");
            }

            //square_kilometer(km²)-->square_mile(mile²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)")) {
                Double d= data*(0.386102);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*1550003100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km² = " + formattedValue + " mile²");
            }

            //square_kilometer(km²)-->Gunta
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta")) {
                Double d= data*(9884.215);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*1550003100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km² = " + formattedValue + " Gunta");
            }

            //acre-->acre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("acre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("acre")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " acre = " + s + " acre");
            }

            //acre-->square_centimeter(cm²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("acre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)")) {
                Double d= data*(40468564.224);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " acre = " + formattedValue + " cm²");
            }

            //acre-->square_meter(m²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("acre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)")) {
                Double d= data*(4046.856);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " acre = " + formattedValue + " m²");
            }

            //acre-->square_kilometer(km²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("acre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)")) {
                Double d= data*(0.004047);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " acre = " + formattedValue + " km²");
            }

            //acre-->square_inch(in²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("acre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)")) {
                /*Double d= data*(6272640);
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*6272640);
                to_et.setText(s);
                tvResult.setText(s1 + " acre = " + s + " in²");
            }

            //acre-->square_foot(ft²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("acre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)")) {
                /*Double d= data*(6272640);
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*43560);
                to_et.setText(s);
                tvResult.setText(s1 + " acre = " + s + " ft²");
            }

            //acre-->square_yard(yd²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("acre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)")) {
                /*Double d= data*(6272640);
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*4840);
                to_et.setText(s);
                tvResult.setText(s1 + " acre = " + s + " yd²");
            }

            //acre-->square_mile(mile²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("acre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)")) {
                Double d= data*(0.001563);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*4840);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " acre = " + formattedValue + " mile²");
            }

            //acre-->Gunta
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("acre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta")) {
                /*Double d= data*(0.001563);
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*40);
                to_et.setText(s);
                tvResult.setText(s1 + " acre = " + s + " Gunta");
            }

            //square_inch(in²)-->square_inch(in²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " in² = " + s + " in²");
            }

            //square_inch(in²)-->square_centimeter(cm²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)")) {
                Double d= data*(6.4516);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*6.4516);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in² = " + formattedValue + " cm²");
            }

            //square_inch(in²)-->square_meter(m²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)")) {
                Double d= data/(1550.0031);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*6.4516);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in² = " + formattedValue + " m²");
            }

            //square_inch(in²)-->square_kilometer(km²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)")) {
                Double d= data/(15500031);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*6.4516);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in² = " + formattedValue + " km²");
            }

            //square_inch(in²)-->acre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("acre")) {
                Double d= data/(6272640);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*6.4516);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in² = " + formattedValue + " acre");
            }

            //square_inch(in²)-->square_foot(ft²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)")) {
                Double d= data/(144);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*6.4516);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in² = " + formattedValue + " ft²");
            }

            //square_inch(in²)-->square_yard(yd²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)")) {
                Double d= data/(1296);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*6.4516);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in² = " + formattedValue + " yd²");
            }

            //square_inch(in²)-->square_mile(mile²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)")) {
                Double d= data/(40144896);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*6.4516);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in² = " + formattedValue + " mile²");
            }

            //square_inch(in²)-->Gunta
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta")) {
                Double d= data/(156813.86);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*6.4516);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in² = " + formattedValue + " Gunta");
            }


            //square_foot(ft²)-->square_foot(ft²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " ft² = " + s + " ft²");
            }

            //square_foot(ft²)-->square_centimeter(cm²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)")) {
                Double d= data*(929.0304);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft² = " + formattedValue + " cm²");
            }

            //square_foot(ft²)-->square_meter(m²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)")) {
                Double d= data*(0.092903);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft² = " + formattedValue + " m²");
            }

            //square_foot(ft²)-->square_kilometer(km²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)")) {
                Double d= data/(10763910.4);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft² = " + formattedValue + " km²");
            }

            //square_foot(ft²)-->acre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("acre")) {
                Double d= data/43560;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft² = " + formattedValue + " acre");
            }

            //square_foot(ft²)-->square_inch(in²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)")) {
                Double d= data*144;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft² = " + formattedValue + " in²");
            }

            //square_foot(ft²)-->square_yard(yd²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)")) {
                Double d= data/9;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft² = " + formattedValue + " yd²");
            }

            //square_foot(ft²)-->square_mile(mile²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)")) {
                Double d= data/(27878400);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft² = " + formattedValue + " mile²");
            }

            //square_foot(ft²)-->Gunta
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta")) {
                Double d= data/1089;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft² = " + formattedValue + " Gunta");
            }

            //square_yard(yd²)-->square_yard(yd²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " yd² = " + s + " yd²");
            }

            //square_yard(yd²)-->square_centimeter(cm²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)")) {
                Double d= data*(8361.2736);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd² = " + formattedValue + " cm²");
            }

            //square_yard(yd²)-->square_meter(m²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)")) {
                Double d= data*(0.836127);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd² = " + formattedValue + " m²");
            }

            //square_yard(yd²)-->square_kilometer(km²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)")) {
                Double d= data/(1195990.04);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd² = " + formattedValue + " km²");
            }

            //square_yard(yd²)-->acre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("acre")) {
                Double d= data/4840;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd² = " + formattedValue + " acre");
            }

            //square_yard(yd²)-->square_inch(in²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)")) {
                /*Double d= data*1296;
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*1296);
                to_et.setText(s);
                tvResult.setText(s1 + " yd² = " + s + " in²");
            }

            //square_yard(yd²)-->square_foot(ft²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)")) {
                /*Double d= data*9;
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*9);
                to_et.setText(s);
                tvResult.setText(s1 + " yd² = " + s + " ft²");
            }

            //square_yard(yd²)-->square_mile(mile²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)")) {
                Double d= data/3097600;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*9);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd² = " + formattedValue + " mile²");
            }

            //square_yard(yd²)-->Gunta
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta")) {
                Double d= data/121;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*9);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd² = " + formattedValue + " Gunta");
            }

            //square_mile(mile²)-->square_mile(mile²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mile² = " + s + " mile²");
            }

            //square_mile(mile²)-->square_centimeter(cm²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)")) {
                String s = String.valueOf(data*258998811);
                to_et.setText(s);
                tvResult.setText(s1 + " mile² = " + s + " cm²");
            }

            //square_mile(mile²)-->square_meter(m²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)")) {
                Double d= data*(2589988.11);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data*258998811);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mile² = " + formattedValue + " m²");
            }

            //square_mile(mile²)-->square_kilometer(km²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)")) {
                Double d= data*(2.589988);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*258998811);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mile² = " + formattedValue + " km²");
            }

            //square_mile(mile²)-->acre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("acre")) {
                /*Double d= data*(2.589988);
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*640);
                to_et.setText(s);
                tvResult.setText(s1 + " mile² = " + s + " acre");
            }

            //square_mile(mile²)-->square_inch(in²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)")) {
                /*Double d= data*(2.589988);
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*40144896);
                to_et.setText(s);
                tvResult.setText(s1 + " mile² = " + s + " in²");
            }

            //square_mile(mile²)-->square_foot(ft²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)")) {
                /*Double d= data*(2.589988);
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*27878400);
                to_et.setText(s);
                tvResult.setText(s1 + " mile² = " + s + " ft²");
            }

            //square_mile(mile²)-->square_yard(yd²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)")) {
                /*Double d= data*(2.589988);
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*3097600);
                to_et.setText(s);
                tvResult.setText(s1 + " mile² = " + s + " yd²");
            }

            //square_mile(mile²)-->Gunta
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta")) {
                Double d= data*(25600.349);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*25600.349);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mile² = " + formattedValue + " Gunta");
            }

            //Gunta-->Gunta
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Gunta = " + s + " Gunta");
            }

            //Gunta-->square_centimeter(cm²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_centimeter(cm²)")) {
                Double d= data*(1011714.11);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Gunta = " + formattedValue + " cm²");
            }

            //Gunta-->square_meter(m²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_meter(m²)")) {
                Double d= data*(101.171411);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Gunta = " + formattedValue + " m²");
            }

            //Gunta-->square_kilometer(km²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_kilometer(km²)")) {
                Double d= data/(9884.215);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Gunta = " + formattedValue + " km²");
            }

            //Gunta-->acre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("acre")) {
                Double d= data/40;
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Gunta = " + formattedValue + " acre");
            }

            //Gunta-->square_inch(in²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_inch(in²)")) {
                Double d= data*(156816);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Gunta = " + formattedValue + " in²");
            }

            //Gunta-->square_foot(ft²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_foot(ft²)")) {
                Double d= data*1089;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Gunta = " + formattedValue + " ft²");
            }

            //Gunta-->square_yard(yd²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_yard(yd²)")) {
                Double d= data*121;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Gunta = " + formattedValue + " yd²");
            }

            //Gunta-->square_mile(mile²)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gunta") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("square_mile(mile²)")) {
                Double d= data/(25600.349);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Gunta = " + formattedValue + " mile²");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
