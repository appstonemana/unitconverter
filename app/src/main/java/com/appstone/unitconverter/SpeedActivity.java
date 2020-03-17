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

public class SpeedActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_activity);
        //this.setTitle("Speed");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Speed");

        toolbar.setLogo(R.drawable.speed_icon);
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

        fromList.add("meter_per_second(m/s)");
        fromList.add("kilometer_per_hour(km/h)");
        fromList.add("mile_per_hour(mi/h)");
        fromList.add("knot");
        fromList.add("mach");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("meter_per_second(m/s)");
        tolist.add("kilometer_per_hour(km/h)");
        tolist.add("mile_per_hour(mi/h)");
        tolist.add("knot");
        tolist.add("mach");

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
            //Double d1= Double.valueOf(1000*1000);

            //meter_per_second(m/s)-->meter_per_second(m/s)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " m/s = " + s + " m/s");
            }

            //meter_per_second(m/s)-->kilometer_per_hour(km/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)")) {
                Double d= (data*18)/5;
                String formatedvalue= String.format("%.2f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " m/s = " + formatedvalue + " km/h");
            }

            //meter_per_second(m/s)-->mile_per_hour(mi/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)")) {
                Double d= (data*(2.23693));
                String formatedvalue= String.format("%.5f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " m/s = " + formatedvalue + " mi/h");
            }

            //meter_per_second(m/s)-->knot
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("knot")) {
                Double d= (data*(1.943844));
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " m/s = " + formatedvalue + " knot");
            }

            //meter_per_second(m/s)-->mach
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mach")) {
                Double d= data*(0.00294);
                String formatedvalue= String.format("%.5f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " m/s = " + formatedvalue + " mach");
            }

            //kilometer_per_hour(km/h)-->kilometer_per_hour(km/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " km/h = " + s + " km/h");
            }

            //kilometer_per_hour(km/h)-->meter_per_second(m/s)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)")) {
                Double d= (data*5)/18;
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf((data*5)/18);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " km/h = " + formatedvalue + " m/s");
            }

            //kilometer_per_hour(km/h)-->mile_per_hour(mi/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)")) {
                Double d= data*(0.621371);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf((data*5)/18);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " km/h = " + formatedvalue + " mi/h");
            }

            //kilometer_per_hour(km/h)-->knot
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("knot")) {
                Double d= data*(0.539957);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf((data*5)/18);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " km/h = " + formatedvalue + " knot");
            }

            //kilometer_per_hour(km/h)-->mach
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mach")) {
                Double d= data*(0.000816);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf((data*5)/18);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " km/h = " + formatedvalue + " mach");
            }

            //mile_per_hour(mi/h)-->mile_per_hour(mi/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mi/h = " + s + " mi/h");
            }

            //mile_per_hour(mi/h)-->meter_per_second(m/s)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)")) {
                Double d= data*(0.44704);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mi/h = " + formattedValue + " m/s");
            }

            //mile_per_hour(mi/h)-->kilometer_per_hour(km/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)")) {
                Double d= data*(1.609344);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mi/h = " + formattedValue + " km/h");
            }

            //mile_per_hour(mi/h)-->knot
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("knot")) {
                Double d= data*(0.868976);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mi/h = " + formattedValue + " knot");
            }

            //mile_per_hour(mi/h)-->mach
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mach")) {
                Double d= data*(0.001314);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mi/h = " + formattedValue + " mach");
            }

            //knot-->knot
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("knot") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("knot")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " knot = " + s + " knot");
            }

            //knot-->meter_per_second(m/s)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("knot") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)")) {
                Double d= data*(0.514445);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " knot = " + formattedValue + " m/s");
            }

            //knot-->kilometer_per_hour(km/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("knot") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)")) {
                Double d= data*(1.8520);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " knot = " + formattedValue + " km/h");
            }

            //knot-->mile_per_hour(mi/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("knot") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)")) {
                Double d= data*(1.1508);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " knot = " + formattedValue + " mi/h");
            }

            //knot-->mach
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("knot") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mach")) {
                Double d= data*(0.001512);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " knot = " + formattedValue + " mach");
            }

            //mach-->mach
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mach") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mach")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mach = " + s + " mach");
            }

            //mach-->meter_per_second(m/s)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mach") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("meter_per_second(m/s)")) {
                Double d= data*(340.2933);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mach = " + formattedValue + " m/s");
            }

            //mach-->kilometer_per_hour(km/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mach") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilometer_per_hour(km/h)")) {
                Double d= data*(1234.8);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mach = " + formattedValue + " km/h");
            }

            //mach-->mile_per_hour(mi/h)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mach") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mile_per_hour(mi/h)")) {
                Double d= data*(761.214);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mach = " + formattedValue + " mi/h");
            }

            //mach-->knot
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mach") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("knot")) {
                Double d= data*(661.477);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mach = " + formattedValue + " knot");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
