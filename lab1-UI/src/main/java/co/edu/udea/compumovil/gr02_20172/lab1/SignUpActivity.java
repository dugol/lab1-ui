package co.edu.udea.compumovil.gr02_20172.lab1;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

import gun0912.tedbottompicker.TedBottomPicker;

import static co.edu.udea.compumovil.gr02_20172.lab1.R.array.cities;

/**
 * Created by user on 22/08/2017.
 */

public class SignUpActivity extends AppCompatActivity{
    private EditText firstNameSign, lastNameSign, birthdaySign, phoneSign, addressSign, emailSign;
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
        ArrayAdapter<String> citiesArray = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cities));
        citySign = (AutoCompleteTextView)findViewById(R.id.city);
        citySign.setAdapter(citiesArray);
        genderSign = (RadioGroup)findViewById(R.id.genderRadio);
        /*PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(SignUpActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(SignUpActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }


        };
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage(R.string.address)
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();
        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(SignUpActivity.this)
                .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
                    @Override
                    public void onImageSelected(Uri uri) {
                        // here is selected uri
                    }
                })
                .create();
        tedBottomPicker.show(getSupportFragmentManager());*/
    }

    public void rbclick(View v)
    {
        int genderSignId = genderSign.getCheckedRadioButtonId();
        genderSignOp = (RadioButton)findViewById(genderSignId);
    }

//firstNameSign, lastNameSign, birthdaySign, phoneSign, addressSign, emailSign
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send:
                if(firstNameSign.getText().toString().equals(null) || lastNameSign.getText().toString().equals(null) || birthdaySign.getText().toString().equals(null) || phoneSign.getText().equals(null) || addressSign.getText().equals(null) || emailSign.getText().equals(null) || citySign.getText().equals(null) || genderSignOp.getText().equals(null))
                {
                    Toast toast2 = Toast.makeText(getApplicationContext(),getString(R.string.warning2), Toast.LENGTH_SHORT);
                    toast2.show();
                }
                else {
                    Intent toProfile = new Intent(getApplicationContext(), ProfileActivity.class);
                    toProfile.putExtra("KEY_FIRST_NAME", firstNameSign.getText().toString());
                    toProfile.putExtra("KEY_LAST_NAME", lastNameSign.getText().toString());
                    toProfile.putExtra("KEY_GENDER", genderSignOp.getText().toString());
                    toProfile.putExtra("KEY_BIRTHDAY", birthdaySign.getText().toString());
                    toProfile.putExtra("KEY_PHONE", phoneSign.getText().toString());
                    toProfile.putExtra("KEY_ADDRESS", addressSign.getText().toString());
                    toProfile.putExtra("KEY_EMAIL", emailSign.getText().toString());
                    toProfile.putExtra("KEY_CITY", citySign.getText().toString());
                    startActivity(toProfile);
                }
                break;

            case R.id.birthday:
                DialogFragment newFragment = new DatePickerFragment(view);
                newFragment.show(getSupportFragmentManager(), "datePicker");
                break;
        }
    }
}
