package com.suhun.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private String[] items = {"item1", "item2", "item3", "item4", "item5"};
    private String tag = MainActivity.class.getSimpleName();
    private TextView date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSpinner();
        date = findViewById(R.id.dateSetting);
    }
    private void initSpinner(){
        spinner = findViewById(R.id.mySpinner);
        arrayAdapter = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, items);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(tag, "+++++position:"+position+"id:"+id+"使用者選擇："+items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void dateSettingFun(View view){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, DatePickerDialog.THEME_DEVICE_DEFAULT_DARK,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(year+"/"+(month+1)+"/"+dayOfMonth);
                    }
                }, 2023, 8, 4);
        datePickerDialog.show();

    }

}