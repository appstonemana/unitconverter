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

public class AngleActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et,to_et;
    Spinner from_spinner,to_spinner;
    Button convertBtn,clearBtn;
    TextView tvResult;

    public static final double PI = 3.1428571428d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.angle_activity);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Angle");

        toolbar.setLogo(R.drawable.angle_icon);
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

        fromList.add("degrees/deg");
        fromList.add("full circle");
        fromList.add("grad");
        fromList.add("radians/rad");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("degrees/deg");
        tolist.add("full circle");
        tolist.add("grad");
        tolist.add("radians/rad");

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
                msg="Refresh";
                break;
        }
        Toast.makeText(this,msg+"ed", Toast.LENGTH_LONG).show();

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

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("degrees/deg") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("degrees/deg")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " degrees/deg = " + s + " degrees/deg");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("full circle") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("full circle")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " full circle = " + s + " full circle");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("grad") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("grad")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " grad = " + s + " grad");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("radians/rad") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("radians/rad")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " radians/rad = " + s + " radians/rad");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("degrees/deg") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("full circle")) {
                String s = String.valueOf(data/360);
                to_et.setText(s);
                tvResult.setText(s1 + " degrees/deg = " + s + " full circle");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("degrees/deg") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("grad")) {
                String s = String.valueOf(data/0.9);
                to_et.setText(s);
                tvResult.setText(s1 + " degrees/deg = " + s + " grad");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("degrees/deg") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("radians/rad")) {
                String s = String.valueOf(data/57.3);
                to_et.setText(s);
                tvResult.setText(s1 + " degrees/deg = " + s + " radians/rad");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("full circle") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("degrees/deg")) {
                String s = String.valueOf(data*360);
                to_et.setText(s);
                tvResult.setText(s1 + " full circle = " + s + " degrees/deg");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("full circle") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("grad")) {
                String s = String.valueOf(data*400);
                to_et.setText(s);
                tvResult.setText(s1 + " full circle = " + s + " grad");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("full circle") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("radians/rad")) {
                String s = String.valueOf(data*2*PI);
                to_et.setText(s);
                tvResult.setText(s1 + " full circle = " + s + " radians/rad");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("grad") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("degrees/deg")) {
                String s = String.valueOf(data*0.9);
                to_et.setText(s);
                tvResult.setText(s1 + " grad = " + s + " degrees/deg");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("grad") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("full circle")) {
                String s = String.valueOf(data/400);
                to_et.setText(s);
                tvResult.setText(s1 + " grad = " + s + " full circle");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("grad") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("radians/rad")) {
                String s = String.valueOf((data*PI)/200);
                to_et.setText(s);
                tvResult.setText(s1 + " grad = " + s + " radians/rad");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("radians/rad") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("degrees/deg")) {
                String s = String.valueOf(data*57.3);
                to_et.setText(s);
                tvResult.setText(s1 + " radians/rad = " + s + " degrees/deg");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("radians/rad") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("full circle")) {
                String s = String.valueOf(data/(2*PI));
                to_et.setText(s);
                tvResult.setText(s1 + " radians/rad = " + s + " full circle");
            }

            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("radians/rad") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("grad")) {
                String s = String.valueOf((data*200)/PI);
                to_et.setText(s);
                tvResult.setText(s1 + " radians/rad = " + s + " grad");
            }

        }//try
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)
}
