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

public class CookingActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cooking_activity);
        //this.setTitle("Cooking");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Cooking");

        toolbar.setLogo(R.drawable.cooking_icon);
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
       // clearBtn= (Button) findViewById(R.id.clearBtn);
        tvResult= (TextView) findViewById(R.id.tvResult);

        ArrayList<String> fromList =new ArrayList<>();
        fromList.clear();

        fromList.add("drop");
        fromList.add("teaspoon");
        fromList.add("tablespoon");
        fromList.add("litre");
        fromList.add("gram");
        fromList.add("cup");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("drop");
        tolist.add("teaspoon");
        tolist.add("tablespoon");
        tolist.add("litre");
        tolist.add("gram");
        tolist.add("cup");

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

            //drop-->drop
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("drop") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("drop")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " drop = " + s + " drop");
            }

            //drop-->teaspoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("drop") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon")) {
                Double d= data*(0.01042);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*(0.01042));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " drop = " + formattedValue + " teaspoon");
            }

            //drop-->tablespoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("drop") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon")) {
                Double d= data*(0.00347);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*(0.01042));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " drop = " + formattedValue + " tablespoon");
            }

            //drop-->litre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("drop") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("litre")) {
                Double d= data*(0.000051);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*(0.01042));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " drop = " + formattedValue + " litre");
            }

            //drop-->gram
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("drop") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram")) {
                Double d= data/20;
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*(0.01042));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " drop = " + formattedValue + " gram");
            }

            //drop-->cup
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("drop") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("cup")) {
                Double d= data*(0.000217);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*(0.01042));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " drop = " + formattedValue + " cup");
            }

            //teaspoon-->teaspoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " teaspoon = " + s + " teaspoon");
            }

            //teaspoon-->drop
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("drop")) {
                String s = String.valueOf(data*96);
                to_et.setText(s);
                tvResult.setText(s1 + " teaspoon = " + s + " drop");
            }

            //teaspoon-->tablespoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon")) {
                Double d= data*(0.3334);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*96);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " teaspoon = " + formattedValue + " tablespoon");
            }

            //teaspoon-->litre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("litre")) {
                Double d= data*(0.00493);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*96);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " teaspoon = " + formattedValue + " litre");
            }

            //teaspoon-->gram
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram")) {
                Double d= data*(2.9573);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*96);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " teaspoon = " + formattedValue + " gram");
            }

            //teaspoon-->cup
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("cup")) {
                Double d= data/48;
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*96);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " teaspoon = " + formattedValue + " cup");
            }

            //tablespoon-->tablespoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " tablespoon = " + s + " tablespoon");
            }

            //tablespoon-->drop
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("drop")) {
                String s = String.valueOf(data*288);
                to_et.setText(s);
                tvResult.setText(s1 + " tablespoon = " + s + " drop");
            }

            //tablespoon-->teaspoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon")) {
                String s = String.valueOf(data*3);
                to_et.setText(s);
                tvResult.setText(s1 + " tablespoon = " + s + " teaspoon");
            }

            //tablespoon-->litre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("litre")) {
                Double d= data*(0.01478);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*(0.01478));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " tablespoon = " + formattedValue + " litre");
            }

            //tablespoon-->gram
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram")) {
                Double d= data*(8.87205);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*(0.01478));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " tablespoon = " + formattedValue + " gram");
            }

            //tablespoon-->cup
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("cup")) {
                Double d= data/16;
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*(0.01478));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " tablespoon = " + formattedValue + " cup");
            }

            //litre-->litre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("litre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("litre")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " litre = " + s + " litre");
            }

            //litre-->drop
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("litre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("drop")) {
                Double d= data*(19476.87);
                String formattedValue = String.format("%.2f", d);
                //String s = String.valueOf(data*(19476.87));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " litre = " + formattedValue + " drop");
            }

            //litre-->teaspoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("litre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon")) {
                Double d= data*(202.884);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*(19476.87));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " litre = " + formattedValue + " teaspoon");
            }

            //litre-->tablespoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("litre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon")) {
                Double d= data*(67.628);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*(19476.87));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " litre = " + formattedValue + " tablespoon");
            }

            //litre-->gram
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("litre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram")) {
                /*Double d= data*(67.628);
                String formattedValue = String.format("%.3f", d);*/
                String s = String.valueOf(data*1000);
                to_et.setText(s);
                tvResult.setText(s1 + " litre = " + s + " gram");
            }

            //litre-->cup
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("litre") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("cup")) {
                Double d= data*(4.226);
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*1000);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " litre = " + formattedValue + " cup");
            }

            //gram-->gram
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " gram = " + s + " gram");
            }

            //gram-->drop
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("drop")) {
                String s = String.valueOf(data*20);
                to_et.setText(s);
                tvResult.setText(s1 + " gram = " + s + " drop");
            }

            //gram-->teaspoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon")) {
                Double d= data*(0.33814);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*20);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " gram = " + formattedValue + " teaspoon");
            }

            //gram-->tablespoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon")) {
                Double d= data*(0.11272);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*20);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " gram = " + formattedValue + " tablespoon");
            }

            //gram-->litre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("litre")) {
                Double d= data/1000;
                String formattedValue = String.format("%.3f", d);
                //String s = String.valueOf(data*20);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " gram = " + formattedValue + " litre");
            }

            //gram-->cup
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gram") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("cup")) {
                Double d= data*(0.007045);
                String formattedValue = String.format("%.6f", d);
                //String s = String.valueOf(data*20);
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " gram = " + formattedValue + " cup");
            }

            //cup-->cup
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("cup") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("cup")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " cup = " + s + " cup");
            }

            //cup-->drop
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("cup") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("drop")) {
                String s = String.valueOf(data*4608);
                to_et.setText(s);
                tvResult.setText(s1 + " cup = " + s + " drop");
            }

            //cup-->teaspoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("cup") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("teaspoon")) {
                String s = String.valueOf(data*48);
                to_et.setText(s);
                tvResult.setText(s1 + " cup = " + s + " teaspoon");
            }

            //cup-->tablespoon
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("cup") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("tablespoon")) {
                String s = String.valueOf(data*16);
                to_et.setText(s);
                tvResult.setText(s1 + " cup = " + s + " tablespoon");
            }

            //cup-->litre
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("cup") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("litre")) {
                Double d= data*(0.2365);
                String formattedValue = String.format("%.5f", d);
                //String s = String.valueOf(data*(0.2365));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cup = " + formattedValue + " litre");
            }

            //cup-->gram
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("cup") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gram")) {
                Double d= data*(141.9529);
                String formattedValue = String.format("%.4f", d);
                //String s = String.valueOf(data*(0.2365));
                to_et.setText(formattedValue);
                tvResult.setText(s1 + " cup = " + formattedValue + " gram");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
