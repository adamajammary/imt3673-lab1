package com.imt3673.lab1.imt3673_lab_01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

public class A1 extends AppCompatActivity {

    /**
     * Initialize S1 and T1 with values from shared preferences, or default values if not set.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        SharedPreferences prefs = getSharedPreferences(Constants.SHARED_PREFS_FILE, 0);
        SeekBar           s1    = findViewById(R.id.S1);
        Spinner           l1    = findViewById(R.id.L1);

        if (s1 != null)
            s1.setProgress(prefs.getInt(Constants.SHARED_PREFS_S1, 0));

        if (l1 != null)
            l1.setSelection(prefs.getInt(Constants.SHARED_PREFS_L1, 0));
    }

    /**
     * Save state of S1 and T1 to shared preferences
     */
    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences        prefs  = getSharedPreferences(Constants.SHARED_PREFS_FILE, 0);
        SharedPreferences.Editor editor = prefs.edit();
        SeekBar                  s1     = findViewById(R.id.S1);
        Spinner                  l1     = findViewById(R.id.L1);

        if (editor != null) {
            if (s1 != null)
                editor.putInt(Constants.SHARED_PREFS_S1, s1.getProgress());

            if (l1 != null)
                editor.putInt(Constants.SHARED_PREFS_L1, l1.getSelectedItemPosition());
        }

        editor.commit();
    }

    /**
     * Switch over to A2 and pass a message from T1
     */
    public void switchA1ToA2(View view) {
        Intent   intent = new Intent(this, A2.class);
        EditText t1     = findViewById(R.id.T1);
        String   text   = t1.getText().toString();

        intent.putExtra(Constants.MESSAGE_FROM_A1, text);

        startActivity(intent);
    }
}
