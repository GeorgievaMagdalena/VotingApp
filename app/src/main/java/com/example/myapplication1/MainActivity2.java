package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        View v= (View)findViewById(R.id.my_view);

         class TimePickerFragment extends DialogFragment
                implements TimePickerDialog.OnTimeSetListener {

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                return new TimePickerDialog(getActivity(), this, hour, minute,
                        DateFormat.is24HourFormat(getActivity()));
            }

            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //
            }
        }


        class DatePickerFragment extends DialogFragment
                implements DatePickerDialog.OnDateSetListener {

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                // Use the current date as the default date in the picker
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // Create a new instance of DatePickerDialog and return it
                return new DatePickerDialog(requireContext(), this, year, month, day);
            }


            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                // Do something with the date chosen by the user
            }


        }
    }
}