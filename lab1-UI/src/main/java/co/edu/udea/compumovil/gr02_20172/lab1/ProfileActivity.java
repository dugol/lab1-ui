package co.edu.udea.compumovil.gr02_20172.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView firstNameText, lastNameText, genderText, birthdayText, phoneText, addressText, emailText, cityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firstNameText = (TextView) findViewById(R.id.first_name_info);
        lastNameText = (TextView) findViewById(R.id.last_name_info);
        genderText = (TextView) findViewById(R.id.gender_info);
        birthdayText = (TextView) findViewById(R.id.birthday_info);
        phoneText = (TextView) findViewById(R.id.phone_info);
        addressText = (TextView) findViewById(R.id.address_info);
        emailText = (TextView) findViewById(R.id.email_info);
        cityText = (TextView) findViewById(R.id.city_info);
        firstNameText.setText(getIntent().getStringExtra("KEY_FIRST_NAME"));
        lastNameText.setText(getIntent().getStringExtra("KEY_LAST_NAME"));
        genderText.setText(getIntent().getStringExtra("KEY_GENDER"));
        birthdayText.setText(getIntent().getStringExtra("KEY_BIRTHDAY"));
        phoneText.setText(getIntent().getStringExtra("KEY_PHONE"));
        addressText.setText(getIntent().getStringExtra("KEY_ADDRESS"));
        emailText.setText(getIntent().getStringExtra("KEY_EMAIL"));
        cityText.setText(getIntent().getStringExtra("KEY_CITY"));
    }
}
