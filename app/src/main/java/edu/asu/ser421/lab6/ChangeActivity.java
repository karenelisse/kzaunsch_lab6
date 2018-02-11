package edu.asu.ser421.lab6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Button;
import android.widget.Toast;
import android.content.Context;
import android.widget.CheckBox;
import java.util.ArrayList;
import static android.widget.Toast.*;


public class ChangeActivity extends AppCompatActivity {
    CheckBox checkbox_Sydney;
    CheckBox checkbox_Dili;
    CheckBox checkbox_Bucharest;
    CheckBox checkbox_Dubai;
    CheckBox checkbox_Bali;
    CheckBox checkbox_Wollongong;
    CheckBox checkbox_Komodo;
    CheckBox checkbox_Kandahar;
    CheckBox checkbox_Manila;
    CheckBox checkbox_Casablanca;
    Button goButton;

    public static String city1;
    public static String city2;
    public static String city3;
    public static String city4;
    public static String city5;
    public static ArrayList<String> citylist = new ArrayList<String>();
    public String thirdCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        checkbox_Sydney = (CheckBox) findViewById(R.id.checkbox_Sydney);
        checkbox_Dili = (CheckBox) findViewById(R.id.checkbox_Dili);
        checkbox_Dili.setEnabled(true);
        checkbox_Bucharest = (CheckBox) findViewById(R.id.checkbox_Bucharest);
        checkbox_Bucharest.setEnabled(true);
        checkbox_Dubai = (CheckBox) findViewById(R.id.checkbox_Dubai);
        checkbox_Dubai.setEnabled(true);
        checkbox_Bali = (CheckBox) findViewById(R.id.checkbox_Bali);
        checkbox_Bali.setEnabled(true);
        checkbox_Wollongong = (CheckBox) findViewById(R.id.checkbox_Wollongong);
        checkbox_Wollongong.setEnabled(true);
        checkbox_Komodo = (CheckBox) findViewById(R.id.checkbox_Komodo);
        checkbox_Komodo.setEnabled(true);
        checkbox_Kandahar = (CheckBox) findViewById(R.id.checkbox_Kandahar);
        checkbox_Kandahar.setEnabled(true);
        checkbox_Manila = (CheckBox) findViewById(R.id.checkbox_Manila);
        checkbox_Manila.setEnabled(true);
        checkbox_Casablanca = (CheckBox) findViewById(R.id.checkbox_Casablanca);
        checkbox_Casablanca.setEnabled(true);
        goButton = (Button) findViewById(R.id.button3);

        if (citylist.isEmpty()){
            citylist.clear();
            //chooses 5 to set as checked
            checkbox_Sydney.setChecked(true);
            citylist.add("Sydney");
            checkbox_Dili.setChecked(true);
            citylist.add("Dili");
            checkbox_Bucharest.setChecked(true);
            citylist.add("Bucharest");
            checkbox_Dubai.setChecked(true);
            citylist.add("Dubai");
            checkbox_Bali.setChecked(true);
            citylist.add("Bali");
        }
        else{
            if (citylist.contains("Sydney")){
                checkbox_Sydney.setChecked(true);
            }
            if (citylist.contains("Dili")){
                checkbox_Dili.setChecked(true);
            }
            if (citylist.contains("Bucharest")){
                checkbox_Bucharest.setChecked(true);
            }
            if (citylist.contains("Dubai")){
                checkbox_Dubai.setChecked(true);
            }
            if (citylist.contains("Bali")){
                checkbox_Bali.setChecked(true);
            }
            if (citylist.contains("Wollongong")){
                checkbox_Wollongong.setChecked(true);
            }
            if (citylist.contains("Komodo")){
                checkbox_Komodo.setChecked(true);
            }
            if (citylist.contains("Kandahar")){
                checkbox_Kandahar.setChecked(true);
            }
            if (citylist.contains("Manila")){
                checkbox_Manila.setChecked(true);
            }
            if (citylist.contains("Casablanca")){
                checkbox_Casablanca.setChecked(true);
            }
        }

