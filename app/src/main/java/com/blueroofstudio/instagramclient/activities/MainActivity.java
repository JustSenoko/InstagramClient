package com.blueroofstudio.instagramclient.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.blueroofstudio.instagramclient.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_THEME = "EXTRA_THEME";
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private int themeNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            themeNumber = savedInstanceState.getInt(EXTRA_THEME);
            setActivityTheme();
        }
        initView();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_THEME, themeNumber);
    }

    private void initView() {
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.open_nav_drawer,
                R.string.close_nav_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_fruits, R.id.nav_veggies, R.id.nav_nature)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.theme1:
                themeNumber = 1;
                break;
            case R.id.theme2:
                themeNumber = 2;
                break;
            default:
                themeNumber = 0;
                break;
        }
        recreate();
        return super.onOptionsItemSelected(item);
    }

    private void setActivityTheme() {
        switch (themeNumber) {
            case 1:
                setTheme(R.style.Theme1);
                break;
            case 2:
                setTheme(R.style.Theme2);
                break;
            default:
                setTheme(R.style.AppTheme_NoActionBar);
                break;
        }
    }

}
