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

public class PressureActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pressure_activity);
        //setTitle("Pressure");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Pressure");

        toolbar.setLogo(R.drawable.pressure_icon);
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

        fromList.add("atmosphere(atm)");
        fromList.add("bar");
        fromList.add("pascals(Pa)");
        fromList.add("torr(mm Hg 0°C)");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("atmosphere(atm)");
        tolist.add("bar");
        tolist.add("pascals(Pa)");
        tolist.add("torr(mm Hg 0°C)");

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
            Double d1= Double.valueOf(100000);

            //atmosphere(atm)-->atmosphere(atm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("atmosphere(atm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("atmosphere(atm)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " atm = " + s + " atm");
            }

            //atmosphere(atm)-->bar
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("atmosphere(atm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("bar")) {
                String s = String.valueOf(data/0.987);
                to_et.setText(s);
                tvResult.setText(s1 + " atm = " + s + " bar");
            }

            //atmosphere(atm)-->pascals(Pa)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("atmosphere(atm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pascals(Pa)")) {
                String s = String.valueOf(data*101325);
                to_et.setText(s);
                tvResult.setText(s1 + " atm = " + s + " pascals(Pa)");
            }

            //atmosphere(atm)-->torr(mm Hg 0°C)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("atmosphere(atm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("torr(mm Hg 0°C)")) {
                String s = String.valueOf(data*760);
                to_et.setText(s);
                tvResult.setText(s1 + " atm = " + s + "torr(mm Hg 0°C)");
            }

            //bar-->bar
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("bar") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("bar")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " bar = " + s + " bar");
            }

            //bar-->atmosphere(atm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("bar") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("atmosphere(atm)")) {
                String s = String.valueOf(data*0.987);
                to_et.setText(s);
                tvResult.setText(s1 + " bar = " + s + " atmosphere(atm)");
            }

            //bar-->pascals(Pa)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("bar") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pascals(Pa)")) {
                String s = String.valueOf(data*d1);
                to_et.setText(s);
                tvResult.setText(s1 + " bar = " + s + " pascals(Pa)");
            }

            //bar-->torr(mm Hg 0°C)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("bar") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("torr(mm Hg 0°C)")) {
                String s = String.valueOf(data*750.06);
                to_et.setText(s);
                tvResult.setText(s1 + " bar = " + s + " torr(mm Hg 0°C)");
            }

            //pascals(Pa)-->pascals(Pa)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pascals(Pa)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pascals(Pa)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Pa = " + s + " Pa");
            }

            //pascals(Pa)-->atmosphere(atm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pascals(Pa)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("atmosphere(atm)")) {
                Double d= data/101325;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data/101325);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Pa = " + formattedValue + " atmosphere(atm)");
            }

            //pascals(Pa)-->bar
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pascals(Pa)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("bar")) {
                Double d= data/d1;
                String formattedValue = String.format("%.5f", d);
               // String s = String.valueOf(data/d1);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Pa = " + formattedValue + " bar");
            }

            //pascals(Pa)-->torr(mm Hg 0°C)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pascals(Pa)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("torr(mm Hg 0°C)")) {
                Double d= data*(0.007501);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*(760/101325));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " Pa = " + formattedValue + " torr(mm Hg 0°C)");
            }

            //torr(mm Hg 0°C)-->torr(mm Hg 0°C)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("torr(mm Hg 0°C)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("torr(mm Hg 0°C)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " torr = " + s + " torr");
            }

            //torr(mm Hg 0°C)-->atmosphere(atm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("torr(mm Hg 0°C)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("atmosphere(atm)")) {
                Double d= data*(0.001316);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " torr = " + formattedValue + " atmosphere(atm)");
            }

            //torr(mm Hg 0°C)-->bar
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("torr(mm Hg 0°C)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("bar")) {
                Double d= data/(750.06);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " torr = " + formattedValue + " bar");
            }

            //torr(mm Hg 0°C)-->pascals(Pa)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("torr(mm Hg 0°C)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pascals(Pa)")) {
                Double d= data*133.32237;
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " torr = " + formattedValue + " pascals(Pa)");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
