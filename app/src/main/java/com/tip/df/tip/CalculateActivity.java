package com.tip.df.tip;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.id.input;

public class CalculateActivity extends AppCompatActivity {

    TextView textViewTip15;
    TextView textViewTip18;
    TextView textViewTip20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        //Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();

        TextView textView = (TextView) findViewById(R.id.textView2);
        textViewTip15 = (TextView) findViewById(R.id.textViewTip15);
        textViewTip18 = (TextView) findViewById(R.id.textViewTip18);
        textViewTip20 = (TextView) findViewById(R.id.textViewTip20);

        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CalculateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        if(!bundle.isEmpty()) {
            double bill = bundle.getDouble("key");
            calculateTipAmount(bill);
            textView.setText("Bill Amount: $" + String.format("%.2f", bill));
        }
        else {
            System.out.println("bundle is empty.");
        }
    }

    public void calculateTipAmount(double bill) {
        double lowTip = bill * 0.15;
        double medTip = bill * 0.18;
        double highTip = bill * 0.2;

        displayTipAmount(lowTip, medTip, highTip);
    }

    public void displayTipAmount(double l, double m, double h) {
        textViewTip15.setText("15% tip:\t\t\t$" + String.format("%.2f", l));
        textViewTip18.setText("18% tip:\t\t\t$" + String.format("%.2f", m));
        textViewTip20.setText("20% tip:\t\t\t$" + String.format("%.2f", h));

    }
}
