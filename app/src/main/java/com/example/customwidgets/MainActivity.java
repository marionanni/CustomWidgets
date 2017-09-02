package com.example.customwidgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Busola northDirection = (Busola) findViewById(R.id.northDirection);
        final EditText rotateText = (EditText) findViewById(R.id.rotateText);
//        northDirection.setValue(valueSelector.getValue());

        Button rotateButton = (Button) findViewById(R.id.rotateButton);
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                northDirection.setValue((Integer.parseInt(rotateText.getText().toString())* 3.6f  + 360 ) % 360);
            }
        });
    }
}
