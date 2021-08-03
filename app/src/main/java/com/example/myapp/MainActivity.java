//DEMO VIDEO LINK --> 
//https://youtu.be/uuobqd3qZO0
//ONE DRIVE DIRECTORY LINK
//https://deakin365-my.sharepoint.com/:f:/g/personal/erancie_deakin_edu_au/EgZvwVtNJ_FLjj_OfbKRB24ByOqAcXdhnQPPqD-9CeRfNg

package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

//Activity extending from android parent class for spinner listener --> //https://developer.android.com/guide/topics/ui/controls/spinner#SelectListener
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //global object variables
    Spinner selectUnit;
    EditText unitInput;
    TextView answer1, answer2, answer3, answer1unit, answer2unit, answer3unit;
    Button metreButton, celsiusButton, kilogramButton;
    int spinner_pos;

    //method to clear page on new spinner selection
    public void clearPage(){
        unitInput.setText("");
        answer1.setText("");
        answer2.setText("");
        answer3.setText("");
        answer1unit.setText("");
        answer2unit.setText("");
        answer3unit.setText("");
    }
    //Metre Conversion Function
    public void convertMetre(View view){
        //check spinner index is correct
        if (spinner_pos==0) {
            //get metres
            Float input = Float.parseFloat(unitInput.getText().toString());

            //to centimetre
            Float centRes = input * 100;
            String centString = String.format("%.2f", centRes);
            answer1unit.setText("Centimetres");
            answer1.setText(centString);

            //to foot
            Double footRes = input * 3.2808399;
            String footString = String.format("%.2f", footRes);
            answer2unit.setText("Feet");
            answer2.setText(footString);

            //to inch
            Double inchRes = input * 39.3700787;
            String inchString = String.format("%.2f", inchRes);
            answer3unit.setText("Inches");
            answer3.setText(inchString);
            //Log.v("Answer", centString);
        }
        else { //throw a popup error
            Toast.makeText(MainActivity.this, "OOPS! Select Metres Above.", Toast.LENGTH_SHORT ).show();
            //https://developer.android.com/guide/topics/ui/notifiers/toasts
        }
    }

    //Celsius Conversion Function
    public void convertCelsius(View view){
        if (spinner_pos==1) {
            //get celsius
            Float input = Float.parseFloat(unitInput.getText().toString());

            //to fahrenheit
            Double fahrenRes = input * 33.8;
            String fahrenString = String.format("%.2f", fahrenRes);
            answer1unit.setText("Fahrenheit");
            answer1.setText(fahrenString);

            //to kelvin
            Double kelvinRes = input * 274.15;
            String kelvinString = String.format("%.2f", kelvinRes);
            answer2unit.setText("Kelvin");
            answer2.setText(kelvinString);
        }
        else { //throw a popup error
            Toast.makeText(MainActivity.this, "OOPS! Select Celsius Above.", Toast.LENGTH_SHORT ).show();
            //https://developer.android.com/guide/topics/ui/notifiers/toasts
        }
    }
    //Kilogram Conversion Function
    public void convertKilogram(View view){
        if (spinner_pos==2) {
            //get kilogram
            Float input = Float.parseFloat(unitInput.getText().toString());

            //to gram
            Float gramRes = input * 1000;
            String gramString = String.format("%.2f", gramRes);
            answer1unit.setText("Grams");
            answer1.setText(gramString);

            //to ounce
            Double ounceRes = input * 35.2739619;
            String ounceString = String.format("%.2f", ounceRes);
            answer2unit.setText("Ounces");
            answer2.setText(ounceString);

            //to pound
            Double poundRes = input * 2.20462262;
            String poundString = String.format("%.2f", poundRes);
            answer3unit.setText("Pounds");
            answer3.setText(poundString);
        }
        else { //throw a popup error
            Toast.makeText(MainActivity.this, "OOPS! Select Kilogram Above.", Toast.LENGTH_SHORT ).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind variables to object id's
        selectUnit = findViewById(R.id.selectUnit);
        unitInput = findViewById(R.id.unitInput);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer1unit = findViewById(R.id.answer1unit);
        answer2unit = findViewById(R.id.answer2unit);
        answer3unit = findViewById(R.id.answer3unit);

        //Add click listener as below or via dropdown
        // metreButton.setOnClickListener(new View.OnClickListener(){
        //     @Override
        //     public void onClick(View v){
        //         convertMetre();
        //     }
        // })

        //bind spinner to call onItemSelected() method pass in 'this' activity --> requires 2 methods below
        selectUnit.setOnItemSelectedListener(this); 
    }
    // use this method to get the selectedUnit spinner index/pos
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        this.spinner_pos = pos; //assign to global var
        clearPage();
    }
    public void onNothingSelected(AdapterView<?> parent) { } //no null spinner option
}