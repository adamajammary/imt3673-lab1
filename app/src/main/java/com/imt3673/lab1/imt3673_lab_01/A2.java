package com.imt3673.lab1.imt3673_lab_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class A2 extends AppCompatActivity {

    static final int REQUEST_CODE_A3_TO_A2 = 1;

    /**
     * Initialize T2 with the message from A1
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        Intent   intent  = getIntent();
        String   message = intent.getStringExtra(A1.MESSAGE_FROM_A1);
        TextView t2      = findViewById(R.id.T2);

        t2.setText("Hello " + message);
    }

    /**
     * Initialize T3 with the message from A3
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == REQUEST_CODE_A3_TO_A2) && (resultCode == RESULT_OK)) {
            TextView t3 = findViewById(R.id.T3);
            t3.setText("From A3: " + data.getStringExtra(A3.MESSAGE_FROM_A3));
        }
    }

    /**
     * Switch over to A3 and request data back
     */
    public void switchA2ToA3(View view) {
        Intent intent = new Intent(this, A3.class);
        startActivityForResult(intent, REQUEST_CODE_A3_TO_A2);
    }
}