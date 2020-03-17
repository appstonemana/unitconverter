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

public class VolumeActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_activity);
        //this.setTitle("Volume");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Volume");

        toolbar.setLogo(R.drawable.volume_icon);
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

        fromList.add("liter(L)");
        fromList.add("deciliter(dL)");
        fromList.add("mililiter(mL)");
        fromList.add("barrel(bbL)");
        fromList.add("gallon(gal)");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("liter(L)");
        tolist.add("deciliter(dL)");
        tolist.add("mililiter(mL)");
        tolist.add("barrel(bbL)");
        tolist.add("gallon(gal)");

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

            //liter(L)-->liter(L)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " L = " + s + " L");
            }

            //liter(L)-->deciliter(dL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)")) {
                String s = String.valueOf(data*10);
                to_et.setText(s);
                tvResult.setText(s1 + " L = " + s + " dL");
            }

            //liter(L)-->mililiter(mL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " L = " + s + " mL");
            }

            //liter(L)-->barrel(bbL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)")) {
                Double d= data*(0.00629);
                String formatedvalue= String.format("%.5f",d);
                //String s = String.valueOf(data*(0.00629));
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " L = " + formatedvalue + " bbL");
            }

            //liter(L)-->gallon(gal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)")) {
                Double d= data*(0.219969);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data*(0.219969));
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " L = " + formatedvalue + " gal");
            }

            //deciliter(dL)-->deciliter(dL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " dL = " + s + " dL");
            }

            //deciliter(dL)-->liter(L)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)")) {
                Double d= data/10;
                String formatedvalue= String.format("%.1f",d);
                //String s = String.valueOf(data/10);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " dL = " + formatedvalue + " L");
            }

            //deciliter(dL)-->mililiter(mL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)")) {
                String s = String.valueOf(data*100);
                to_et.setText(s);
                tvResult.setText(s1 + " dL = " + s + " mL");
            }

            //deciliter(dL)-->barrel(bbL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)")) {
                Double d= data*(0.000629);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data*(0.000629));
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " dL = " + formatedvalue + " bbL");
            }

            //deciliter(dL)-->gallon(gal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)")) {
                Double d= data*(0.021997);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data*(0.000629));
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " dL = " + formatedvalue + " gal");
            }

            //mililiter(mL)-->mililiter(mL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mL = " + s + " mL");
            }

            //mililiter(mL)-->liter(L)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)")) {
                Double d= data/1000;
                String formatedvalue= String.format("%.4f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " mL = " + formatedvalue + " L");
            }

            //mililiter(mL)-->deciliter(dL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)")) {
                Double d= data/100;
                String formatedvalue= String.format("%.4f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " mL = " + formatedvalue + " dL");
            }

            //mililiter(mL)-->barrel(bbL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)")) {
                Double d= data*(0.000006);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " mL = " + formatedvalue + " bbL");
            }

            //mililiter(mL)-->gallon(gal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)")) {
                Double d= data*(0.00022);
                String formatedvalue= String.format("%.5f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " mL = " + formatedvalue + " gal");
            }

            //barrel(bbL)-->barrel(bbL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " bbL = " + s + " bbL");
            }

            //barrel(bbL)-->liter(L)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)")) {
                Double d= data/(0.00629);
                String formatedvalue= String.format("%.5f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " bbL = " + formatedvalue + " L");
            }

            //barrel(bbL)-->deciliter(dL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)")) {
                Double d= data/(0.000629);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " bbL = " + formatedvalue + " dL");
            }

            //barrel(bbL)-->mililiter(mL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)")) {
                Double d= data/(0.000006);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " bbL = " + formatedvalue + " mL");
            }

            //barrel(bbL)-->gallon(gal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)")) {
                Double d= data*(34.972316);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " bbL = " + formatedvalue + " gal");
            }

            //gallon(gal)-->gallon(gal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " gal = " + s + " gal");
            }

            //gallon(gal)-->liter(L)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("liter(L)")) {
                Double d= data/(0.219969);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " gal = " + formatedvalue + " L");
            }

            //gallon(gal)-->deciliter(dL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("deciliter(dL)")) {
                Double d= data/(0.021997);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " gal = " + formatedvalue + " dL");
            }

            //gallon(gal)-->mililiter(mL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mililiter(mL)")) {
                Double d= data/(0.00022);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " gal = " + formatedvalue + " mL");
            }

            //gallon(gal)-->barrel(bbL)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gallon(gal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("barrel(bbL)")) {
                Double d= data/(34.972316);
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " gal = " + formatedvalue + " bbL");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
