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

public class TemperatureActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature_activity);
        //this.setTitle("Temperature");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Temperature");

        toolbar.setLogo(R.drawable.temp_icon);
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

        fromList.add("Celsius[°C]");
        fromList.add("Fahrenheit[°F]");
        fromList.add("Kelvin[K]");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("Celsius[°C]");
        tolist.add("Fahrenheit[°F]");
        tolist.add("Kelvin[K]");

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

            //Celsius[°C]-->Celsius[°C]
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Celsius[°C]") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Celsius[°C]")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Celsius[°C] = " + s + " Celsius[°C]");
            }

            //Celsius[°C]-->Fahrenheit[°F]
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Celsius[°C]") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Fahrenheit[°F]")) {
                String s = String.valueOf((data*(1.8))+32);
                to_et.setText(s);
                tvResult.setText(s1 + " Celsius[°C] = " + s + " Fahrenheit[°F]");
            }

            //Celsius[°C]-->Kelvin[K]
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Celsius[°C]") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Kelvin[K]")) {
                String s = String.valueOf(data+(273.15));
                to_et.setText(s);
                tvResult.setText(s1 + " Celsius[°C] = " + s + " Kelvin[K]");
            }

            //Fahrenheit[°F]-->Fahrenheit[°F]
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Fahrenheit[°F]") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Fahrenheit[°F]")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Fahrenheit[°F] = " + s + " Fahrenheit[°F]");
            }

            //Fahrenheit[°F]-->Celsius[°C]
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Fahrenheit[°F]") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Celsius[°C]")) {
                String s = String.valueOf((data-32)/(1.8));
                to_et.setText(s);
                tvResult.setText(s1 + " Fahrenheit[°F] = " + s + " Celsius[°C]");
            }

            //Fahrenheit[°F]-->Kelvin[K]
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Fahrenheit[°F]") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Kelvin[K]")) {
                String s = String.valueOf(((data-32)/(1.8))+273);
                to_et.setText(s);
                tvResult.setText(s1 + " Fahrenheit[°F] = " + s + " Kelvin[K]");
            }

            //Kelvin[K]-->Kelvin[K]
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Kelvin[K]") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Kelvin[K]")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Kelvin[K] = " + s + " Kelvin[K]");
            }

            //Kelvin[K]-->Celsius[°C]
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Kelvin[K]") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Celsius[°C]")) {
                String s = String.valueOf(data-(273.15));
                to_et.setText(s);
                tvResult.setText(s1 + " Kelvin[K] = " + s + " Celsius[°C]");
            }

            //Kelvin[K]-->Fahrenheit[°F]
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Kelvin[K]") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Fahrenheit[°F]")) {
                String s = String.valueOf(((data-273)*(1.8))+32);
                to_et.setText(s);
                tvResult.setText(s1 + " Kelvin[K] = " + s + " Fahrenheit[°F]");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
