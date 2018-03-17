package com.turkeytech.homelib;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test extends AppCompatActivity {

    private static final String TAG = "xix: Test";

    @BindView(R.id.shelf_main)
    RecyclerView mRecyclerView;

    ArrayList<Integer> n = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ButterKnife.bind(this);

        n.add(1);
        n.add(1);
        n.add(1);
        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);
//        n.add(1);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float height = convertPixelsToDp(displayMetrics.heightPixels, this);
        float width = convertPixelsToDp(displayMetrics.widthPixels, this);

        int numRows = Math.round(height / 200);

        log(height, width);

        Log.i(TAG, "onCreate: n.size() = " + n.size());
        Log.i(TAG, "onCreate: numRows = " + numRows);
        Log.i(TAG, "onCreate: Modulus" + n.size() % numRows);

        if (n.size() > (numRows * 3)) {


            if ((n.size() % numRows) != 3) {
                numRows = (n.size() / 3) + 1;
            } else {
                numRows = n.size() / 3;
            }
        }

        Log.i(TAG, "onCreate: " + height / 3);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new TestShelveAdapter(n, numRows));
    }

    private void log(float height, float width) {
        Log.i(TAG, "onCreate: Height: " + height + "dp");
        Log.i(TAG, "onCreate: Width: " + width + "dp");

        Log.i(TAG, "onCreate: Height-Rows: " + height / 200);
        Log.i(TAG, "onCreate: Width-Rows : " + width / 200);
        Log.i(TAG, "onCreate: Height-Rows: " + Math.ceil(height / 200));
        Log.i(TAG, "onCreate: Width-Rows : " + Math.ceil(width / 200));
    }



    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }


}
