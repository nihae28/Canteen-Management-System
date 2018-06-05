package com.example.iiitb.queuemanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by iiitb on 11/2/17.
 */

public class Breakfast extends Activity
{


private  DatabaseHelper data = new DatabaseHelper (this);

    static int i =0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.breakfast);

        RadioButton b1 = (RadioButton) findViewById(R.id.slot1);

        RadioButton b2 = (RadioButton) findViewById(R.id.slot2);

        RadioButton b3 = (RadioButton) findViewById(R.id.slot3);

        RadioButton b4 = (RadioButton) findViewById(R.id.slot4);

        RadioButton b5 = (RadioButton) findViewById(R.id.slot5);

        RadioButton b6 = (RadioButton) findViewById(R.id.slot6);

        Button b7 = (Button)findViewById(R.id.BACK_BF);


        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if ((Contact) (getIntent().getSerializableExtra("Contact")) != null) {
                    //   Toast.makeText(Lunch.this, "I am in lunch not null class", Toast.LENGTH_SHORT).show();

                    Contact c = new Contact();

                    c = (Contact) (getIntent().getSerializableExtra("Contact"));

                    Intent i2 = new Intent(Breakfast.this, Breakfast4.class);


                    i2.putExtra("Contact", c);
                    i =1;
                    i2.putExtra("I",i);
                    startActivity(i2);


                }
            }
            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });


        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if ((Contact) (getIntent().getSerializableExtra("Contact")) != null) {
                    //   Toast.makeText(Lunch.this, "I am in lunch not null class", Toast.LENGTH_SHORT).show();

                    Contact c = new Contact();

                    c = (Contact) (getIntent().getSerializableExtra("Contact"));

                    Intent i2 = new Intent(Breakfast.this, Breakfast5.class);


                    i =1;
                    i2.putExtra("I",i);
                    i2.putExtra("Contact", c);

                    startActivity(i2);


                }
            }
            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });

        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if ((Contact) (getIntent().getSerializableExtra("Contact")) != null) {
                    //   Toast.makeText(Lunch.this, "I am in lunch not null class", Toast.LENGTH_SHORT).show();

                    Contact c = new Contact();

                    c = (Contact) (getIntent().getSerializableExtra("Contact"));

                    Intent i2 = new Intent(Breakfast.this, Breakfast6.class);
                    i =1;
                    i2.putExtra("I",i);
                    i2.putExtra("Contact", c);

                    startActivity(i2);


                }
            }
            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });

        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if ((Contact) (getIntent().getSerializableExtra("Contact")) != null) {
                    //   Toast.makeText(Lunch.this, "I am in lunch not null class", Toast.LENGTH_SHORT).show();

                    Contact c = new Contact();

                    c = (Contact) (getIntent().getSerializableExtra("Contact"));

                    Intent i2 = new Intent(Breakfast.this, Breakfast7.class);
                    i =1;
                    i2.putExtra("I",i);
                    i2.putExtra("Contact", c);

                    startActivity(i2);


                }
            }
            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });



        b5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if ((Contact) (getIntent().getSerializableExtra("Contact")) != null) {
                    //   Toast.makeText(Lunch.this, "I am in lunch not null class", Toast.LENGTH_SHORT).show();

                    Contact c = new Contact();

                    c = (Contact) (getIntent().getSerializableExtra("Contact"));

                    Intent i2 = new Intent(Breakfast.this, Breakfast8.class);
                    i =1;
                    i2.putExtra("I",i);
                    i2.putExtra("Contact", c);

                    startActivity(i2);


                }
            }
            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });

        b6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if ((Contact) (getIntent().getSerializableExtra("Contact")) != null) {
                    //   Toast.makeText(Lunch.this, "I am in lunch not null class", Toast.LENGTH_SHORT).show();

                    Contact c = new Contact();

                    c = (Contact) (getIntent().getSerializableExtra("Contact"));

                    Intent i2 = new Intent(Breakfast.this, Breakfast9.class);
                    i =1;
                    i2.putExtra("I",i);
                    i2.putExtra("Contact", c);

                    startActivity(i2);


                }
            }
            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });


        b7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if ((Contact) (getIntent().getSerializableExtra("Contact")) != null) {
                    //   Toast.makeText(Lunch.this, "I am in lunch not null class", Toast.LENGTH_SHORT).show();

                    Contact c = new Contact();

                    c = (Contact) (getIntent().getSerializableExtra("Contact"));

                    Intent i2 = new Intent(Breakfast.this, Student.class);

                    i =0;
                    i2.putExtra("Contact", c);

                    startActivity(i2);


                }
            }
            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });

    }


}
