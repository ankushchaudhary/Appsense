package com.example.zorawar.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class but_alarm12 extends AppCompatActivity {

    //public static int value_time=0;
    Button but;
    EditText angle_limit;
    TextView text;
    int temp;
    public static SharedPreferences anglelimitshared;

    // LinearLayout layout = new LinearLayout(this);
    //AlertDialog ad =  new AlertDialog.Builder(this).create();
    //TextView tv1 = new TextView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm12);

        anglelimitshared = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = anglelimitshared.edit();
        temp = anglelimitshared.getInt("angle_limit", 0);
        text = (TextView) findViewById(R.id.disp_text);
        text.setText(String.valueOf(temp));


    }

    public void onClick(View v) {
        but = (Button) findViewById(R.id.but_ala1);
        angle_limit = (EditText) findViewById(R.id.edit_text1);


        if (angle_limit.getText().length() == 0) {
            angle_limit.setError("Please enter some number");
        } else {
            anglelimitshared = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = anglelimitshared.edit();
            // editor.putFloat("time_limit", 0.0f);
            editor.putInt("angle_limit", Integer.parseInt(angle_limit.getText().toString()));
            editor.commit();
            text = (TextView) findViewById(R.id.disp_text);
            temp = anglelimitshared.getInt("angle_limit", 0);
            text.setText(String.valueOf(temp));
            //calculation();
            AlertDialog box = new AlertDialog.Builder(this).create();
            box.setTitle("Confirmation!!!");
            box.setMessage("Inclination Limit set to: " + angle_limit.getText().toString());
            box.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    getWindow().setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                    );
                    Toast.makeText(getApplicationContext(), "Angle Accepted", Toast.LENGTH_SHORT).show();
                }
            });
            //box.setIcon(R.drawable.);

            //  text.setText(value_time);

            box.show();
          //  calculation();
        }

    }

}
