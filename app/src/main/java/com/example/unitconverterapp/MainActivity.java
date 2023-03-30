
/*
            Name        :  Surpreet Singh
            Student ID  :  218663803
            Unit No.    :  SIT305

 */

package com.example.unitconverterapp;


//importing libraries
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //  Defining variables for the widgets
    EditText value;
    TextView resultTextView;
    Button convertButton;
    Spinner spinnerSource;
    Spinner spinnerDestination;


    //Override function for the onCreate method and its called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); //setting the layout from the activity_main file

        //Referencing to the XML file UI elements
        value = findViewById(R.id.editTextTextPersonName);
        resultTextView= findViewById(R.id.textView2);
        convertButton = findViewById(R.id.button);
        spinnerSource= findViewById(R.id.spinner);
        spinnerDestination= findViewById(R.id.spinner2);

        //Creating an string array for the spinner items
        String[] spinnerValues = {"Inch", "Foot", "Yard", "Mile","Pound", "Ounce", "Ton", "Celsius","Fahrenheit", "Kelvin"};

        //creating ArrayAdapter for the spinner with the spinnerValues array
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerValues);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSource.setAdapter(adapter); // setting the adapter for the Source Spinner
        spinnerDestination.setAdapter(adapter); // setting the adapter for the destination spinner

        //Setting an onClickListener for the convertButton. so this function will be called when convertButton is clicked
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    // using a try{} to catch any exception during the runtime
                    try {
                        String inputValue  = value.getText().toString();   // assigning the input value (put in by the user ) to the inputValue variable
                        double inputValueDouble = Double.parseDouble(inputValue);  // converting the string value to double
                        String sourceUnit = spinnerSource.getSelectedItem().toString();  // Assigning the selected value from the source spinner to sourceUnit variable
                        String destinationUnit = spinnerDestination.getSelectedItem().toString();  // Assigning the selected value from the destination spinner to destinationUnit variable
                        double resultValue = convert(sourceUnit,destinationUnit,inputValueDouble);  // calling the convert() method to perform the calculation based on the parameters and storing the returned value in resultValue variable
                        resultTextView.setText("" + resultValue + " " + destinationUnit );   //setting the resultTextView with the output value

                    }catch (NumberFormatException e) {           // catching an exception if the input values cannot be parsed as a double
                        resultTextView.setText("Please enter a correct value");  //setting the resultTextView with the error message
                    }catch (RuntimeException e){                   // catching an exception if the units selected are not correct
                        resultTextView.setText("Please Select the correct units");  //setting the resultTextView with the error message
                    }





            }
        });





    }
    // Convert() method to perform all the necessary conversions
    private double convert(String sourceUnit, String destinationUnit, double inputValue){

        double result;   // declaring variable to store result of the calculations
        //Switch case for the source unit
        switch (sourceUnit){
            case "Inch":
                //switch case for the destination unit
                switch (destinationUnit) {
                    case "Inch":
                        result = inputValue;
                        return result;

                    case "Foot":
                        result = (inputValue * 2.54) / 30.48;   // method used for conversion: result = (inputValue * sourceUnitFactor) / destinationUnitFactor
                        return result;

                    case "Yard":
                        result = (inputValue * 2.54) / 91.44;
                        return result;

                    case "Mile":
                        result = (inputValue * 2.54) /  160934;
                        return result;

                    default:
                        throw new RuntimeException();    // throwing a runtimeException if the destination unit is not one of the suitable conversion unit



                }

            //Similarly performing the conversion with same idea
            case "Foot":
                switch (destinationUnit) {
                    case "Inch":
                        result = (inputValue * 30.48) / 2.54;
                        return result;

                    case "Foot":
                        result = inputValue;
                        return result;

                    case "Yard":
                        result = (inputValue * 30.48) / 91.44;
                        return result;

                    case "Mile":
                        result = (inputValue * 30.48) / 160934;
                        return result;

                    default:
                        throw new RuntimeException();


                }
            //Similarly performing the conversion with same idea
            case "Yard":
                switch (destinationUnit) {
                    case "Inch":
                        result = (inputValue * 91.44) / 2.54;
                        return result;

                    case "Foot":
                        result = (inputValue * 91.44) / 30.48;
                        return result;

                    case "Yard":
                        result = inputValue;
                        return result;

                    case "Mile":
                        result = (inputValue * 91.44) / 160934;
                        return result;

                    default:
                        throw new RuntimeException();

                }

            //Similarly performing the conversion with same idea
            case "Mile":
                switch (destinationUnit) {
                    case "Inch":
                        result = (inputValue * 160934) / 2.54 ;
                        return result;

                    case "Foot":
                        result = (inputValue * 160934) / 30.48;
                        return result;

                    case "Yard":
                        result = (inputValue * 160934) / 91.44;
                        return result;

                    case "Mile":
                        result = inputValue;
                        return result;

                    default:
                        throw new RuntimeException();

                }
            //Similarly performing the conversion with same idea
            case "Pound":
                switch (destinationUnit) {
                    case "Pound":
                        result = inputValue;
                        return result;

                    case "Ounce":
                        result = (inputValue * 0.453592) / 0.0283495;
                        return result;

                    case "Ton":
                        result = (inputValue * 0.453592) / 907.185;
                        return result;

                    default:
                        throw new RuntimeException();

                }
            //Similarly performing the conversion with same idea
            case "Ounce":
                switch (destinationUnit) {
                    case "Pound":
                        result = (inputValue * 0.0283495) / 0.453592 ;
                        return result;

                    case "Ounce":
                        result = inputValue;
                        return result;

                    case "Ton":
                        result = (inputValue * 0.0283495) / 907.185;
                        return result;

                    default:
                        throw new RuntimeException();

                }


            //Similarly performing the conversion with same idea
            case "Ton":
                switch (destinationUnit) {
                    case "Pound":
                        result = (inputValue * 907.158) / 0.453592;
                        return result;

                    case "Ounce":
                        result = (inputValue * 907.158) / 0.0283495;
                        return result;

                    case "Ton":
                        result = inputValue;
                        return result;

                    default:
                        throw new RuntimeException();

                }


            //Similarly performing the conversion with same idea
            case "Celsius":
                switch (destinationUnit) {
                    case "Fahrenheit":
                        result = (inputValue * 1.8) + 32;
                        return result;

                    case "Kelvin":
                        result = inputValue + 273.15;
                        return result;

                    case "Celsius":
                        result = inputValue;
                        return result;


                    default:
                        throw new RuntimeException();

                }
            //Similarly performing the conversion with same idea
            case "Fahrenheit":
                switch (destinationUnit) {
                    case "Fahrenheit":
                        result = inputValue;
                        return result;

                    case "Kelvin":
                        double r1 =  (inputValue - 32) / 1.8;
                        result = r1 + 273.15;
                        return result;

                    case "Celsius":
                        result = (inputValue - 32) / 1.8;
                        return result;


                    default:
                        throw new RuntimeException();

                }
            //Similarly performing the conversion with same idea
            case "Kelvin":
                switch (destinationUnit) {
                    case "Fahrenheit":
                        double r1 = inputValue - 273.15;
                        result = (r1 * 1.8) + 32;
                        return result;

                    case "Kelvin":
                        result = inputValue;
                        return result;

                    case "Celsius":
                        result = inputValue - 273.15;
                        return result;


                    default:
                        throw new RuntimeException();

                }


            default:
                throw new RuntimeException();  // throwing runtimeException if the conversion units are not suitable


        }


    }

}