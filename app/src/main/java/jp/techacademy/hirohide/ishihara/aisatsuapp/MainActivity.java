package jp.techacademy.hirohide.ishihara.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v.getId() == R.id.button3){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        if(hourOfDay >= 2 && hourOfDay < 10){
                            TextView textView = (TextView)findViewById(R.id.textView);
                            textView.setText("おはよう");
                        }else if(hourOfDay >= 10 && hourOfDay < 18){
                            TextView textView = (TextView)findViewById(R.id.textView);
                            textView.setText("こんにちは");
                        }else if(hourOfDay >= 18 || hourOfDay < 2){
                            TextView textView = (TextView)findViewById(R.id.textView);
                            textView.setText("こんばんは");
                        }
                    }
                },
                13,
                0,
                true);
        timePickerDialog.show();
    }

}
