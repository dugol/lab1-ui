package co.edu.udea.compumovil.gr02_20172.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 22/08/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_up:
                Intent toSignUp = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(toSignUp);
                break;
        }
    }
}
