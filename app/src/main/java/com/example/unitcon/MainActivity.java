    package com.example.unitcon;

    import android.app.Fragment;
    import android.os.Bundle;
    import android.view.MenuItem;
    import android.widget.Toast;

    import androidx.appcompat.app.ActionBarDrawerToggle;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.Toolbar;
    import androidx.core.view.GravityCompat;
    import androidx.drawerlayout.widget.DrawerLayout;

    import com.google.android.material.navigation.NavigationView;


    public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.proToolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.proDrawer);
        NavigationView navigationView = findViewById(R.id.navbar_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EventFragment()).commit();
            navigationView.setCheckedItem(R.id.Event);
            Toast.makeText(MainActivity.this, "My Home", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onBackPressed() {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onNavigationItemSelected( MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Event:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EventFragment()).commit();
                    Toast.makeText(MainActivity.this, "Event fragment", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.Services:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ServicesFragment()).commit();
                    Toast.makeText(MainActivity.this, "Services Fragment", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.BookEvents:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BookEventsFragment()).commit();
                    Toast.makeText(MainActivity.this, "Book Events Fragment", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.Cancel_Event:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CancelEvent()).commit();
                    Toast.makeText(MainActivity.this, "Event Cancel", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.Contact_Us:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ContactUs()).commit();
                    Toast.makeText(MainActivity.this, "Contact Us", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.Feedback:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Feedback()).commit();
                    Toast.makeText(MainActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.user_Packages:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PackagesFragment()).commit();
                    Toast.makeText(MainActivity.this, "Packages", Toast.LENGTH_SHORT).show();
                    break;


            }
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }


    private void moveToFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }
}