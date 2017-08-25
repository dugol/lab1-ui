package co.edu.udea.compumovil.gr02_20172.lab1;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UpdateProfileAcitivy extends AppCompatActivity{
        private EditText firstNameUpdate, lastNameUpdate, birthdayUpdate, phoneUpdate, addressUpdate, emailUpdate,passwordUpdate;
        private RadioGroup genderUpdate;
        private RadioButton genderUpdateOp;
        private AutoCompleteTextView cityUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_profile_view);
        firstNameUpdate = (EditText)findViewById(R.id.first_name_update);
        lastNameUpdate = (EditText)findViewById(R.id.last_name_update);
        birthdayUpdate = (EditText)findViewById(R.id.birthday_update);
        phoneUpdate = (EditText)findViewById(R.id.phone_update);
        addressUpdate = (EditText)findViewById(R.id.address_update);
        emailUpdate = (EditText)findViewById(R.id.email_update);
        passwordUpdate = (EditText)findViewById(R.id.password_update);
        ArrayAdapter<String> citiesArray = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cities));
        cityUpdate = (AutoCompleteTextView)findViewById(R.id.city_update);
        cityUpdate.setAdapter(citiesArray);
        genderUpdate = (RadioGroup)findViewById(R.id.genderRadio_update);
        firstNameUpdate.setText(getIntent().getStringExtra("KEY_FIRST_NAME"));
        lastNameUpdate.setText(getIntent().getStringExtra("KEY_LAST_NAME"));
        if(getIntent().getStringExtra("KEY_GENDER").equals(getString(R.string.female)))
        {
            genderUpdateOp = (RadioButton)findViewById(R.id.radio_women);
            genderUpdateOp.setChecked(true);
        }
        else
        {
            genderUpdateOp = (RadioButton)findViewById(R.id.radio_men);
            genderUpdateOp.setChecked(true);
        }
        birthdayUpdate.setText(getIntent().getStringExtra("KEY_BIRTHDAY"));
        phoneUpdate.setText(getIntent().getStringExtra("KEY_PHONE"));
        addressUpdate.setText(getIntent().getStringExtra("KEY_ADDRESS"));
        passwordUpdate.setText(getIntent().getStringExtra("KEY_PASSWORD"));
        emailUpdate.setText(getIntent().getStringExtra("KEY_EMAIL"));
        cityUpdate.setText(getIntent().getStringExtra("KEY_CITY"));
    }


    public void rbclick(View v)
    {
        int genderUpdateId = genderUpdate.getCheckedRadioButtonId();
        genderUpdateOp = (RadioButton)findViewById(genderUpdateId);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_update:
                if(firstNameUpdate.getText().equals(null) || lastNameUpdate.getText().equals(null) || birthdayUpdate.getText().equals(null) || phoneUpdate.getText().equals(null) || addressUpdate.getText().equals(null) || emailUpdate.getText().equals(null) || cityUpdate.getText().equals(null) || genderUpdateOp.getText().equals(null))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.warning2), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Intent toApartment = new Intent(getApplicationContext(), ApartmentActivity.class);
                    toApartment.putExtra("KEY_FIRST_NAME", firstNameUpdate.getText().toString());
                    toApartment.putExtra("KEY_LAST_NAME", lastNameUpdate.getText().toString());
                    toApartment.putExtra("KEY_GENDER", genderUpdateOp.getText().toString());
                    toApartment.putExtra("KEY_BIRTHDAY", birthdayUpdate.getText().toString());
                    toApartment.putExtra("KEY_PHONE", phoneUpdate.getText().toString());
                    toApartment.putExtra("KEY_ADDRESS", addressUpdate.getText().toString());
                    toApartment.putExtra("KEY_EMAIL", emailUpdate.getText().toString());
                    toApartment.putExtra("KEY_PASSWORD",passwordUpdate.getText().toString());
                    toApartment.putExtra("KEY_CITY", cityUpdate.getText().toString());
                    startActivity(toApartment);
                }
                break;

            case R.id.birthday_update:
                DialogFragment newFragment = new DatePickerFragment(view);
                newFragment.show(getSupportFragmentManager(), "datePicker");
                break;
        }
    }

}
