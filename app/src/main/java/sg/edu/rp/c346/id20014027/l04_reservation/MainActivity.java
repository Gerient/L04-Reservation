package sg.edu.rp.c346.id20014027.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText mobileNo;
    EditText groupSize;
    CheckBox cbSmoking;
    DatePicker dp;
    TimePicker tp;
    Button btnReserve;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        mobileNo = findViewById(R.id.editTextMobileNumber);
        groupSize = findViewById(R.id.editTextGroupSize);
        cbSmoking = findViewById(R.id.checkBox);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);

        tp.setIs24HourView(true);
        dp.updateDate(2020, 5, 1 );
        tp.setHour(19);
        tp.setMinute(30);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cbSmoke;
                Editable custName = name.getText();
                Editable phoneNo = mobileNo.getText();
                Editable groupPax = groupSize.getText();
                int year = dp.getYear();
                int month = dp.getMonth();
                int day = dp.getDayOfMonth();
                String date = year + "/" + month + "/" + day;

                if(cbSmoking.isChecked()){
                    cbSmoke = "Yes";
                }
                else{
                    cbSmoke = "No";
                }
                if(name.getText().toString().length() !=0 && mobileNo.getText().toString().length() !=0 && groupSize.getText().toString().length() !=0){
                    String msg = "Hello " + custName + " your reservation for group of " + groupPax + " under the number of " + phoneNo
                            + " for " + "date" + " is successful!";
                    Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    String msg2 = "Your reservation was unsuccessful";
                    Toast toast = Toast.makeText(MainActivity.this, msg2, Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                mobileNo.setText("");
                groupSize.setText("");
                dp.updateDate(2020, 5, 1);
                tp.setHour(19);
                tp.setMinute(30);

                Toast toast = Toast.makeText(MainActivity.this, "Reset Successful!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}