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

public class Lunch extends Activity
{


    private  DatabaseHelper data = new DatabaseHelper (this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lunch);

        Button b1 = (Button)findViewById(R.id.save2);



        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if((Contact)(getIntent().getSerializableExtra("Contact"))!=null) {
                    //   Toast.makeText(Lunch.this, "I am in lunch not null class", Toast.LENGTH_SHORT).show();

                    Contact c= new Contact();

                    c= (Contact) (getIntent().getSerializableExtra("Contact"));

                    int lunch = c.getLunchFlag();

                    if (lunch == 0) {
                        RadioButton r1 = (RadioButton) findViewById(R.id.radioButton_3);
                        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton_4);

                        if (r1.isChecked()) {
                            Toast t = Toast.makeText(Lunch.this, "I am having lunch today", Toast.LENGTH_SHORT);
                            //     t.show();
                            Intent i2 = new Intent(Lunch.this, Student.class);
                            c.setLunchFlag(1);


                            data.ChangeLunchStatus(c.getUname(),1);

//                            data.ChangeLunchStatus1(c.getUname(),1);

 //                           c.setlunch();

                            data.UpdateLunchCanteen();

                            Integer f = c.getLunchFlag();
                            Toast.makeText(Lunch.this, f.toString(), Toast.LENGTH_SHORT).show();

                            i2.putExtra("Contact",c);

                            startActivity(i2);

                            //     data.ChangeLunchStatus(c.getUname(),1);

                        } else if (r2.isChecked()) {

                            Toast t = Toast.makeText(Lunch.this, "I am Not having Lunch today", Toast.LENGTH_SHORT);
                            t.show();
                            Intent i1 = new Intent(Lunch.this, Student.class);
                            c.setLunchFlag(2);
                            data.ChangeLunchStatus(c.getUname(),2);

                            Integer in = c.getLunchFlag();

                            Toast.makeText(Lunch.this, in.toString(), Toast.LENGTH_SHORT);
                            //    data.ChangeLunchStatus(c.getUname(),2);
                            i1.putExtra("Contact",c);
                            //   System.out.print("I am lunch flag yahoooooooooooooooooooooooooooooooooooooooooooooo   "+c.getLunchFlag());

                            startActivity(i1);
                        } else {

                            Toast.makeText(Lunch.this, "I have not opted anything", Toast.LENGTH_SHORT).show();
                            Intent i1 = new Intent(Lunch.this, Student.class);
                            // System.out.print("I am lunch flag yahoooooooooooooooooooooooooooooooooooooooooooooo   "+c.getLunchFlag());
                            i1.putExtra("Contact",c);
                            startActivity(i1);
                        }
                    }

                    else{
                        Toast.makeText(Lunch.this, "My code is wrong ", Toast.LENGTH_SHORT).show();

                    }

                }

                else{
                    Toast.makeText(Lunch.this, "I am in Lunch  null class", Toast.LENGTH_SHORT).show();
                }

            }





            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });


    }


}
