package com.example.iiitb.queuemanagementsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by iiitb on 15/4/17.
 */

public class Dinner2 extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinner2);
        Button b = (Button) findViewById(R.id.Dinner2_goback);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if((Contact)(getIntent().getSerializableExtra("Contact"))!=null) {
                      Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));
                      c.setDinnerFlag(2);
                      Intent i = new Intent(Dinner2.this, Student.class);

                      i.putExtra("Contact", c);
                      startActivity(i);
                  }

                  else{

                      Intent i = new Intent(Dinner2.this, Student.class);
                      Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));
                      c.setDinnerFlag(2);
                      i.putExtra("Contact",c);
                      startActivity(i);
                  }
            }


        });
    }
}