        //thirdCity = WebAppInterface.getThirdCity();
        thirdCity=MainActivity.saveThirdCity();
        //Log.d("STATE",thirdCity);

        if (thirdCity != null){
            if (thirdCity.equals("Sydney")){
                checkbox_Sydney.setEnabled(false);
                Toast.makeText(getApplicationContext(),"TEST:"+MainActivity.saveThirdCity(),LENGTH_LONG).show();
            }
            else{
                checkbox_Sydney.setEnabled(true);
            }
            if (thirdCity.equals("Dili")){
                checkbox_Dili.setEnabled(false);
            }
            else{
                checkbox_Dili.setEnabled(true);
            }
            if (thirdCity.equals("Bucharest")){
                checkbox_Bucharest.setEnabled(false);
            }
            else{
                checkbox_Bucharest.setEnabled(true);
            }
            if (thirdCity.equals("Dubai")){
                checkbox_Dubai.setEnabled(false);
            }
            else{
                checkbox_Dubai.setEnabled(true);
            }
            if (thirdCity.equals("Bali")){
                checkbox_Bali.setEnabled(false);
            }
            else{
                checkbox_Bali.setEnabled(true);
            }
            if (thirdCity.equals("Wollongong")){
                checkbox_Wollongong.setEnabled(false);
            }
            else{
                checkbox_Wollongong.setEnabled(true);
            }
            if (thirdCity.equals("Komodo")){
                checkbox_Komodo.setEnabled(false);
            }
            else{
                checkbox_Komodo.setEnabled(true);
            }
            if (thirdCity.equals("Kandahar")){
                checkbox_Kandahar.setEnabled(false);
            }
            else{
                checkbox_Kandahar.setEnabled(true);
            }
            if (thirdCity.equals("Manila")){
                checkbox_Manila.setEnabled(false);
            }
            else{
                checkbox_Manila.setEnabled(true);
            }
            if (thirdCity.equals("Casablanca")){
                checkbox_Casablanca.setEnabled(false);
            }
            else{
                checkbox_Casablanca.setEnabled(true);
            }

        }

