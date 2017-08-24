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
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

import gun0912.tedbottompicker.TedBottomPicker;

import static co.edu.udea.compumovil.gr02_20172.lab1.R.array.cities;

/**
 * Created by user on 22/08/2017.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    private AutoCompleteTextView cityAutoComplete;
    private EditText mEditInit;
    int year_x, month_x, day_x;
    static final int DILOG_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_view);
        ArrayAdapter<String> citiesArray = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cities));
        cityAutoComplete = (AutoCompleteTextView)findViewById(R.id.city);
        cityAutoComplete.setAdapter(citiesArray);
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



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send:
                Intent toMainActivity = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(toMainActivity);
                break;

            case R.id.birthday:
                DialogFragment newFragment = new DatePickerFragment(view);
                newFragment.show(getSupportFragmentManager(), "datePicker");
        }
    }
}
