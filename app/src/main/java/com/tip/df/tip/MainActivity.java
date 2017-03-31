package com.tip.df.tip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText)  findViewById(R.id.editText);


        final Bundle bundle = new Bundle();


        Button button = (Button) findViewById(R.id.calculateBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double value = Double.parseDouble(input.getText().toString());
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                intent.putExtra("key", value);
                startActivity(intent);
            }
        });
    }
}