        /*
         * Sets up the goButton. If the user selects more or less than 5 cities,
         * an error pops up and they don't leave. If they select exactly 5, they will be set.
         */
        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (citylist.size() == 5){
                    city1 = citylist.get(0);
                    city2 = citylist.get(1);
                    city3 = citylist.get(2);
                    city4 = citylist.get(3);
                    city5 = citylist.get(4);

                    Intent mainIntent = new Intent(ChangeActivity.this, MainActivity.class);
                    startActivity(mainIntent);

                }
                //if they chose less or more than 5 cities, it clears all cities (except for greyed out) and has them reselect
                else if (citylist.size() != 5){
                    System.out.println("ERROR!");
                    Toast.makeText(getApplicationContext(), "Please select EXACTLY 5 Cities!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), citylist.toString(), Toast.LENGTH_LONG).show();
                    if (checkbox_Sydney.isChecked() && checkbox_Sydney.isEnabled()){
                        checkbox_Sydney.toggle();
                        citylist.remove("Sydney");
                    }
                    if (checkbox_Dili.isChecked() && checkbox_Dili.isEnabled()){
                        checkbox_Dili.toggle();
                        citylist.remove("Dili");
                    }
                    if (checkbox_Bucharest.isChecked() && checkbox_Bucharest.isEnabled()){
                        checkbox_Bucharest.toggle();
                        citylist.remove("Bucharest");
                    }
                    if (checkbox_Dubai.isChecked() && checkbox_Dubai.isEnabled()){
                        checkbox_Dubai.toggle();
                        citylist.remove("Dubai");
                    }
                    if (checkbox_Bali.isChecked() && checkbox_Bali.isEnabled()){
                        checkbox_Bali.toggle();
                        citylist.remove("Bali");
                    }
                    if (checkbox_Wollongong.isChecked() && checkbox_Wollongong.isEnabled()){
                        checkbox_Wollongong.toggle();
                        citylist.remove("Wollongong");
                    }
                    if (checkbox_Komodo.isChecked() && checkbox_Komodo.isEnabled()){
                        checkbox_Komodo.toggle();
                        citylist.remove("Komodo");
                    }
                    if (checkbox_Kandahar.isChecked() && checkbox_Kandahar.isEnabled()){
                        checkbox_Kandahar.toggle();
                        citylist.remove("Kandahar");
                    }
                    if (checkbox_Manila.isChecked() && checkbox_Manila.isEnabled()){
                        checkbox_Manila.toggle();
                        citylist.remove("Manila");
                    }
                    if (checkbox_Casablanca.isChecked() && checkbox_Casablanca.isEnabled()){
                        checkbox_Casablanca.toggle();
                        citylist.remove("Casablanca");
                    }
                }
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        //clear the array
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_Sydney:
                if (checked){
                    if (!citylist.contains("Sydney")){
                        citylist.add("Sydney");
                    }
                }
                else{
                    if (citylist.contains("Sydney")){
                        citylist.remove("Sydney");
                    }
                }
                break;
            case R.id.checkbox_Dili:
                if (checked){
                    if (!citylist.contains("Dili")){
                        citylist.add("Dili");
                    }
                }
                else{
                    if (citylist.contains("Dili")){
                        citylist.remove("Dili");
                    }
                }
                break;
            case R.id.checkbox_Bucharest:
                if (checked){
                    if (!citylist.contains("Bucharest")){
                        citylist.add("Bucharest");
                    }
                }
                else{
                    if (citylist.contains("Bucharest")){
                        citylist.remove("Bucharest");
                    }
                }
                break;

            case R.id.checkbox_Dubai:
                if (checked){
                    if (!citylist.contains("Dubai")){
                        citylist.add("Dubai");
                    }
                }
                else{
                    if (citylist.contains("Dubai")){
                        citylist.remove("Dubai");
                    }
                }
                break;
            case R.id.checkbox_Bali:
                if (checked){
                    if (!citylist.contains("Bali")){
                        citylist.add("Bali");
                    }
                }
                else{
                    if (citylist.contains("Bali")){
                        citylist.remove("Bali");
                    }
                }
                break;
            case R.id.checkbox_Wollongong:
                if (checked){
                    if (!citylist.contains("Wollongong")){
                        citylist.add("Wollongong");
                    }
                }
                else{
                    if (citylist.contains("Wollongong")){
                        citylist.remove("Wollongong");
                    }
                }
                break;

            case R.id.checkbox_Komodo:
                if (checked){
                    if (!citylist.contains("Komodo")){
                        citylist.add("Komodo");
                    }
                }
                else{
                    if (citylist.contains("Komodo")){
                        citylist.remove("Komodo");
                    }
                }
                break;
            case R.id.checkbox_Kandahar:
                if (checked){
                    if (!citylist.contains("Kandahar")){
                        citylist.add("Kandahar");
                    }
                }
                else{
                    if (citylist.contains("Kandahar")){
                        citylist.remove("Kandahar");
                    }
                }
                break;
            case R.id.checkbox_Manila:
                if (checked){
                    if (!citylist.contains("Manila")){
                        citylist.add("Manila");
                    }
                }
                else{
                    if (citylist.contains("Manila")){
                        citylist.remove("Manila");
                    }
                }
                break;
            case R.id.checkbox_Casablanca:
                if (checked){
                    if (!citylist.contains("Casablanca")){
                        citylist.add("Casablanca");
                    }
                }
                else{
                    if (citylist.contains("Casablanca")){
                        citylist.remove("Casablanca");
                    }
                }
                break;
        }
    }
}
