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

public class BloodSugarActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_activity);
        //this.setTitle("BloodSugar");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  BloodSugar");

        toolbar.setLogo(R.drawable.bloodsugar_icon);
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

        fromList.add("mg/dL");
        fromList.add("mmol/L");
        fromList.add("Hb-A1c%");
        fromList.add("mmol/mol");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("mg/dL");
        tolist.add("mmol/L");
        tolist.add("Hb-A1c%");
        tolist.add("mmol/mol");

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
        });*/

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

            //mg/dL-->mg/dL
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mg/dL") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mg/dL")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mg/dL = " + s + " mg/dL");
            }

            //mg/dL-->mmol/L
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mg/dL") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/L")) {
                Double d=data/18;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data/18);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mg/dL = " + formattedValue + " mmol/L");
            }

            //mg/dL-->Hb-A1c%
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mg/dL") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hb-A1c%")) {
                Double d=(data+77.3)/35.6;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf((data+77.3)/35.6);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mg/dL = " + formattedValue + " Hb-A1c%");
            }

            //mg/dL-->mmol/mol
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mg/dL") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/mol")) {
                Double d1=(data+77.3)/35.6;
                Double d2=(10.93*d1)-23.5;
                String formattedValue = String.format("%.5f", d2);
                //String s = String.valueOf((data+77.3)/35.6);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mg/dL = " + formattedValue + " mmol/mol");
            }

            //mmol/L-->mmol/L
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/L") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/L")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mmol/L = " + s + " mmol/L");
            }

            //mmol/L-->mg/dL
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/L") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mg/dL")) {
                String s = String.valueOf(data*18);
                to_et.setText(s);
                tvResult.setText(s1 + " mmol/L = " + s + " mg/dL");
            }

            //mmol/L-->Hb-A1c%
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/L") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hb-A1c%")) {
                /*Double d1= (data/18)+77.3;
                Double d2= d1/(35.6);*/
                Double d1= (data+4.29)/1.98;
                String formattedValue = String.format("%.5f", d1);
                //String s = String.valueOf(data*18);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mmol/L = " + formattedValue + " Hb-A1c%");
            }

            //mmol/L-->mmol/mol
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/L") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/mol")) {
                /*Double d1= (data/18)+77.3;
                Double d2= d1/(35.6);
                Double d3= (10.93*d2)-23.5;*/
                Double d= (data/5.34)*31;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*18);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mmol/L = " + formattedValue + " mmol/mol");
            }

            //Hb-A1c%-->Hb-A1c%
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Hb-A1c%") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hb-A1c%")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Hb-A1c% = " + s + " Hb-A1c%");
            }

            //Hb-A1c%-->mg/dL
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Hb-A1c%") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mg/dL")) {
                Double d= (data*35.6)-77.3;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf((data*35.6)-77.3);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Hb-A1c% = " + formattedValue + " mg/dL");
            }

            //Hb-A1c%-->mmol/L
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Hb-A1c%") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/L")) {
                Double d= (data*1.98)-4.29;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf((data*1.98)-4.29);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Hb-A1c% = " + formattedValue + " mmol/L");
            }

            //Hb-A1c%-->mmol/mol
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Hb-A1c%") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/mol")) {
                Double d= (data*10.93)-23.50;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf((data*10.93)-23.50);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Hb-A1c% = " + formattedValue + " mmol/mol");
            }

            //mmol/mol-->mmol/mol
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/mol") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/mol")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mmol/mol = " + s + " mmol/mol");
            }

            //mmol/mol-->mg/dL
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/mol") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mg/dL")) {
                Double d= (data/30.014)*97;
                /*Double d1=(data+23.5)*35.6;
                Double d2=(d1/(10.93))-77.3;*/
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mmol/mol = " + formattedValue + " mg/dL");
            }

            //mmol/mol-->mmol/L
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/mol") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/L")) {
                Double d= (data*5.34)/31;
                /*Double d1=(data+23.5)*35.6;
                Double d2=(d1/(10.93))-77.3;*/
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mmol/mol = " + formattedValue + " mmol/L");
            }

            //mmol/mol-->Hb-A1c%
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mmol/mol") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hb-A1c%")) {
                Double d= (data+23.5)/10.93;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " mmol/mol = " + formattedValue + " Hb-A1c%");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
