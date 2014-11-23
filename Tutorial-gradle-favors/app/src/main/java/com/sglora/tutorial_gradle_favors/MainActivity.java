package com.sglora.tutorial_gradle_favors;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView buildInfoTextView = (TextView) findViewById(R.id.build_info);
    buildInfoTextView.setText(getString(R.string.build_info, BuildConfig.BUILD_TYPE, BuildConfig.FLAVOR));
  }
}
