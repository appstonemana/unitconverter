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

public class PowerActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.power_activity);
        //this.setTitle("Power");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Power");

        toolbar.setLogo(R.drawable.power_icon);
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

        fromList.add("watt(W)");
        fromList.add("kilowatt(kW)");
        fromList.add("megawatt(MW)");
        fromList.add("horsepower(HP)");
        fromList.add("ton_of_refrigeration(TR)");
        fromList.add("decibels_relative_to_one_milliwatt(dBm)");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("watt(W)");
        tolist.add("kilowatt(kW)");
        tolist.add("megawatt(MW)");
        tolist.add("horsepower(HP)");
        tolist.add("ton_of_refrigeration(TR)");
        tolist.add("decibels_relative_to_one_milliwatt(dBm)");

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
            Double d1= Double.valueOf(1000*1000);
            Double d2= d1*1000;

            //watt(W)-->watt(W)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " W = " + s + " W");
            }

            //watt(W)-->kilowatt(kW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)")) {
                Double d= data/1000;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " W = " + formatedvalue + " kW");
            }

            //watt(W)-->megawatt(MW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)")) {
                Double d= data/d1;
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " W = " + formatedvalue + " MW");
            }

            //watt(W)-->horsepower(HP)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)")) {
                Double d= data*(0.001340);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " W = " + formatedvalue + " HP");
            }

            //watt(W)-->ton_of_refrigeration(TR)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)")) {
                Double d= data*(0.000284);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " W = " + formatedvalue + " TR");
            }

            //watt(W)-->decibels_relative_to_one_milliwatt(dBm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)")) {
                Double d= (10*(Math.log10(data)))+30;
                String formatedvalue= String.format("%.5f",d);
                //String s = String.valueOf(d);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " W = " + formatedvalue + " dBm");
            }

            //kilowatt(kW)-->kilowatt(kW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " kW = " + s + " kW");
            }

            //kilowatt(kW)-->watt(W)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " kW = " + s + " W");
            }

            //kilowatt(kW)-->megawatt(MW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)")) {
                Double d= data/1000;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data*1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " kW = " + formatedvalue + " MW");
            }

            //kilowatt(kW)-->horsepower(HP)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)")) {
                Double d= data*(1.341);
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data*1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " kW = " + formatedvalue + " HP");
            }

            //kilowatt(kW)-->ton_of_refrigeration(TR)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)")) {
                Double d= data*(0.284345);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data*1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " kW = " + formatedvalue + " TR");
            }

            //kilowatt(kW)-->decibels_relative_to_one_milliwatt(dBm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)")) {
                Double dd= data*1000;
                Double d= (10*(Math.log10(dd)))+30;
                String formatedvalue= String.format("%.5f",d);
                //String s = String.valueOf(data*1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " kW = " + formatedvalue + " dBm");
            }

            //megawatt(MW)-->megawatt(MW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " MW = " + s + " MW");
            }

            //megawatt(MW)-->watt(W)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)")) {
                String s = String.valueOf(data*d1);
                to_et.setText(s);
                tvResult.setText(s1 + " MW = " + s + " W");
            }

            //megawatt(MW)-->kilowatt(kW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " MW = " + s + " kW");
            }

            //megawatt(MW)-->horsepower(HP)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)")) {
                Double d= data*(1341.021);
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data*(1341.02));
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " MW = " + formatedvalue + " HP");
            }

            //megawatt(MW)-->ton_of_refrigeration(TR)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)")) {
                Double d= data*(284.345);
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data*(1341.02));
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " MW = " + formatedvalue + " TR");
            }

            //megawatt(MW)-->decibels_relative_to_one_milliwatt(dBm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)")) {
                Double dd= data*d1;
                Double d= (10*(Math.log10(dd)))+30;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data*(1341.02));
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " MW = " + formatedvalue + " dBm");
            }

            //horsepower(HP)-->horsepower(HP)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " HP = " + s + " HP");
            }

            //horsepower(HP)-->watt(W)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)")) {
                Double d= data*746;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data*746);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " HP = " + formatedvalue + " W");
            }

            //horsepower(HP)-->kilowatt(kW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)")) {
                Double d= data*(0.746);
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data*746);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " HP = " + formatedvalue + " kW");
            }

            //horsepower(HP)-->megawatt(MW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)")) {
                Double d= data*(0.000746);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data*746);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " HP = " + formatedvalue + " MW");
            }

            //horsepower(HP)-->ton_of_refrigeration(TR)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)")) {
                Double d= data*(0.212121);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data*746);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " HP = " + formatedvalue + " TR");
            }

            //horsepower(HP)-->decibels_relative_to_one_milliwatt(dBm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)")) {
                Double dd= data*746;
                Double d= (10*(Math.log10(dd)))+30;
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data*746);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " HP = " + formatedvalue + " dBm");
            }

            //ton_of_refrigeration(TR)-->ton_of_refrigeration(TR)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " TR = " + s + " TR");
            }

            //ton_of_refrigeration(TR)-->watt(W)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)")) {
                Double d= data*(3516.853);
                String formatedvalue= String.format("%.4f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " TR = " + formatedvalue + " W");
            }

            //ton_of_refrigeration(TR)-->kilowatt(kW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)")) {
                Double d= data*(3.516853);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " TR = " + formatedvalue + " kW");
            }

            //ton_of_refrigeration(TR)-->megawatt(MW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)")) {
                Double d= data*(0.003517);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " TR = " + formatedvalue + " MW");
            }

            //ton_of_refrigeration(TR)-->horsepower(HP)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)")) {
                Double d= data*(4.71428);
                String formatedvalue= String.format("%.5f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " TR = " + formatedvalue + " HP");
            }

            //ton_of_refrigeration(TR)-->decibels_relative_to_one_milliwatt(dBm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)")) {
                Double dd= data*(3516.853);
                Double d= (10*(Math.log10(dd)))+30;
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " TR = " + formatedvalue + " dBm");
            }

            //decibels_relative_to_one_milliwatt(dBm)-->decibels_relative_to_one_milliwatt(dBm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " dBm = " + s + " dBm");
            }

            //decibels_relative_to_one_milliwatt(dBm)-->watt(W)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("watt(W)")) {
                Double dd= data/10;
                Double pow= Math.pow(10,dd);
                Double d= pow/1000;
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(pow/1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " dBm = " + formatedvalue + " W");
            }

            //decibels_relative_to_one_milliwatt(dBm)-->kilowatt(kW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilowatt(kW)")) {
                Double dd= data/10;
                Double pow= Math.pow(10,dd);
                Double d= pow/d1;
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(pow/1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " dBm = " + formatedvalue + " kW");
            }

            //decibels_relative_to_one_milliwatt(dBm)-->megawatt(MW)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("megawatt(MW)")) {
                Double dd= data/10;
                Double pow= Math.pow(10,dd);
                Double d= pow/d2;
                String formatedvalue= String.format("%.9f",d);
                //String s = String.valueOf(pow/1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " dBm = " + formatedvalue + " MW");
            }

            //decibels_relative_to_one_milliwatt(dBm)-->horsepower(HP)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("horsepower(HP)")) {
                Double dd= data/10;
                Double pow= Math.pow(10,dd);
                Double d= pow/(1000*746);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(pow/1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " dBm = " + formatedvalue + " HP");
            }

            //decibels_relative_to_one_milliwatt(dBm)-->ton_of_refrigeration(TR)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("decibels_relative_to_one_milliwatt(dBm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ton_of_refrigeration(TR)")) {
                Double dd= data/10;
                Double pow= Math.pow(10,dd);
                Double d= pow/(1000*(3516.853));
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(pow/1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " dBm = " + formatedvalue + " TR");
            }


        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
