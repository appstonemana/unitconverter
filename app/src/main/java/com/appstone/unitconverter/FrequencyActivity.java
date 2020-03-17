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

public class FrequencyActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frequency_activity);
        //this.setTitle("Frequency");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Frequency");

        toolbar.setLogo(R.drawable.frequency_icon);
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

        fromList.add("Hertz(Hz)");
        fromList.add("Kilohertz(KHz)");
        fromList.add("Megahertz(MHz)");
        fromList.add("Gigahertz(GHz)");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("Hertz(Hz)");
        tolist.add("Kilohertz(KHz)");
        tolist.add("Megahertz(MHz)");
        tolist.add("Gigahertz(GHz)");

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

            //Hertz(Hz)-->Hertz(Hz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Hertz(Hz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hertz(Hz)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Hz = " + s + " Hz");
            }

            //Hertz(Hz)-->Kilohertz(KHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Hertz(Hz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Kilohertz(KHz)")) {
                Double d= data/1000;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " Hz = " + formatedvalue + " KHz");
            }

            //Hertz(Hz)-->Megahertz(MHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Hertz(Hz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Megahertz(MHz)")) {
                Double d= data/d1;
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " Hz = " + formatedvalue + " MHz");
            }

            //Hertz(Hz)-->Gigahertz(GHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Hertz(Hz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gigahertz(GHz)")) {
                Double d= data/d2;
                String formatedvalue= String.format("%.9f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " Hz = " + formatedvalue + " GHz");
            }

            //Kilohertz(KHz)-->Kilohertz(KHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Kilohertz(KHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Kilohertz(KHz)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " KHz = " + s + " KHz");
            }

            //Kilohertz(KHz)-->Hertz(Hz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Kilohertz(KHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hertz(Hz)")) {
                Double d= data*1000;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data*1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " KHz = " + formatedvalue + " Hz");
            }

            //Kilohertz(KHz)-->Megahertz(MHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Kilohertz(KHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Megahertz(MHz)")) {
                Double d= data/1000;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data/1000);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " KHz = " + formatedvalue + " MHz");
            }

            //Kilohertz(KHz)-->Gigahertz(GHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Kilohertz(KHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gigahertz(GHz)")) {
                Double d= data/d1;
                String formatedvalue= String.format("%.6f",d);
                //String s = String.valueOf(data/d1);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " KHz = " + formatedvalue + " GHz");
            }

            //Megahertz(MHz)-->Megahertz(MHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Megahertz(MHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Megahertz(MHz)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " MHz = " + s + " MHz");
            }

            //Megahertz(MHz)-->Hertz(Hz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Megahertz(MHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hertz(Hz)")) {
                Double d= data*d1;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " MHz = " + formatedvalue + " Hz");
            }

            //Megahertz(MHz)-->Kilohertz(KHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Megahertz(MHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Kilohertz(KHz)")) {
                Double d= data*1000;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " MHz = " + formatedvalue + " KHz");
            }

            //Megahertz(MHz)-->Gigahertz(GHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Megahertz(MHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gigahertz(GHz)")) {
                Double d= data/1000;
                String formatedvalue= String.format("%.3f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " MHz = " + formatedvalue + " GHz");
            }

            //Gigahertz(GHz)-->Gigahertz(GHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gigahertz(GHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Gigahertz(GHz)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " GHz = " + s + " GHz");
            }

            //Gigahertz(GHz)-->Hertz(Hz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gigahertz(GHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hertz(Hz)")) {
                Double d= data*d2;
                String formatedvalue= String.format("%.1f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " GHz = " + formatedvalue + " Hz");
            }

            //Gigahertz(GHz)-->Kilohertz(KHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gigahertz(GHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Kilohertz(KHz)")) {
                Double d= data*d1;
                String formatedvalue= String.format("%.1f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " GHz = " + formatedvalue + " KHz");
            }

            //Gigahertz(GHz)-->Megahertz(MHz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Gigahertz(GHz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Megahertz(MHz)")) {
                Double d= data*1000;
                String formatedvalue= String.format("%.1f",d);
                //String s = String.valueOf(data);
                to_et.setText(formatedvalue);
                tvResult.setText(s1 + " GHz = " + formatedvalue + " MHz");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
