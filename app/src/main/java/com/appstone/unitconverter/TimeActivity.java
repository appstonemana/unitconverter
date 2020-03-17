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

public class TimeActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_activity);
        //this.setTitle("Time");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Time");

        toolbar.setLogo(R.drawable.time_icon);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        from_et= (EditText) findViewById(R.id.from_et);
        to_et= (EditText) findViewById(R.id.to_et);

       /* int maxLength = 3;
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(maxLength);
        to_et.setFilters(FilterArray);*/

        from_spinner= (Spinner) findViewById(R.id.from_spinner);
        to_spinner= (Spinner) findViewById(R.id.to_spinner);
        convertBtn= (Button) findViewById(R.id.button);
        //clearBtn= (Button) findViewById(R.id.clearBtn);
        tvResult= (TextView) findViewById(R.id.tvResult);

        ArrayList<String> fromList =new ArrayList<>();
        fromList.clear();

        fromList.add("miliseconds");
        fromList.add("seconds");
        fromList.add("minutes");
        fromList.add("hours");
        fromList.add("days");
        fromList.add("weeks");
        fromList.add("months");
        fromList.add("years");
        fromList.add("centuries");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("miliseconds");
        tolist.add("seconds");
        tolist.add("minutes");
        tolist.add("hours");
        tolist.add("days");
        tolist.add("weeks");
        tolist.add("months");
        tolist.add("years");
        tolist.add("centuries");

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

            //convert to ms
            Double onemin_ms= Double.valueOf(60*1000);
            Double onehour_ms= (60*onemin_ms);
            Double oneday_ms= (24*onehour_ms);
            Double oneweek_ms= (7*oneday_ms);
            Double onemonth_ms= (4.345238*oneweek_ms);
            Double oneyear_ms= (12*onemonth_ms);
            Double onecentury_ms= (100*oneyear_ms);

            //convert to sec
            Double onehour_sec= Double.valueOf(60*60);
            Double oneday_sec= (24*onehour_sec);
            Double oneweek_sec= (7*oneday_sec);
            Double onemonth_sec= (4.345238*oneweek_sec);
            Double oneyear_sec= (12*onemonth_sec);
            Double onecentury_sec= (100*oneyear_sec);

            //convert to minute
            Double oneday_min= Double.valueOf(24*60);
            Double oneweek_min= (7*oneday_min);
            Double onemonth_min= (4.345238*oneweek_min);
            Double oneyear_min= (12*onemonth_min);
            Double onecentury_min= (100*oneyear_min);

            //convert to hour
            Double oneweek_hr= Double.valueOf(7*24);
            Double onemonth_hr= (4.345238*oneweek_hr);
            Double oneyear_hr= (12*onemonth_hr);
            Double onecentury_hr= (100*oneyear_hr);

            //convert to day
            Double onemonth_day= (4.345238*7);
            Double oneyear_day= (12*onemonth_day);
            Double onecentury_day= (100*oneyear_day);

            //convert to week
            Double oneyear_week= (12*4.345238);
            Double onecentury_week= (100*oneyear_week);

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " miliseconds = " + s + " miliseconds");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " seconds = " + s + " seconds");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " minutes = " + s + " minutes");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hours") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hours")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " hours = " + s + " hours");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("days") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("days")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " days = " + s + " days");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " weeks = " + s + " weeks");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("months") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("months")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " months = " + s + " months");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("years") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("years")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " years = " + s + " years");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " centuries = " + s + " centuries");
            }

            //milliseconds-->seconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds")) {
                String s = String.valueOf(data/1000);
                to_et.setText(s);
                tvResult.setText(s1 + " miliseconds = " + s + " seconds");
            }

            //milliseconds-->minutes
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes")) {
                Double d= data/onemin_ms;
                String formatedValue= String.format("%.6f",d);
                //String s = String.valueOf(data/onemin_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " miliseconds = " + formatedValue + " minutes");
            }

            //milliseconds-->hours
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hours")) {
                Double d= data/onehour_ms;
                String formatedValue= String.format("%.6f",d);
                //String s = String.valueOf(data/onehour_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " miliseconds = " + formatedValue + " hours");
            }

            //milliseconds-->days
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("days")) {
                Double d= data/oneday_ms;
                String formatedValue= String.format("%.6f",d);
                //String s = String.valueOf(data/oneday_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " miliseconds = " + formatedValue + " days");
            }

            //milliseconds-->weeks
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks")) {
                Double d= data/oneweek_ms;
                String formatedValue= String.format("%.6f",d);
                //String s = String.valueOf(data/oneweek_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " miliseconds = " + formatedValue + " weeks");
            }

            //milliseconds-->months
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("months")) {
                Double d= data/onemonth_ms;
                String formatedValue= String.format("%.6f",d);
                //String s = String.valueOf(data/onemonth_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " miliseconds = " + formatedValue + " months");
            }

            //milliseconds-->years
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("years")) {
                Double d= data/oneyear_ms;
                String formatedValue= String.format("%.6f",d);
                //String s = String.valueOf(data/oneyear_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " miliseconds = " + formatedValue + " years");
            }

            //milliseconds-->centuries
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries")) {
                Double d= data/onecentury_ms;
                String formatedValue= String.format("%.6f",d);
                //String s = String.valueOf(data/onecentury_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " miliseconds = " + formatedValue + " centuries");
            }

            //seconds-->miliseconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " seconds = " + s + " miliseconds");
            }

            //seconds-->minutes
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes")) {
                String s = String.valueOf(data/60);
                to_et.setText(s);
                tvResult.setText(s1 + " seconds = " + s + " minutes");
            }

            //seconds-->hours
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hours")) {
                Double d= data/onehour_sec;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/onehour_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " seconds = " + formatedValue + " hours");
            }

            //seconds-->days
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("days")) {
                Double d= data/oneday_sec;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneday_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " seconds = " + formatedValue + " days");
            }

            //seconds-->weeks
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks")) {
                Double d= data/oneweek_sec;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneweek_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " seconds = " + formatedValue + " weeks");
            }

            //seconds-->months
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("months")) {
                Double d= data/onemonth_sec;
                String formatedValue = String.format("%.6f", d);
               // String s = String.valueOf(data/onemonth_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " seconds = " + formatedValue + " months");
            }

            //seconds-->years
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("years")) {
                Double d= data/oneyear_sec;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneyear_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " seconds = " + formatedValue + " years");
            }

            //seconds-->century
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries")) {
                Double d= data/onecentury_sec;
                String formatedValue = String.format("%.6f", d);
                String s = String.valueOf(data/onecentury_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " seconds = " + formatedValue + " centuries");
            }

            //minutes-->miliseconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds")) {
                String s = String.valueOf(data*onemin_ms);
                to_et.setText(s);
                tvResult.setText(s1 + " minutes = " + s + " miliseconds");
            }

            //minutes-->seconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds")) {
                String s = String.valueOf(data*60);
                to_et.setText(s);
                tvResult.setText(s1 + " minutes = " + s + " seconds");
            }

            //minutes-->hours
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hours")) {
                Double d= data/60;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/60);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " minutes = " + formatedValue + " hours");
            }

            //minutes-->days
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("days")) {
                Double d= data/oneday_min;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneday_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " minutes = " + formatedValue + " days");
            }

            //minutes-->weeks
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks")) {
                Double d= data/oneweek_min;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneweek_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " minutes = " + formatedValue + " weeks");
            }

            //minutes-->months
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("months")) {
                Double d= data/onemonth_min;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/onemonth_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " minutes = " + formatedValue + " months");
            }

            //minutes-->years
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("years")) {
                Double d= data/oneyear_min;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneyear_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " minutes = " + formatedValue + " years");
            }

            //minutes-->centuries
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries")) {
                Double d= data/onecentury_min;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/onecentury_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " minutes = " + formatedValue + " centuries");
            }

            //hours-->miliseconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hours") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds")) {
                String s = String.valueOf(data*onehour_ms);
                to_et.setText(s);
                tvResult.setText(s1 + " hours = " + s + " miliseconds");
            }

            //hours-->seconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hours") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds")) {
                String s = String.valueOf(data*onehour_sec);
                to_et.setText(s);
                tvResult.setText(s1 + " hours = " + s + " seconds");
            }

            //hours-->minutes
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hours") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes")) {
                String s = String.valueOf(data*60);
                to_et.setText(s);
                tvResult.setText(s1 + " hours = " + s + " minutes");
            }

            //hours-->days
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hours") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("days")) {
                Double d= data/24;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/24);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " hours = " + formatedValue + " days");
            }

            //hours-->weeks
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hours") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks")) {
                Double d= data/oneweek_hr;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneweek_hr);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " hours = " + formatedValue + " weeks");
            }

            //hours-->months
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hours") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("months")) {
                Double d= data/onemonth_hr;
                String formatedValue = String.format("%.6f", d);
                String s = String.valueOf(data/onemonth_hr);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " hours = " + formatedValue + " months");
            }

            //hours-->years
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hours") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("years")) {
                Double d= data/oneyear_hr;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneyear_hr);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " hours = " + formatedValue + " years");
            }

            //hours-->centuries
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("hours") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries")) {
                Double d= data/onecentury_hr;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/onecentury_hr);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " hours = " + formatedValue + " centuries");
            }

            //days-->miliseconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("days") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds")) {
                Double d= data*oneday_ms;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneday_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " days = " + formatedValue + " miliseconds");
            }

            //days-->seconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("days") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds")) {
                Double d= data*oneday_sec;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneday_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " days = " + formatedValue + " seconds");
            }

            //days-->minutes
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("days") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes")) {
                Double d= data*oneday_min;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneday_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " days = " + formatedValue + " minutes");
            }

            //days-->hours
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("days") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hours")) {
                Double d= data*24;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*24);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " days = " + formatedValue + " hours");
            }

            //days-->weeks
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("days") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks")) {
                Double d= data/7;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/7);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " days = " + formatedValue + " weeks");
            }

            //days-->months
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("days") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("months")) {
                Double d= data/onemonth_day;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/onemonth_day);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " days = " + formatedValue + " months");
            }

            //days-->years
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("days") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("years")) {
                Double d= data/oneyear_day;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneyear_day);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " days = " + formatedValue + " years");
            }

            //days-->centuries
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("days") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries")) {
                Double d= data/onecentury_day;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/onecentury_day);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " days = " + formatedValue + " centuries");
            }

            //weeks-->miliseconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds")) {
                Double d= data*oneweek_ms;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneweek_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " weeks = " + formatedValue + " miliseconds");
            }

            //weeks-->seconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds")) {
                Double d= data*oneweek_sec;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneweek_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " weeks = " + formatedValue + " seconds");
            }

            //weeks-->minutes
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes")) {
                Double d= data*oneweek_min;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneweek_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " weeks = " + formatedValue + " minutes");
            }

            //weeks-->hours
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hours")) {
                Double d= data*oneweek_hr;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneweek_hr);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " weeks = " + formatedValue + " hours");
            }

            //weeks-->days
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("days")) {
                Double d= data*7;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*7);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " weeks = " + formatedValue + " days");
            }

            //weeks-->months
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("months")) {
                Double d= data/4.345238;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/4.345238);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " weeks = " + formatedValue + " months");
            }

            //weeks-->years
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("years")) {
                Double d= data/oneyear_week;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/oneyear_week);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " weeks = " + formatedValue + " years");
            }

            //weeks-->centuries
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries")) {
                Double d= data/onecentury_week;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/onecentury_week);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " weeks = " + formatedValue + " centuries");
            }

            //month-->miliseconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("months") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds")) {
                Double d= data*onemonth_ms;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onemonth_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " months = " + formatedValue + " miliseconds");
            }

            //month-->seconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("months") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds")) {
                Double d= data*onemonth_sec;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onemonth_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " months = " + formatedValue + " seconds");
            }

            //month-->minutes
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("months") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes")) {
                Double d= data*onemonth_min;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onemonth_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " months = " + formatedValue + " minutes");
            }

            //month-->hours
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("months") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hours")) {
                Double d= data*onemonth_hr;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onemonth_hr);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " months = " + formatedValue + " hours");
            }

            //month-->days
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("months") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("days")) {
                Double d= data*onemonth_day;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*onemonth_day);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " months = " + formatedValue + " days");
            }

            //month-->weeks
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("months") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks")) {
                Double d= data*(4.345238);
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*4.345238);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " months = " + formatedValue + " weeks");
            }

            //month-->years
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("months") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("years")) {
                Double d= data/12;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/12);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " months = " + formatedValue + " years");
            }

            //month-->centuries
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("months") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries")) {
                Double d= data/(100*12);
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data/(100*12));
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " months = " + formatedValue + " centuries");
            }

            //year-->miliseconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("years") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds")) {
                Double d= data*oneyear_ms;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*oneyear_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " years = " + formatedValue + " miliseconds");
            }

            //year-->seconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("years") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds")) {
                Double d= data*oneyear_sec;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneyear_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " years = " + formatedValue + " seconds");
            }

            //year-->minutes
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("years") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes")) {
                Double d= data*oneyear_min;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneyear_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " years = " + formatedValue + " minutes");
            }

            //year-->hours
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("years") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hours")) {
                Double d= data*oneyear_hr;
                String formatedValue = String.format("%.1f", d);
                String s = String.valueOf(data*oneyear_hr);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " years = " + formatedValue + " hours");
            }

            //year-->days
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("years") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("days")) {
                Double d= data*oneyear_day;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*oneyear_day);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " years = " + formatedValue + " days");
            }

            //year-->weeks
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("years") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks")) {
                Double d= data*oneyear_week;
                String formatedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*oneyear_week);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " years = " + formatedValue + " weeks");
            }

            //year-->months
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("years") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("months")) {
                Double d= data*12;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*12);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " years = " + formatedValue + " months");
            }

            //year-->centuries
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("years") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries")) {
                Double d= data/100;
                String formatedValue = String.format("%.2f", d);
                //String s = String.valueOf(data/100);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " years = " + formatedValue + " centuries");
            }

            //century-->miliseconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miliseconds")) {
                Double d= data*onecentury_ms;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onecentury_ms);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " centuries = " + formatedValue + " miliseconds");
            }

            //century-->seconds
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("seconds")) {
                Double d= data*onecentury_sec;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onecentury_sec);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " centuries = " + formatedValue + " seconds");
            }

            //century-->minutes
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("minutes")) {
                Double d= data*onecentury_min;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onecentury_min);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " centuries = " + formatedValue + " minutes");
            }

            //century-->hours
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("hours")) {
                Double d= data*onecentury_hr;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onecentury_hr);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " centuries = " + formatedValue + " hours");
            }

            //century-->days
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("days")) {
                Double d= data*onecentury_day;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onecentury_day);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " centuries = " + formatedValue + " days");
            }

            //century-->weeks
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("weeks")) {
                Double d= data*onecentury_week;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*onecentury_week);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " centuries = " + formatedValue + " weeks");
            }

            //century-->months
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("months")) {
                Double d= data*100*12;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*100*12);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " centuries = " + formatedValue + " months");
            }

            //century-->years
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("centuries") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("years")) {
                Double d= data*100;
                String formatedValue = String.format("%.1f", d);
                //String s = String.valueOf(data*100);
                to_et.setText(formatedValue);
                tvResult.setText(s1 + " centuries = " + formatedValue + " years");
            }


        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
