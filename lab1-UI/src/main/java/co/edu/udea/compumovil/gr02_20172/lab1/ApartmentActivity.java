package co.edu.udea.compumovil.gr02_20172.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ApartmentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String firstNameApt,lastNameApt,genderApt, birthdayApt, phoneApt, addressApt, emailApt, passwordApt,cityApt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstNameApt = getIntent().getStringExtra("KEY_FIRST_NAME");
        lastNameApt = getIntent().getStringExtra("KEY_LAST_NAME");
        genderApt = getIntent().getStringExtra("KEY_GENDER");
        birthdayApt = getIntent().getStringExtra("KEY_BIRTHDAY");
        phoneApt = getIntent().getStringExtra("KEY_PHONE");
        addressApt = getIntent().getStringExtra("KEY_ADDRESS");
        emailApt = getIntent().getStringExtra("KEY_EMAIL");
        passwordApt = getIntent().getStringExtra("KEY_PASSWORD");
        cityApt = getIntent().getStringExtra("KEY_CITY");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Próximamente apartamentos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.apartment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile_item) {
            Intent toProfile = new Intent(getApplicationContext(),ProfileActivity.class);
            toProfile.putExtra("KEY_FIRST_NAME",firstNameApt);
            toProfile.putExtra("KEY_LAST_NAME",lastNameApt);
            toProfile.putExtra("KEY_GENDER",genderApt);
            toProfile.putExtra("KEY_BIRTHDAY",birthdayApt);
            toProfile.putExtra("KEY_PHONE",phoneApt);
            toProfile.putExtra("KEY_ADDRESS",addressApt);
            toProfile.putExtra("KEY_EMAIL",emailApt);
            toProfile.putExtra("KEY_CITY",cityApt);
            startActivity(toProfile);
        } else if (id == R.id.update_item) {
            Intent toUpdate = new Intent(getApplicationContext(),UpdateProfileAcitivy.class);
            toUpdate.putExtra("KEY_FIRST_NAME",firstNameApt);
            toUpdate.putExtra("KEY_LAST_NAME",lastNameApt);
            toUpdate.putExtra("KEY_GENDER",genderApt);
            toUpdate.putExtra("KEY_BIRTHDAY",birthdayApt);
            toUpdate.putExtra("KEY_PHONE",phoneApt);
            toUpdate.putExtra("KEY_ADDRESS",addressApt);
            toUpdate.putExtra("KEY_EMAIL",emailApt);
            toUpdate.putExtra("KEY_PASSWORD",passwordApt);
            toUpdate.putExtra("KEY_CITY",cityApt);
            startActivity(toUpdate);
        }
        else if (id == R.id.exit_item){
            Intent outApp = new Intent(Intent.ACTION_MAIN);
            outApp.addCategory(Intent.CATEGORY_HOME);
            outApp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(outApp);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
