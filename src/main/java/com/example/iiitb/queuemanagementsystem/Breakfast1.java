package com.example.iiitb.queuemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by iiitb on 15/4/17.
 */

public class Breakfast1 extends AppCompatActivity{

    DatabaseHelper data = new DatabaseHelper(this);
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfast1);
        Button b = (Button) findViewById(R.id.BfgoBack);
        RadioButton r = (RadioButton)findViewById(R.id.Yes_Bf);


        r.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if ((Contact) (getIntent().getSerializableExtra("Contact")) != null) {
                    //   Toast.makeText(Lunch.this, "I am in lunch not null class", Toast.LENGTH_SHORT).show();

                    Contact c = new Contact();

                    c = (Contact) (getIntent().getSerializableExtra("Contact"));

                    data.ChangeBfStatus1(c.getUname(),1);

                    c.setbf();

                    Intent i2 = new Intent(Breakfast1.this, BreakfastCanteen.class);

                    i2.putExtra("Contact", c);

                    startActivity(i2);


                }
            }
            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Contact)(getIntent().getSerializableExtra("Contact"))!=null) {
                    Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));

                    c.setBfFlag(1);
                    Intent i = new Intent(Breakfast1.this, Student.class);

                    i.putExtra("Contact", c);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(Breakfast1.this, Student.class);
                    Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));
                    c.setBfFlag(1);
                    i.putExtra("Contact",c);
                    startActivity(i);

                }
            }
        });
    }
}


