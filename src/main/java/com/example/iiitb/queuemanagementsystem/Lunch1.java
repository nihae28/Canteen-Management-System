package com.example.iiitb.queuemanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by iiitb on 14/4/17.
 */

public class Lunch1 extends Activity {
    DatabaseHelper data = new DatabaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch1);
        Button b = (Button) findViewById(R.id.Lunch1_goback);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Contact)(getIntent().getSerializableExtra("Contact"))!=null) {
                    Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));

                    c.setLunchFlag(1);

                    Intent i = new Intent(Lunch1.this, Student.class);

                    data.ChangeLunchStatus1(c.getUname(),1);

                    c.setlunch();

                    i.putExtra("Contact", c);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(Lunch1.this, Student.class);
                    Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));
                    i.putExtra("Contact",c);
                    startActivity(i);

                }
            }
        });
    }
}
