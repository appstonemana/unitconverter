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


public class WeightActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_activity);
        //this.setTitle("Weight");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Weight");

        toolbar.setLogo(R.drawable.weight_icon);
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

        fromList.add("miligram(mg)");
        fromList.add("gram(g)");
        fromList.add("kilogram(kg)");
        fromList.add("pound(lb)");
        fromList.add("ounce(oz)");
        fromList.add("tonne");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("miligram(mg)");
        tolist.add("gram(g)");
        tolist.add("kilogram(kg)");
        tolist.add("pound(lb)");
        tolist.add("ounce(oz)");
        tolist.add("tonne");

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

       /* assert clearBtn != null;
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

            double pound=2.204623d;
            Double d1= Double.valueOf(1000*1000);
            Double d2=(1000*d1);

            //miligram(mg)-->miligram(mg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mg = " + s + " mg");
            }

            //miligram(mg)-->gram(g)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)")) {
                String s = String.valueOf(data/1000);
                to_et.setText(s);
                tvResult.setText(s1 + " mg = " + s + " g");
            }

            //miligram(mg)-->kilogram(g)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)")) {
                String s = String.valueOf(data/d1);
                to_et.setText(s);
                tvResult.setText(s1 + " mg = " + s + " kg");
            }

            //miligram(mg)-->pound(lb)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)")) {
                String s = String.valueOf(data*(pound/d1));
                to_et.setText(s);
                tvResult.setText(s1 + " mg = " + s + " lb");
            }

            //miligram(mg)-->ounce(oz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)")) {
                String s = String.valueOf(data*(pound/d1)*16);
                to_et.setText(s);
                tvResult.setText(s1 + " mg = " + s + " oz");
            }

            //miligram(mg)-->tonne
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne")) {
                String s = String.valueOf(data/d2);
                to_et.setText(s);
                tvResult.setText(s1 + " mg = " + s + " tonne");
            }

            //gram(g)-->gram(g)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " g = " + s + " g");
            }

            //gram(g)-->miligram(mg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " g = " + s + " mg");
            }

            //gram(g)-->kilogram(kg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)")) {
                String s = String.valueOf(data/1000);
                to_et.setText(s);
                tvResult.setText(s1 + " g = " + s + " kg");
            }

            //gram(g)-->pound(lb)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)")) {
                String s = String.valueOf(data*(pound/1000));
                to_et.setText(s);
                tvResult.setText(s1 + " g = " + s + " lb");
            }

            //gram(g)-->ounce(oz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)")) {
                String s = String.valueOf(data*(pound/1000)*16);
                to_et.setText(s);
                tvResult.setText(s1 + " g = " + s + " oz");
            }

            //gram(g)-->tonne
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne")) {
                String s = String.valueOf(data/d1);
                to_et.setText(s);
                tvResult.setText(s1 + " g = " + s + " tonne");
            }

            //kilogram(kg)-->kilogram(kg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " kg = " + s + " kg");
            }

            //kilogram(kg)-->miligram(mg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)")) {
                String s = String.valueOf(data*d1);
                to_et.setText(s);
                tvResult.setText(s1 + " kg = " + s + " mg");
            }

            //kilogram(kg)-->gram(g)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " kg = " + s + " g");
            }

            //kilogram(kg)-->pound(lb)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)")) {
                String s = String.valueOf(data*(pound));
                to_et.setText(s);
                tvResult.setText(s1 + " kg = " + s + " lb");
            }

            //kilogram(kg)-->ounce(oz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)")) {
                String s = String.valueOf(data*(pound)*16);
                to_et.setText(s);
                tvResult.setText(s1 + " kg = " + s + " oz");
            }

            //kilogram(kg)-->tonne
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne")) {
                String s = String.valueOf(data/1000);
                to_et.setText(s);
                tvResult.setText(s1 + " kg = " + s + " tonne");
            }

            //pound(lb)-->pound(lb)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " lb = " + s + " lb");
            }

            //pound(lb)-->miligram(mg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)")) {
                String s = String.valueOf(data*(d1/pound));
                to_et.setText(s);
                tvResult.setText(s1 + " lb = " + s + " mg");
            }

            //pound(lb)-->gram(g)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)")) {
                String s = String.valueOf(data*(1000/pound));
                to_et.setText(s);
                tvResult.setText(s1 + " lb = " + s + " g");
            }

            //pound(lb)-->kilogram(kg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)")) {
                String s = String.valueOf(data/pound);
                to_et.setText(s);
                tvResult.setText(s1 + " lb = " + s + " kg");
            }

            //pound(lb)-->ounce(oz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)")) {
                String s = String.valueOf(data*16);
                to_et.setText(s);
                tvResult.setText(s1 + " lb = " + s + " oz");
            }

            //pound(lb)-->tonne
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne")) {
                String s = String.valueOf(data/(pound*1000));
                to_et.setText(s);
                tvResult.setText(s1 + " lb = " + s + " tonne");
            }

            //ounce(oz)-->ounce(oz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " oz = " + s + " oz");
            }

            //ounce(oz)-->miligram(mg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)")) {
                String s = String.valueOf((data*d1)/(pound*16));
                to_et.setText(s);
                tvResult.setText(s1 + " oz = " + s + " mg");
            }

            //ounce(oz)-->gram(g)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)")) {
                String s = String.valueOf((data*1000)/(pound*16));
                to_et.setText(s);
                tvResult.setText(s1 + " oz = " + s + " g");
            }

            //ounce(oz)-->kilogram(kg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)")) {
                String s = String.valueOf(data/(pound*16));
                to_et.setText(s);
                tvResult.setText(s1 + " oz = " + s + " kg");
            }

            //ounce(oz)-->pound(lb)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)")) {
                String s = String.valueOf(data/16);
                to_et.setText(s);
                tvResult.setText(s1 + " oz = " + s + " lb");
            }

            //ounce(oz)-->tonne
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne")) {
                String s = String.valueOf(data/(pound*1000*16));
                to_et.setText(s);
                tvResult.setText(s1 + " oz = " + s + " tonne");
            }

            //tonne-->tonne
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " tonne = " + s + " tonne");
            }

            //tonne-->miligram(mg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("miligram(mg)")) {
                String s = String.valueOf(data*d2);
                to_et.setText(s);
                tvResult.setText(s1 + " tonne = " + s + " mg");
            }

            //tonne-->gram(g)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram(g)")) {
                String s = String.valueOf(data*d1);
                to_et.setText(s);
                tvResult.setText(s1 + " tonne = " + s + " g");
            }

            //tonne-->kilogram(kg)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kilogram(kg)")) {
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " tonne = " + s + " kg");
            }

            //tonne-->pound(lb)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("pound(lb)")) {
                String s = String.valueOf(data*pound*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " tonne = " + s + " lb");
            }

            //tonne-->ounce(oz)
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tonne") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("ounce(oz)")) {
                String s = String.valueOf(data*pound*1000*16);
                to_et.setText(s);
                tvResult.setText(s1 + " tonne = " + s + " oz");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
