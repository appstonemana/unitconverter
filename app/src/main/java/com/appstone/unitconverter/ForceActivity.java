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

public class ForceActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.force_activity);
        //this.setTitle("Force");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Force");

        toolbar.setLogo(R.drawable.force_icon);
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

        fromList.add("dyne(dyn)");
        fromList.add("newton(N)");
        fromList.add("kilonewton(kN)");
        fromList.add("kip");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("dyne(dyn)");
        tolist.add("newton(N)");
        tolist.add("kilonewton(kN)");
        tolist.add("kip");

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

            //dyne(dyn)-->dyne(dyn)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("dyne(dyn)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("dyne(dyn)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " dyn = " + s + " dyn");
            }

            //dyne(dyn)-->newton(N)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("dyne(dyn)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton(N)")) {
                Double d= data/100000;
                String formattedValue = String.format("%.5f", d);
               // String s = String.valueOf(data/100000);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " dyn = " + formattedValue + " N");
            }

            //dyne(dyn)-->kilonewton(kN)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("dyne(dyn)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilonewton(kN)")) {
                String s = String.valueOf(data/(d1*100));
                to_et.setText(s);
                tvResult.setText(s1 + " dyn = " + s + " kN");
            }

            //dyne(dyn)-->kip
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("dyne(dyn)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kip")) {
                String s = String.valueOf(data/444822160);
                to_et.setText(s);
                tvResult.setText(s1 + " dyn = " + s + " kip");
            }

            //newton(N)-->newton(N)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton(N)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton(N)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " N = " + s + " N");
            }

            //newton(N)-->dyne(dyn)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton(N)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("dyne(dyn)")) {
                String s = String.valueOf(data*100000);
                to_et.setText(s);
                tvResult.setText(s1 + " N = " + s + " dyn");
            }

            //newton(N)-->kilonewton(kN)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton(N)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilonewton(kN)")) {
                String s = String.valueOf(data/1000);
                to_et.setText(s);
                tvResult.setText(s1 + " N = " + s + " kN");
            }

            //newton(N)-->kip
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton(N)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kip")) {
                String s = String.valueOf(data/(4448.2216));
                to_et.setText(s);
                tvResult.setText(s1 + " N = " + s + " kip");
            }

            //kilonewton(kN)-->kilonewton(kN)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilonewton(kN)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilonewton(kN)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " kN = " + s + " kN");
            }

            //kilonewton(kN)-->dyne(dyn)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilonewton(kN)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("dyne(dyn)")) {
                String s = String.valueOf(data*d1*100);
                to_et.setText(s);
                tvResult.setText(s1 + " kN = " + s + " dyn");
            }

            //kilonewton(kN)-->newton(N)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilonewton(kN)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton(N)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " kN = " + s + " N");
            }

            //kilonewton(kN)-->kip
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilonewton(kN)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kip")) {
                String s = String.valueOf(data/(4.4482216));
                to_et.setText(s);
                tvResult.setText(s1 + " kN = " + s + " kip");
            }

            //kip-->kip
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kip") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kip")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " kip = " + s + " kip");
            }

            //kip-->dyne(dyn)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kip") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("dyne(dyn)")) {
                String s = String.valueOf(data*444822160);
                to_et.setText(s);
                tvResult.setText(s1 + " kip = " + s + " dyn");
            }

            //kip-->newton(N)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kip") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton(N)")) {
                String s = String.valueOf(data*4448.2216);
                to_et.setText(s);
                tvResult.setText(s1 + " kip = " + s + " N");
            }

            //kip-->kilonewton(kN)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kip") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilonewton(kN)")) {
                String s = String.valueOf(data*4.4482216);
                to_et.setText(s);
                tvResult.setText(s1 + " kip = " + s + " N");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
