package co.edu.udea.compumovil.gr02_20172.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 22/08/2017.
 */

public class LoginActivity extends AppCompatActivity{
    private EditText emailText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);
        emailText = (EditText)findViewById(R.id.email);
        passwordText = (EditText)findViewById(R.id.password);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_up:
                Intent toSignUp = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(toSignUp);
                break;
            case R.id.log_in:
                if(emailText.getText().toString().equals("admin") && passwordText.getText().toString().equals("admin")) {
                    Log.d("TAG",emailText.getText().toString());
                    Intent toProfile= new Intent(getApplicationContext(), ProfileActivity.class);
                    toProfile.putExtra("KEY_FIRST_NAME","Pepito Andrés");
                    toProfile.putExtra("KEY_LAST_NAME","Pérez Samaria");
                    toProfile.putExtra("KEY_GENDER","Hombre");
                    toProfile.putExtra("KEY_BIRTHDAY","21/07/1993");
                    toProfile.putExtra("KEY_PHONE","3148514700");
                    toProfile.putExtra("KEY_ADDRESS","Crra falsa 123");
                    toProfile.putExtra("KEY_EMAIL","admin");
                    toProfile.putExtra("KEY_CITY","Medellín");
                    startActivity(toProfile);
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.warning),Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
        }
    }


}
