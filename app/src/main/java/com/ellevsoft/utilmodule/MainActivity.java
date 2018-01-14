package com.ellevsoft.utilmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ellevsoft.utility.UtilCommon;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        float aa = UtilCommon.convertDpToPixel(30, this);

    }
}
