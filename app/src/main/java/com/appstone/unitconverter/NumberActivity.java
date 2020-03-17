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
import java.util.Stack;

public class NumberActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText from_et, to_et;
    Spinner from_spinner, to_spinner;
    Button convertBtn, clearBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_activity);
        //this.setTitle("Number");

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Number");

        toolbar.setLogo(R.drawable.num_icon);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        from_et = (EditText) findViewById(R.id.from_et);
        to_et = (EditText) findViewById(R.id.to_et);
        from_spinner = (Spinner) findViewById(R.id.from_spinner);
        to_spinner = (Spinner) findViewById(R.id.to_spinner);
        convertBtn = (Button) findViewById(R.id.button);
        //clearBtn = (Button) findViewById(R.id.clearBtn);
        tvResult = (TextView) findViewById(R.id.tvResult);

        ArrayList<String> fromList = new ArrayList<>();
        fromList.clear();

        fromList.add("Decimal");
        fromList.add("Binary");
        fromList.add("Octal");
        fromList.add("Hexadecimal");
        fromList.add("Roman_Numerics");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, fromList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(adapter1);

        ArrayList<String> tolist = new ArrayList<>();
        tolist.clear();

        tolist.add("Decimal");
        tolist.add("Binary");
        tolist.add("Octal");
        tolist.add("Hexadecimal");
        tolist.add("Roman_Numerics");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, tolist);
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

    public void convert(View v) {

        try {
            double data = Double.parseDouble(from_et.getText().toString());
            String s1 = String.valueOf(from_et.getText());
            Double d1 = Double.valueOf(1000 * 1000);

            //Decimal-->Decimal
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Decimal") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Decimal")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Decimal = " + s + " Decimal");
            }

            //Decimal-->Binary
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Decimal") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Binary")) {
                /*String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Decimal = " + s + " Binary");*/
                String sbin=calculate(2,to_et);
                tvResult.setText(s1 + " Decimal = " + sbin + " Binary");
            }

            //Decimal-->Octal
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Decimal") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Octal")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Decimal = " + s + " Binary");
                String soct=calculate(8,to_et);
                tvResult.setText(s1 + " Decimal = " + soct + " Octal");
            }

            //Decimal-->Hexadecimal
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Decimal") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hexadecimal")) {
                /*String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Decimal = " + s + " Binary");*/
                String shex=calculate(16,to_et);
                tvResult.setText(s1 + " Decimal = " + shex + " Hexadecimal");
            }

            //Binary-->Binary
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Binary") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Binary")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Binary = " + s + " Binary");
            }

            //Octal-->Octal
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Octal") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Octal")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Octal = " + s + " Octal");
            }

            //Hexadecimal-->Hexadecimal
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Hexadecimal") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Hexadecimal")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " Hexadecimal = " + s + " Hexadecimal");
            }

            //Roman_Numerics-->Roman_Numerics
            if (from_spinner.getSelectedItem().toString().equalsIgnoreCase("Roman_Numerics") &&
                    to_spinner.getSelectedItem().toString().equalsIgnoreCase("Roman_Numerics")) {
                String s = String.valueOf(data);
                to_et.setText(s);
                tvResult.setText(s1 + " R_N = " + s + " R_N");
            }

            //http://www.unitconversion.org/unit_converter/numbers.html

        }//try
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Please Enter Number", Toast.LENGTH_LONG).show();
        }
    }//convert(View v)

    public String calculate(int base, TextView txtView)
    {
        StringBuffer buffer=new StringBuffer();
        if(from_et.getText().toString().trim().length()==0)
        {
            txtView.setText("");
            return null;
        }
        try
        {
            Stack<Object> stack=new Stack<Object>();
            int number= Integer.parseInt(from_et.getText().toString());
            while (number>0)
            {
                int remainder=number%base;
                if(remainder<10)
                {
                    stack.push(remainder);
                }
                else
                {
                    switch (remainder)
                    {
                        case 10:
                            stack.push("A");
                            break;
                        case 11:
                            stack.push("B");
                            break;
                        case 12:
                            stack.push("C");
                            break;
                        case 13:
                            stack.push("D");
                            break;
                        case 14:
                            stack.push("E");
                            break;
                        case 15:
                            stack.push("F");
                            break;
                    }
                }
                number/=base;
            }
            //StringBuffer buffer=new StringBuffer();
            while (!stack.isEmpty())
            {
                buffer.append(stack.pop().toString());
            }
            txtView.setText(buffer.toString());
        }
        catch (Exception e)
        {
            txtView.setText(e.getMessage());
        }
        return buffer.toString();
    }

}//class
