package com.example.bmi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etHeight, etWeight, etbmi, etcat;
    Button btncalculate;
    @Override
    public  void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = (EditText)findViewById(R.id.height_field);
        etWeight = (EditText)findViewById(R.id.weight_field);
        etbmi = (EditText)findViewById(R.id.bmi_result);
        etcat = (EditText)findViewById(R.id.bmi_cat);
        btncalculate = (Button)findViewById(R.id.button);


        //action code
        btncalculate.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                try {
                    Double height = Double.parseDouble(etHeight.getText().toString());
                    Double weight = Double.parseDouble(etWeight.getText().toString());
                    // double bmi = Double.parseDouble(etbmi.getText().toString());
                    String cat = "";
                    double bmi;
                    bmi = (weight / (height * height));
                    etbmi.setText(""+bmi);

                    if (bmi >= 30) {
                        cat = "obese";
                    } else if (bmi >= 25 || bmi <= 29.9) {
                        cat = "overweight";
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        cat = "normal weight";
                    } else if (bmi < 18) {
                        cat = "underweight";
                    }
                    etcat.setText(cat);
                }catch(Exception e){
                    Toast.makeText(MainActivity.this, ""+e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
