package by.lida.dishes;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;


public class MainActivity extends AppCompatActivity {

    private static int LAYOUT = R.layout.activity_main;
    private DrawerLayout drawerLayout;
    private TableLayout contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        contentLayout = (TableLayout) findViewById(R.id.content_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        initNavigationView();
    }

    private void initNavigationView() {
        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            openActivity(menuItem);
                            drawerLayout.closeDrawers();
                            menuItem.setChecked(true);
                            return true;
                        }
                    });
        }
    }

    private void openActivity(MenuItem menuItem) {
        View contentView;
        LayoutInflater inflater = getLayoutInflater();
        contentLayout.removeAllViews();
        switch(menuItem.getItemId()){
            case R.id.navigation_item_1:
                break;
            case R.id.navigation_item_2:
                contentView = inflater.inflate(R.layout.contacts_activity, null);
                contentLayout.addView(contentView);
                break;
            case R.id.navigation_sub_item_1:
                break;

        }
    }


}
