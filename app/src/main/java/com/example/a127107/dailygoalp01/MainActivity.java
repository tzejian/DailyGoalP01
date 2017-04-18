package com.example.a127107.dailygoalp01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.a127107.dailygoalp01.R.id.info;

public class MainActivity extends AppCompatActivity {
    TextView a,b,c;
    RadioGroup rg,rg2,rg3;
    RadioButton rb,rb2,rb3;
    EditText et;



    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String reflection = prefs.getString("reflection","");
        int r1 = prefs.getInt("rg",0);
        int r2 = prefs.getInt("rg2",0);
        int r3 = prefs.getInt("rg3",0);
        et.setText(reflection);
        rg.check(r1);
        rg2.check(r2);
        rg3.check(r3);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button1);
        // Get the RadioGroup object
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg3 = (RadioGroup) findViewById(R.id.radioGroup2);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = (TextView)findViewById(R.id.textView);
                b = (TextView)findViewById(R.id.textView3);
                c = (TextView)findViewById(R.id.textView10);
                et = (EditText)findViewById(R.id.editText);





                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rg.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();


                int selectedButtonId3 = rg3.getCheckedRadioButtonId();

                // Get the radio button object from the Id we had gotten above
                rb = (RadioButton) findViewById(selectedButtonId);
                rb2 = (RadioButton) findViewById(selectedButtonId2);
                rb3 = (RadioButton) findViewById(selectedButtonId3);
                //Show a Toast that display the text on the selected radio button
                //Toast.makeText(getBaseContext(), rb.getText(),
                        //Toast.LENGTH_LONG).show();
                String[] info = {a.getText().toString(),b.getText().toString(),
                        rb.getText().toString(),rb2.getText().toString(),et.getText().toString(),c.getText().toString(),rb3.getText().toString()
                       };


                Intent i = new Intent(MainActivity.this,
                        Main2Activity.class);
                // Pass the String array holding the name & age to new activity
                i.putExtra("info", info);
                // Start the new activity
                startActivity(i);


                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor prefEdit = prefs.edit();

                //set value
                prefEdit.putInt("rg1",selectedButtonId);
                prefEdit.putInt("rg2",selectedButtonId2);
                prefEdit.putInt("rg3",selectedButtonId3);
                prefEdit.putString("reflection",et.getText().toString());

                prefEdit.commit();


            }
        });


    }

}



