package com.example.iiitb.queuemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by iiitb on 4/5/17.
 */

public class ResetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotten_password);
        Button b1 = (Button)findViewById(R.id.ResetSuccessButton);

        TextView t1 = (TextView)findViewById(R.id.PP);
        t1.setText(getIntent().getStringExtra("pass"));


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ResetPassword.this,MainActivity.class);

                startActivity(i);

            }
        });

    }
}
