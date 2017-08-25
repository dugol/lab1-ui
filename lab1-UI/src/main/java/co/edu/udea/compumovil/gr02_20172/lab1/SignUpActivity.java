package co.edu.udea.compumovil.gr02_20172.lab1;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.DialogFragment;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.util.ArrayList;

import gun0912.tedbottompicker.TedBottomPicker;

import static co.edu.udea.compumovil.gr02_20172.lab1.R.array.cities;

/**
 * Created by user on 22/08/2017.
 */

public class SignUpActivity extends AppCompatActivity{
    private EditText firstNameSign, lastNameSign, birthdaySign, phoneSign, addressSign, emailSign, passwordSign;
    private RadioGroup genderSign;
    private RadioButton genderSignOp;
    private AutoCompleteTextView citySign;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_view);
        firstNameSign = (EditText)findViewById(R.id.first_name);
        lastNameSign = (EditText)findViewById(R.id.last_name);
        birthdaySign = (EditText)findViewById(R.id.birthday);
        phoneSign = (EditText)findViewById(R.id.phone);
        addressSign = (EditText)findViewById(R.id.address);
        emailSign = (EditText)findViewById(R.id.email);
        passwordSign = (EditText)findViewById(R.id.password);
        ArrayAdapter<String> citiesArray = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cities));
        citySign = (AutoCompleteTextView)findViewById(R.id.city);
        citySign.setAdapter(citiesArray);
        genderSign = (RadioGroup)findViewById(R.id.genderRadio);

    }


    public void rbclick(View v)
    {
        int genderSignId = genderSign.getCheckedRadioButtonId();
        genderSignOp = (RadioButton)findViewById(genderSignId);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send:
                if(firstNameSign.getText().toString().equals("") || lastNameSign.getText().toString().equals("") || birthdaySign.getText().toString().equals("") || phoneSign.getText().toString().equals("") || addressSign.getText().toString().equals("") || emailSign.getText().toString().equals("") || citySign.getText().toString().equals("") || genderSignOp.getText().toString().equals(null))
                {
                    Toast toast2 = Toast.makeText(getApplicationContext(),getString(R.string.warning2), Toast.LENGTH_SHORT);
                    toast2.show();
                }
                else {
                    Intent toApartment = new Intent(getApplicationContext(), ApartmentActivity.class);
                    toApartment.putExtra("KEY_FIRST_NAME", firstNameSign.getText().toString());
                    toApartment.putExtra("KEY_LAST_NAME", lastNameSign.getText().toString());
                    toApartment.putExtra("KEY_GENDER", genderSignOp.getText().toString());
                    toApartment.putExtra("KEY_BIRTHDAY", birthdaySign.getText().toString());
                    toApartment.putExtra("KEY_PHONE", phoneSign.getText().toString());
                    toApartment.putExtra("KEY_ADDRESS", addressSign.getText().toString());
                    toApartment.putExtra("KEY_EMAIL", emailSign.getText().toString());
                    toApartment.putExtra("KEY_PASSWORD",passwordSign.getText());
                    toApartment.putExtra("KEY_CITY", citySign.getText().toString());
                    startActivity(toApartment);
                    finish();
                }
                break;

            case R.id.birthday:
                DialogFragment newFragment = new DatePickerFragment(view);
                newFragment.show(getSupportFragmentManager(), "datePicker");
                break;

        }
    }
}
