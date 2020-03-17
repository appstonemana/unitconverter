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

public class DistanceActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;
    //private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distance_activity);
        //this.setTitle("Distance/Length");
        //getActionBar().setDisplayHomeAsUpEnabled(true);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.back_arrow); // your drawable
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed(); // Implemented by activity
//            }
//        });

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Distance/Length");

        toolbar.setLogo(R.drawable.distance_length_icon);
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

        //fromList.add("Choose");
        fromList.add("centimeter(cm)");
        fromList.add("meter(m)");
        fromList.add("kilometer(km)");
        fromList.add("inch(in)");
        fromList.add("hand(h)");
        fromList.add("foot(ft)");
        fromList.add("mile(mi)");
        fromList.add("yard(yd)");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

       // tolist.add("Choose");
        tolist.add("centimeter(cm)");
        tolist.add("meter(m)");
        tolist.add("kilometer(km)");
        tolist.add("inch(in)");
        tolist.add("hand(h)");
        tolist.add("foot(ft)");
        tolist.add("mile(mi)");
        tolist.add("yard(yd)");

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

        /*assert clearBtn != null;
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

    /*private void clear(View view) {
        from_et.setText("");
        to_et.setText("");
        tvResult.setText("");
    }*/

    public void convert(View v){

        try {
        double data = Double.parseDouble(from_et.getText().toString());
        String s1= String.valueOf(from_et.getText());

            //centimeter(cm)-->centimeter(cm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " cm = " + s + " cm");
            }

            //centimeter(cm)-->meter(m)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)")) {
                Double d= data/100;
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm = " + formattedValue + " m");
            }

            //centimeter(cm)-->kilometer(km)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)")) {
                Double d= data/100000;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm = " + formattedValue + " km");
            }

            //centimeter(cm)-->inch(in)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)")) {
                Double d= data/(2.54);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm = " + formattedValue + " in");
            }

            //centimeter(cm)-->hand(h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)")) {
                Double d= data*(0.098425);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm = " + formattedValue + " h");
            }

            //centimeter(cm)-->foot(ft)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)")) {
                Double d= data/(30.48);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm = " + formattedValue + " ft");
            }

            //centimeter(cm)-->mile(mi)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)")) {
                Double d= data*(0.000006);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm = " + formattedValue + " mi");
            }

            //centimeter(cm)-->yard(yd)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)")) {
                Double d= data/(91.44);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cm = " + formattedValue + " yd");
            }

            //meter(m)-->meter(m)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " m = " + s + " m");
            }

            //meter(m)-->centimeter(cm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data*100);
                to_et.setText(s);
                tvResult.setText(s1 + " m = " + s + " cm");
            }

            //meter(m)-->kilometer(km)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data/1000;
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m = " + formattedValue + " km");
            }

            //meter(m)-->inch(in)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(39.37);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m = " + formattedValue + " in");
            }

            //meter(m)-->hand(h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(9.84252);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m = " + formattedValue + " h");
            }

            //meter(m)-->foot(ft)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(3.28);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m = " + formattedValue + " ft");
            }

            //meter(m)-->mile(mi)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.00062);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m = " + formattedValue + " mi");
            }

            //meter(m)-->yard(yd)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(1.0936);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*100);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " m = " + formattedValue + " yd");
            }

            //kilometer(km)-->kilometer(km)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " km = " + s + " km");
            }

            //kilometer(km)-->centimeter(cm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data*100000);
                to_et.setText(s);
                tvResult.setText(s1 + " km = " + s + " cm");
            }

            //kilometer(km)-->meter(m)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " km = " + s + " m");
            }

            //kilometer(km)-->inch(in)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(39370.078);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km = " + formattedValue + " in");
            }

            //kilometer(km)-->hand(h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(9842.519);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km = " + formattedValue + " h");
            }

            //kilometer(km)-->foot(ft)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(3280.839);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km = " + formattedValue + " ft");
            }

            //kilometer(km)-->mile(mi)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("km") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.6213);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km = " + formattedValue + " mi");
            }

            //kilometer(km)-->yard(yd)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(1093.613);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " km = " + formattedValue + " yd");
            }

            //inch(in)-->inch(in)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " in = " + s + " in");
            }

            //inch(in)-->centimeter(cm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(2.54);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in = " + formattedValue + " cm");
            }

            //inch(in)-->meter(m)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.0254);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in = " + formattedValue + " m");
            }

            //inch(in)-->kilometer(km)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("inch") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.0000254);
                String formattedValue = String.format("%.7f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in = " + formattedValue + " km");
            }

            //inch(in)-->hand(h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.25);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in = " + formattedValue + " h");
            }

            //inch(in)-->foot(ft)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data/12;
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in = " + formattedValue + " ft");
            }

            //inch(in)-->mile(mi)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data/63360;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*(39370.078));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in = " + formattedValue + " mi");
            }

            //inch(in)-->yard(yd)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data/36;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/36);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " in = " + formattedValue + " yd");
            }

            //hand(h)-->hand(h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " h = " + s + " h");
            }

            //hand(h)-->centimeter(cm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(10.16);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data/36);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " h = " + formattedValue + " cm");
            }

            //hand(h)-->meter(m)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.1016);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data/36);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " h = " + formattedValue + " m");
            }

            //hand(h)-->kilometer(km)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.000102);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/36);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " h = " + formattedValue + " km");
            }

            //hand(h)-->inch(in)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data*4 ;
                String formattedValue = String.format("%.6f", d);*/
                String s = String.valueOf(data*4);
                to_et.setText(s);
                tvResult.setText(s1 + " h = " + s + " in");
            }

            //hand(h)-->foot(ft)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.3334) ;
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*4);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " h = " + formattedValue + " ft");
            }

            //hand(h)-->mile(mi)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.000063) ;
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*4);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " h = " + formattedValue + " mi");
            }

            //hand(h)-->yard(yd)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)")) {
                //to_et.setText(String.valueOf(data));
                Double d= (data*4)/36 ;
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*4);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " h = " + formattedValue + " yd");
            }

            //foot(ft)-->foot(ft)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " ft = " + s + " ft");
            }

            //foot(ft)-->centimeter(cm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(30.48);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data*4);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft = " + formattedValue + " cm");
            }

            //foot(ft)-->meter(m)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.3048);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*4);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft = " + formattedValue + " m");
            }

            //foot(ft)-->kilometer(km)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.0003048);
                String formattedValue = String.format("%.7f", d);
                //String s = String.valueOf(data*4);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft = " + formattedValue + " km");
            }

            //foot(ft)-->inch(in)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data*12;
                String formattedValue = String.format("%.7f", d);*/
                String s = String.valueOf(data*12);
                to_et.setText(s);
                tvResult.setText(s1 + " ft = " + s + " in");
            }

            //foot(ft)-->hand(h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data*12;
                String formattedValue = String.format("%.7f", d);*/
                String s = String.valueOf(data*3);
                to_et.setText(s);
                tvResult.setText(s1 + " ft = " + s + " h");
            }

            //foot(ft)-->mile(mi)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.000189);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*3);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft = " + formattedValue + " mi");
            }

            //foot(ft)-->yard(yd)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.3334);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*3);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " ft = " + formattedValue + " yd");
            }

            //mile(mi)-->mile(mi)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mi = " + s + " mi");
            }

            //mile(mi)-->centimeter(cm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(160934.4);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data*3);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mi = " + formattedValue + " cm");
            }

            //mile(mi)-->meter(m)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(1609.344);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*3);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mi = " + formattedValue + " m");
            }

            //mile(mi)-->kilometer(km)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(1.609);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*3);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mi = " + formattedValue + " km");
            }

            //mile(mi)-->inch(in)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data*(6336);
                String formattedValue = String.format("%.3f", d);*/
                String s = String.valueOf(data*63360);
                to_et.setText(s);
                tvResult.setText(s1 + " mi = " + s + " in");
            }

            //mile(mi)-->hand(h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data*(6336);
                String formattedValue = String.format("%.3f", d);*/
                String s = String.valueOf(data*15840);
                to_et.setText(s);
                tvResult.setText(s1 + " mi = " + s + " h");
            }

            //mile(mi)-->foot(ft)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data*(6336);
                String formattedValue = String.format("%.3f", d);*/
                String s = String.valueOf(data*5280);
                to_et.setText(s);
                tvResult.setText(s1 + " mi = " + s + " ft");
            }

            //mile(mi)-->yard(yd)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data*(6336);
                String formattedValue = String.format("%.3f", d);*/
                String s = String.valueOf(data*1760);
                to_et.setText(s);
                tvResult.setText(s1 + " mi = " + s + " yd");
            }

            //yard(yd)-->yard(yd)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)")) {
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " yd = " + s + " yd");
            }

            //yard(yd)-->centimeter(cm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centimeter(cm)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(91.44);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd = " + formattedValue + " cm");
            }

            //yard(yd)-->meter(m)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter(m)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.9144);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd = " + formattedValue + " m");
            }

            //yard(yd)-->kilometer(km)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer(km)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.0009144);
                String formattedValue = String.format("%.7f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd = " + formattedValue + " km");
            }

            //yard(yd)-->inch(in)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("inch(in)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data;
                String formattedValue = String.format("%.7f", d);*/
                String s = String.valueOf(data*36);
                to_et.setText(s);
                tvResult.setText(s1 + " yd = " + s + " in");
            }

            //yard(yd)-->hand(h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hand(h)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data;
                String formattedValue = String.format("%.7f", d);*/
                String s = String.valueOf(data*9);
                to_et.setText(s);
                tvResult.setText(s1 + " yd = " + s + " h");
            }

            //yard(yd)-->foot(ft)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("foot(ft)")) {
                //to_et.setText(String.valueOf(data));
                /*Double d= data;
                String formattedValue = String.format("%.7f", d);*/
                String s = String.valueOf(data*3);
                to_et.setText(s);
                tvResult.setText(s1 + " yd = " + s + " ft");
            }

            //yard(yd)-->mile(mi)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("yard(yd)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile(mi)")) {
                //to_et.setText(String.valueOf(data));
                Double d= data*(0.00057);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " yd = " + formattedValue + " mi");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
