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

public class EnergyActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.energy_activity);
        //this.setTitle("Energy");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Energy");

        toolbar.setLogo(R.drawable.energy_icon);
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

        fromList.add("joule(J)");
        fromList.add("kilojoule(kJ)");
        fromList.add("calorie(cal)");
        fromList.add("kilocalorie(kcal)");
        fromList.add("ergs");
        fromList.add("newton_meter(Nm)");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("joule(J)");
        tolist.add("kilojoule(kJ)");
        tolist.add("calorie(cal)");
        tolist.add("kilocalorie(kcal)");
        tolist.add("ergs");
        tolist.add("newton_meter(Nm)");

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

            //joule(J)-->joule(J)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " J = " + s + " J");
            }

            //joule(J)-->kilojoule(kJ)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)")) {
                String s = String.valueOf(data/1000);
                to_et.setText(s);
                tvResult.setText(s1 + " J = " + s + " kJ");
            }

            //joule(J)-->calorie(cal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)")) {
                String s = String.valueOf(data/4.184);
                to_et.setText(s);
                tvResult.setText(s1 + " J = " + s + " cal");
            }

            //joule(J)-->kilocalorie(kcal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)")) {
                String s = String.valueOf(data/4184);
                to_et.setText(s);
                tvResult.setText(s1 + " J = " + s + " kcal");
            }

            //joule(J)-->ergs
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs")) {
                String s = String.valueOf(data*10*d1);
                to_et.setText(s);
                tvResult.setText(s1 + " J = " + s + " ergs");
            }

            //joule(J)-->newton_meter(Nm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " J = " + s + " Nm");
            }

            //kilojoule(kJ)-->kilojoule(kJ)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " kJ = " + s + " kJ");
            }

            //kilojoule(kJ)-->joule(J)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " kJ = " + s + " J");
            }

            //kilojoule(kJ)-->calorie(cal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)")) {
                String s = String.valueOf(data*(d1/4184));
                to_et.setText(s);
                tvResult.setText(s1 + " kJ = " + s + " cal");
            }

            //kilojoule(kJ)-->kilocalorie(kcal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)")) {
                String s = String.valueOf(data/4.184);
                to_et.setText(s);
                tvResult.setText(s1 + " kJ = " + s + " kcal");
            }

            //kilojoule(kJ)-->ergs
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs")) {
                String s = String.valueOf(data*d1*10000);
                to_et.setText(s);
                tvResult.setText(s1 + " kJ = " + s + " ergs");
            }

            //kilojoule(kJ)-->newton_meter(Nm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " kJ = " + s + " Nm");
            }

            //calorie(cal)-->calorie(cal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " cal = " + s + " cal");
            }

            //calorie(cal)-->joule(J)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)")) {
                String s = String.valueOf(data*4.184);
                to_et.setText(s);
                tvResult.setText(s1 + " cal = " + s + " J");
            }

            //calorie(cal)-->kilojoule(kJ)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)")) {
                String s = String.valueOf(data*(4184/d1));
                to_et.setText(s);
                tvResult.setText(s1 + " cal = " + s + " kJ");
            }

            //calorie(cal)-->kilocalorie(kcal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)")) {
                String s = String.valueOf(data/1000);
                to_et.setText(s);
                tvResult.setText(s1 + " cal = " + s + " kcal");
            }

            //calorie(cal)-->ergs
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs")) {
                String s = String.valueOf(data*4184*10000);
                to_et.setText(s);
                tvResult.setText(s1 + " cal = " + s + " ergs");
            }

            //calorie(cal)-->newton_meter(Nm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)")) {
                String s = String.valueOf(data*4.184);
                to_et.setText(s);
                tvResult.setText(s1 + " cal = " + s + " Nm");
            }

            //kilocalorie(kcal)-->kilocalorie(kcal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " kcal = " + s + " kcal");
            }

            //kilocalorie(kcal)-->joule(J)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)")) {
                String s = String.valueOf(data*4184);
                to_et.setText(s);
                tvResult.setText(s1 + " kcal = " + s + " J");
            }

            //kilocalorie(kcal)-->kilojoule(kJ)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)")) {
                String s = String.valueOf(data*4.184);
                to_et.setText(s);
                tvResult.setText(s1 + " kcal = " + s + " kJ");
            }

            //kilocalorie(kcal)-->calorie(cal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " kcal = " + s + " cal");
            }

            //kilocalorie(kcal)-->ergs
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs")) {
                String s = String.valueOf(data*41840*d1);
                to_et.setText(s);
                tvResult.setText(s1 + " kcal = " + s + " ergs");
            }

            //kilocalorie(kcal)-->newton_meter(Nm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)")) {
                String s = String.valueOf(data*4184);
                to_et.setText(s);
                tvResult.setText(s1 + " kcal = " + s + " Nm");
            }

            //ergs-->ergs
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " ergs = " + s + " ergs");
            }

            //ergs-->joule(J)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)")) {
                String s = String.valueOf(data/(d1*10));
                to_et.setText(s);
                tvResult.setText(s1 + " ergs = " + s + " J");
            }

            //ergs-->kilojoule(kJ)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)")) {
                String s = String.valueOf(data/(d1*10000));
                to_et.setText(s);
                tvResult.setText(s1 + " ergs = " + s + " kJ");
            }

            //ergs-->calorie(cal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)")) {
                String s = String.valueOf(data/(4184*10000));
                to_et.setText(s);
                tvResult.setText(s1 + " ergs = " + s + " cal");
            }

            //ergs-->kilocalorie(kcal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)")) {
                String s = String.valueOf(data/(41840*d1));
                to_et.setText(s);
                tvResult.setText(s1 + " ergs = " + s + " kcal");
            }

            //ergs-->newton_meter(Nm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)")) {
                String s = String.valueOf(data/(d1*10));
                to_et.setText(s);
                tvResult.setText(s1 + " ergs = " + s + " Nm");
            }

            //newton_meter(Nm)-->newton_meter(Nm)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Nm = " + s + " Nm");
            }

            //newton_meter(Nm)-->joule(J)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("joule(J)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Nm = " + s + " J");
            }

            //newton_meter(Nm)-->kilojoule(kJ)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilojoule(kJ)")) {
                String s = String.valueOf(data/1000);
                to_et.setText(s);
                tvResult.setText(s1 + " Nm = " + s + " kJ");
            }

            //newton_meter(Nm)-->calorie(cal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("calorie(cal)")) {
                String s = String.valueOf(data/4.184);
                to_et.setText(s);
                tvResult.setText(s1 + " Nm = " + s + " cal");
            }

            //newton_meter(Nm)-->kilocalorie(kcal)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilocalorie(kcal)")) {
                String s = String.valueOf(data/4184);
                to_et.setText(s);
                tvResult.setText(s1 + " Nm = " + s + " kcal");
            }

            //newton_meter(Nm)-->ergs
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("newton_meter(Nm)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ergs")) {
                String s = String.valueOf(data*10*d1);
                to_et.setText(s);
                tvResult.setText(s1 + " Nm = " + s + " ergs");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
