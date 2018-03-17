package com.turkeytech.homelib.Activities.PdfReaderActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.turkeytech.homelib.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PdfReaderActivity extends AppCompatActivity {

    //The tag is used for debugging purposes
    private static final String TAG = "xix: PdfReader";

    // The PdfView widget is bound to the member variable
    // mPdfView
    @BindView(R.id.main_pdf)
    PDFView mPdfView;

    // The ProgressBar widget is bound to the member variable
    // mProgressBar
    @BindView(R.id.pdfReader_progressBar)
    ProgressBar mProgressBar;

    // This view handles the hiding and reappearance of the
    // notification and action bar
    View mDecorView;

    // This flag tracks the current screen state of the activity
    boolean isFullScreen = false;

    // Might be implemented later. Can't see its use as at of
    // now.
    boolean mSwipeHorizontal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);

        // This a very important stuff to call when any of the
        // static annotations in butterknife are used. It binds
        // annotated fields and methods to the current activity.
        ButterKnife.bind(this);

        mDecorView = getWindow().getDecorView();

        // These two methods are called successively to fix the
        // shifting of the pdf document the first time the activity
        // goes fullscreen.
        hideSystemUI();
        showSystemUI();

        Uri uri = Uri.parse(getIntent().getStringExtra("XXX"));
        String displayName;

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {

            try (Cursor cursor = getContentResolver()
                    .query(uri, null, null, null, null, null)) {

                if (cursor != null && cursor.moveToFirst()) {

                    displayName = cursor.getString(
                            cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                    actionBar.setTitle(displayName);
                    Log.i(TAG, "onCreate: " + displayName);
                }
            }
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (uri != null) {
            mPdfView.
                    fromUri(uri)
                    .swipeHorizontal(mSwipeHorizontal)
                    .scrollHandle(new DefaultScrollHandle(this))
                    .onTap(pdfView -> {
                        toggleFullscreen();
                        return true;
                    })
                    .onRender(pdfView -> mProgressBar.setVisibility(View.GONE))
                    .load();
        } else Toast.makeText(this, "Null Bruh!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return (super.onOptionsItemSelected(item));
    }

    // This snippet hides the system bars.
    private void hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    // This snippet shows the system bars. It does this by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }


    public void toggleFullscreen() {
        if (!isFullScreen) {
            showSystemUI();
            isFullScreen = true;
        } else {
            hideSystemUI();
            isFullScreen = false;
        }
    }
}
