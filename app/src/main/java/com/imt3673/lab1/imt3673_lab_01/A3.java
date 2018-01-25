package com.imt3673.lab1.imt3673_lab_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class A3 extends AppCompatActivity {

    public static final String MESSAGE_FROM_A3 = "message_from_a3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
    }

    /**
     * Switch back to A2 and pass a message from T4
     */
    public void switchA3ToA2(View view) {
        Intent   intent = new Intent();
        EditText t4     = findViewById(R.id.T4);
        String   text   = t4.getText().toString();

        intent.putExtra(MESSAGE_FROM_A3, text);

        setResult(RESULT_OK, intent);
        finish();
    }
}
