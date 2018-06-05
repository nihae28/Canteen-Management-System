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

public class Dinner1 extends Activity {
    DatabaseHelper data = new DatabaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinner1);
        Button b = (Button) findViewById(R.id.Dinner1_goback);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Contact)(getIntent().getSerializableExtra("Contact"))!=null) {
                    Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));

                    c.setDinnerFlag(1);

                    data.ChangeDinnerStatus1(c.getUname(),1);

                    c.setdinner();
                    Intent i = new Intent(Dinner1.this, Student.class);

                    i.putExtra("Contact", c);
                    startActivity(i);
                }
                else {
                    Contact c = new Contact();
                    c.setDinnerFlag(1);
                    Intent i = new Intent(Dinner1.this, Student.class);
                    i.putExtra("Contact", c);
                    startActivity(i);

                }
            }
        });
    }
}
