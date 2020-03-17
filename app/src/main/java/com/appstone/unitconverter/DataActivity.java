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

public class DataActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);
        //this.setTitle("Data");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Data");

        toolbar.setLogo(R.drawable.data_icon);
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
        //fromList.add("Choose");
        fromList.add("byte");
        fromList.add("kb");
        fromList.add("mb");
        fromList.add("gb");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();
        //tolist.add("Choose");
        tolist.add("byte");
        tolist.add("kb");
        tolist.add("mb");
        tolist.add("gb");

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
    }

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

    public void convert(View v) {
        try{
            double data = Double.parseDouble(from_et.getText().toString());
            String s1= String.valueOf(from_et.getText());

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("byte") &&
                to_spinner.getSelectedItem().toString().equalsIgnoreCase("byte")){
               // to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " byte = " + s + " byte");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kb")){
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " kb = " + s + " kb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mb")){
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " mb = " + s + " mb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gb")){
                //to_et.setText(String.valueOf(data));
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " gb = " + s + " gb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("byte") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kb")){
                //to_et.setText(String.valueOf(data/1024));
                String s = String.valueOf(data/1024);
                to_et.setText(s);
                tvResult.setText(s1 + " byte = " + s + " kb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("byte") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mb")){
                //to_et.setText(String.valueOf(data/1048576));
                String s = String.valueOf(data/1048576);
                to_et.setText(s);
                tvResult.setText(s1 + " byte = " + s + " mb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("byte") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gb")){
                //to_et.setText(String.valueOf(data/1073741824));
                String s = String.valueOf(data/1073741824);
                to_et.setText(s);
                tvResult.setText(s1 + " byte = " + s + " gb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("byte")){
                //to_et.setText(String.valueOf(data*1024));
                String s = String.valueOf(data*1024);
                to_et.setText(s);
                tvResult.setText(s1 + " kb = " + s + " byte");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mb")){
                //to_et.setText(String.valueOf(data/1024));
                String s = String.valueOf(data/1024);
                to_et.setText(s);
                tvResult.setText(s1 + " kb = " + s + " mb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("kb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gb")){
                //to_et.setText(String.valueOf(data/1048576));
                String s = String.valueOf(data/1048576);
                to_et.setText(s);
                tvResult.setText(s1 + " kb = " + s + " gb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("byte")){
                //to_et.setText(String.valueOf(data*1024));
                String s = String.valueOf(data*1048576);
                to_et.setText(s);
                tvResult.setText(s1 + " mb = " + s + " byte");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kb")){
                //to_et.setText(String.valueOf(data/1024));
                String s = String.valueOf(data*1024);
                to_et.setText(s);
                tvResult.setText(s1 + " mb = " + s + " kb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("mb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("gb")){
                //to_et.setText(String.valueOf(data/1024));
                String s = String.valueOf(data/1024);
                to_et.setText(s);
                tvResult.setText(s1 + " mb = " + s + " gb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("byte")){
                //to_et.setText(String.valueOf(data*1073741824));
                String s = String.valueOf(data*1073741824);
                to_et.setText(s);
                tvResult.setText(s1 + " gb = " + s + " byte");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("kb")){
                //to_et.setText(String.valueOf(data/1048576));
                String s = String.valueOf(data*1048576);
                to_et.setText(s);
                tvResult.setText(s1 + " gb = " + s + " kb");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("gb") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("mb")){
                //to_et.setText(String.valueOf(data/1024));
                String s = String.valueOf(data*1024);
                to_et.setText(s);
                tvResult.setText(s1 + " gb = " + s + " mb");
            }


       }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
