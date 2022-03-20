package com.mrt.indeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etHeight,etWeight,etAge;
    Button btn;
    RadioGroup rg;
    RadioButton rbG,rbL;
    TextView tv1,tv2;

    double bmi=0,fat=0;
    double height,weight;
    int age;
    String result="",result2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = (EditText) findViewById(R.id.etHeight);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etAge = (EditText) findViewById(R.id.etAge);
        btn = (Button) findViewById(R.id.button);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        rg = (RadioGroup) findViewById(R.id.radioGroup2);
        //String value = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbGentleman:
                        Toast.makeText(MainActivity.this,"Erkek",Toast.LENGTH_SHORT).show();
                        height = Double.valueOf(etHeight.getText().toString());
                        weight = Double.valueOf(etWeight.getText().toString());
                        age = Integer.valueOf(etAge.getText().toString());
                        bmi = weight/(height*height);
                        result = "BMI:"+bmi;

                        fat = (1.20*bmi)+(0.23*age)-10.8-5.4;
                        result2 = "Fat:"+fat;
                        break;
                    case R.id.rbLady:
                        Toast.makeText(MainActivity.this,"Kadın",Toast.LENGTH_SHORT).show();
                        height = Double.valueOf(etHeight.getText().toString());
                        weight = Double.valueOf(etWeight.getText().toString());
                        age = Integer.valueOf(etAge.getText().toString());
                        bmi = weight/(height*height);
                        result = "BMI:"+bmi;

                        fat = (1.20*bmi)+(0.23*age)-5.4;
                        result2 = "Fat:"+fat;
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,result2,Toast.LENGTH_SHORT).show();
                tv1.setText(result);
                tv2.setText(result2);
            }
        });
    }
}