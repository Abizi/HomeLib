package com.turkeytech.homelib.Activities.MainActivity;

import android.Manifest;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.turkeytech.homelib.R;
import com.turkeytech.homelib.Test;
import com.turkeytech.homelib.Activities.PdfReaderActivity.PdfReaderActivity;
import com.turkeytech.homelib.Activities.SettingsActivity.SettingsActivity;

import static junit.framework.Assert.assertNotNull;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private static final int READ_REQUEST_CODE = 999;
    private static final String TAG = "xix: MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        instantiateDrawerItems(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Feature not yet available", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void resolvePermissionAccess(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this,
                permission) != PackageManager.PERMISSION_GRANTED) {
            if (resolvePermissionRequestRational()) {

                Log.i(TAG, "resolvePermissionAccess: Need this permission idiot!");

            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{permission},
                        requestCode);

            }
        } else {
            //Permission has already been granted
            Log.i(TAG, "resolvePermissionAccess: Already granted!");
        }
    }


    private boolean resolvePermissionRequestRational() {
        // Permission is not granted
        // Should we show an explanation?
        return ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_CONTACTS);
    }

    private void instantiateDrawerItems(Toolbar toolbar) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_books) {
            // Handle action
        } else if (id == R.id.nav_authors) {

        } else if (id == R.id.nav_tags) {

        } else if (id == R.id.nav_favorites) {

        } else if (id == R.id.nav_libraries) {
            startActivity(new Intent(this, Test.class));
        } else if (id == R.id.nav_catalogs) {

        } else if (id == R.id.nav_files) {

            //resolvePermissionAccess(Manifest.permission.WRITE_EXTERNAL_STORAGE, 909);
            performFileSearch();

        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        } else if (id == R.id.nav_about) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void performFileSearch() {

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only pdf files, using the application MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        // To search for multiple document types pass an array of preferred MIME types
        // as an extended data to the intent, with a name of Intent.EXTRA_ALLOW_MULTIPLE.

        intent.setType("*/*");
        String[] mimeTypes = {"application/pdf", "application/epub+zip"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);


        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().

            ClipData clipData;
            Uri uri;

            if (resultData != null) {
                clipData = resultData.getClipData();
                if (clipData != null) {

                    Log.i(TAG, "onActivityResult: got here too");

                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item path = clipData.getItemAt(i);
                        Log.i(TAG, path.toString());
                    }

                } else {
                    uri = resultData.getData();

                    // Todo: Remember to remove this assertion!
                    assertNotNull(uri);

                    try (Cursor cursor = getContentResolver()
                            .query(uri, null, null, null, null, null)) {

                        if (cursor != null && cursor.moveToFirst()) {

                            String displayName = cursor.getString(
                                    cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));

                            if (displayName.endsWith(".pdf")) {

                                Log.i(TAG, "Uri: " + uri.toString());
                                Intent intent = new Intent(this, PdfReaderActivity.class);
                                intent.putExtra("XXX", uri.toString());
                                startActivity(intent);
                            } else {
                                Toast.makeText(this, "Its an epub file", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        }
    }
}
