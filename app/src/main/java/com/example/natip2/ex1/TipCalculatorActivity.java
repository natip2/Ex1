package com.example.natip2.ex1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends ActionBarActivity {
    static final double TIP = 0.12;

    private View.OnClickListener p = new View.OnClickListener(){

       public void onClick(View v){

           EditText insertedVal = (EditText)findViewById(R.id.edtBillAmount);
           double result = Double.parseDouble(insertedVal.getText().toString())*TIP;
           CheckBox box = (CheckBox)findViewById(R.id.chkRound);
           String message ="Total tip: ";
           if(box.isChecked()){
               Integer rounded =(int)Math.round(result);
               message += rounded.toString();
           }else{
               message = message+String.format("%.2f",result );
           }

            TextView resultBox = (TextView)findViewById(R.id.txtTipResult);
           resultBox.setText(message);

       }




    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        Button button = (Button)findViewById(R.id.btnCalculate);
        button.setOnClickListener(p);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
