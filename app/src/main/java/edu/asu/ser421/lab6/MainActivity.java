package edu.asu.ser421.lab6;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button goButton;
    private Button changeButton;
    private TextView helloText;
    private Button londonButton;
    private Button phoenixButton;
    private Button city3Button;
    public static String url;
    public static String thirdCity;


    public static String saveThirdCity(){
        thirdCity = WebAppInterface.getThirdCity();
        return thirdCity;
    }

    /*
     * Creates the page
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gets ThirdCity variable, and sets it as Sydney if there isn't one already
        ThirdCity = WebAppInterface.getThirdCity();
        if (ThirdCity == null){
            ThirdCity = "Sydney";
        }

        // Grab our widgets
        goButton = (Button)findViewById(R.id.button);
        changeButton = (Button)findViewById(R.id.button2);
        helloText = (TextView)findViewById(R.id.textView);
        londonButton = (Button)findViewById(R.id.button4);
        phoenixButton = (Button)findViewById(R.id.button5);
        city3Button = (Button)findViewById(R.id.button6);
        //Changes the name of the button to the ThirdCity
        city3Button.setText(ThirdCity);


        //Listener for when button is clicked
        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent webIntent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(webIntent);
            }
        });

        //sets up london button to send to London Wikipedia page
        londonButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                url = "https://en.m.wikipedia.org/wiki/London";
                Intent webIntent = new Intent(MainActivity.this, WebCityActivity.class);
                startActivity(webIntent);
            }
        });

        //sets up Phoenix button to send to Phoenix City-Data page
        phoenixButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                url = "http://www.city-data.com/cityw/Phoenix-AZ.html";
                Intent webIntent = new Intent(MainActivity.this, WebCityActivity.class);
                startActivity(webIntent);
            }
        });

        //sets up third button. Based off of the city name, it chooses which site to go to.
        city3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String compareCity = WebAppInterface.getThirdCity();
                if(ThirdCity == "Sydney"){
                    url = "https://en.m.wikipedia.org/wiki/Sydney";
                }
                else if (WebAppInterface.getThirdCity().equals("Dili")){
                    url = "https://en.m.wikipedia.org/wiki/Dili";
                }
                else if (WebAppInterface.getThirdCity().equals("Bucharest")){
                    url = "https://en.m.wikipedia.org/wiki/Bucharest";
                }
                else if (WebAppInterface.getThirdCity().equals("Dubai")){
                    url = "https://en.m.wikipedia.org/wiki/Dubai";
                }
                else if (WebAppInterface.getThirdCity().equals("Bali")){
                    url = "https://en.m.wikipedia.org/wiki/Bali";
                }
                else if (WebAppInterface.getThirdCity().equals("Wollongong")){
                    url = "https://en.m.wikipedia.org/wiki/Wollongong";
                }
                else if (WebAppInterface.getThirdCity().equals("Komodo")){
                    url = "https://en.m.wikipedia.org/wiki/Komodo_(island)";
                }
                else if (WebAppInterface.getThirdCity().equals("Kandahar")){
                    url = "https://en.m.wikipedia.org/wiki/Kandahar";
                }
                else if (WebAppInterface.getThirdCity().equals("Manila")){
                    url = "https://en.m.wikipedia.org/wiki/Manila";
                }
                else if (WebAppInterface.getThirdCity().equals("Casablanca")){
                    url = "https://en.m.wikipedia.org/wiki/Casablanca";
                }
                else{
                    Toast.makeText(getApplicationContext(),"Oops! You haven't chosen a third city, yet.",Toast.LENGTH_SHORT).show();
                    url = "https://en.m.wikipedia.org/wiki/Nothing";
                }
                Intent webIntent = new Intent(MainActivity.this, WebCityActivity.class);
                startActivity(webIntent);
            }
        });

        /*
         * Adds the listener for when "CHANGE" button is pressed
         * Goes to a page which allows the user to have an option of 10 different cities.
         */
        changeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent webIntent = new Intent(MainActivity.this, ChangeActivity.class);
                startActivity(webIntent);

            }
        });


    }
    //gets ThirdCity from WebAppInterface
    public String ThirdCity = WebAppInterface.getThirdCity();
}