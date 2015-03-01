package com.example.michael.fragmentsprogram;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    int index = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bucketListButton = (Button) findViewById(R.id.bucket_list);
        Button shoppingListButton = (Button) findViewById(R.id.shopping_list);

        final ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
        final BucketListFragment bucketListFragment = new BucketListFragment();

        final FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.list_view_container, bucketListFragment);
        ft.commit();

        bucketListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index != 1) {
                    index = 1;
                    final FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.list_view_container, bucketListFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        shoppingListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index != 2) {
                    index = 2;
                    final FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.list_view_container, shoppingListFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}
