package com.example.pranaymerchant.algorithmicwealthmanagment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.PorterDuffColorFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pranaymerchant.algorithmicwealthmanagment.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    EditText amountText;
    EditText riskText;
    TextView responseView;
    ProgressBar progressBar;
    static final String API_KEY = "USE_YOUR_OWN_API_KEY";
    static final String API_URL = "https://api.fullcontact.com/v2/person.json?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseView = (TextView) findViewById(R.id.responseView);
        amountText = (EditText) findViewById(R.id.amountText);
        riskText = (EditText) findViewById(R.id.riskText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button queryButton = (Button) findViewById(R.id.queryButton);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RetrieveFeedTask().execute();
            }
        });
    }

    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            responseView.setText("");
        }

        protected String doInBackground(Void... urls) {
            String amount = amountText.getText().toString();
            String risk = riskText.getText().toString();

            String[] stocklist = {"CME" , "CBOE", "USB", "MKTX", "AMTD", "SBUX", "NXPI", "FB", "SFIX", "JNJ", "BRK.B", "CNC", "AAPL", "AMZN", "BIDU", "BABA", "STNE", "ADBE", "TWTR", "IQ"};
            Stock[] stocks = new Stock[40];
            int count = 0;
            for (String s: stocklist) {
                try {
                    String symb = s;
                    String testurl = "https://api.iextrading.com/1.0/stock/" + symb + "/batch?types=quote,news,chart&range=1m&last=10";
                    URL url = new URL(testurl);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            //System.out.println(line);
                            String[] parts = line.split(",");

                            for (String s1: parts) {
                                String[] splits = line.split(",");
                                String openingprice = splits[5];
                                String closingprice = splits[7];
                                String highprice = splits[9];
                                String lowprice = splits[10];
                                String latestprice = splits[11];
                                String vol = splits[15];

                                //System.out.println(openingprice);
                                double latestPrice = Double.parseDouble(latestprice.split(":")[1]);
                                double openingPrice = Double.parseDouble(openingprice.split(":")[1]);
                                double highPrice = Double.parseDouble(highprice.split(":")[1]);
                                double lowPrice = Double.parseDouble(lowprice.split(":")[1]);
                                double closingPrice = Double.parseDouble(closingprice.split(":")[1]);
                                double volume = Double.parseDouble(vol.split(":")[1]);

                                Stock s3 = new Stock(symb, latestPrice , openingPrice, closingPrice, highPrice, lowPrice, volume);
                                stocks[count] = s3;
                                break;

                            }

                        }
                        bufferedReader.close();
                        String value = stringBuilder.toString();
                        //String[] parts = value.split(":");
                        count++;
                    } finally {
                        urlConnection.disconnect();
                    }
                } catch (Exception e) {
                    Log.e("ERROR", e.getMessage(), e);
                    return null;
                }
            }
            Portfolio p = new Portfolio(Double.parseDouble(amount), Double.parseDouble(risk), stocks);
            String[] out = p.getPortfolio();
            String finalout = "";
            for (String o: out) {
                if (o != null) {
                    finalout = finalout + "\n" + o;
                }

            }
            return finalout;
        }

        protected void onPostExecute(String response) {
            if (response == null) {
                response = "THERE WAS AN ERROR";
            }
            progressBar.setVisibility(View.GONE);
            Log.i("INFO", response);
            responseView.setText(response);
            // TODO: check this.exception
            // TODO: do something with the feed
        }




    }
}