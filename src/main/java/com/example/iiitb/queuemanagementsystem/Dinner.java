package com.example.iiitb.queuemanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by iiitb on 11/2/17.
 */

public class Dinner extends Activity
{

    private DatabaseHelper data = new DatabaseHelper (this);

    //

    // if((Contact)(getIntent().getSerializableExtra("contact_lunch"))){}

    // Contact c1 = new Contact();

    //  static int flag = 0;

    // i5.putExtra("lunch_status",lunch);

    //            i5.putExtra("uname",uname);

    //private DatabaseHelper data = new DatabaseHelper (this);



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dinner);

        Button b1 = (Button)findViewById(R.id.save3);

      /*  RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId==R.id.radioButton_3)
                {
                    Toast.makeText(Dinner.this, "I click yes",Toast.LENGTH_SHORT).show();
                }

            }
        });
      */

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if((Contact)(getIntent().getSerializableExtra("Contact"))!=null) {

                    Contact c= new Contact();

                    c= (Contact) (getIntent().getSerializableExtra("Contact"));

                    int dinner = c.getDinnerFlag();

                    if (dinner == 0) {
                        RadioButton r1 = (RadioButton) findViewById(R.id.radioButton_5);
                        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton_6);

                        if (r1.isChecked()) {
                            Toast t = Toast.makeText(Dinner.this, "I am having dinner today", Toast.LENGTH_SHORT);
                            //     t.show();
                            Intent i2 = new Intent(Dinner.this, Student.class);
                            c.setDinnerFlag(1);

                            data.ChangeDinnerStatus(c.getUname(),1);

//                            data.ChangeDinnerStatus1(c.getUname(),1);

//                            c.setdinner();

                            data.UpdateDinnerCanteen();

                            Integer f = c.getDinnerFlag();
                            Toast.makeText(Dinner.this, f.toString(), Toast.LENGTH_SHORT).show();

                            i2.putExtra("Contact",c);

                            startActivity(i2);

                        } else if (r2.isChecked()) {

                            Toast t = Toast.makeText(Dinner.this, "I am Not having dinner today", Toast.LENGTH_SHORT);
                            t.show();
                            Intent i1 = new Intent(Dinner.this, Student.class);
                            c.setDinnerFlag(2);
                            data.ChangeDinnerStatus(c.getUname(),2);

                            Integer in = c.getDinnerFlag();

                            Toast.makeText(Dinner.this, in.toString(), Toast.LENGTH_SHORT);
                            i1.putExtra("Contact",c);

                            startActivity(i1);
                        } else {

                            Toast.makeText(Dinner.this, "I have not opted anything", Toast.LENGTH_SHORT).show();
                            Intent i1 = new Intent(Dinner.this, Student.class);
                            i1.putExtra("Contact",c);
                            startActivity(i1);
                        }
                    }

                    else{
                        Toast.makeText(Dinner.this, "My code is wrong ", Toast.LENGTH_SHORT).show();

                    }

                }

                else{
                    Toast.makeText(Dinner.this, "I am in dinner  null class", Toast.LENGTH_SHORT).show();
                }

            }





            // Toast.makeText(MainA\ctivity.this, "I am One", Toast.LENGTH_SHORT).show();

        });

        //Intent i = new Intent(this,Display.class);
        //i.putExtra("Username",str);
        //startActivity(i);
    }

}
