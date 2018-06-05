package com.example.iiitb.queuemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by iiitb on 23/4/17.
 */

public class Breakfast8 extends AppCompatActivity{

    private  DatabaseHelper data = new DatabaseHelper (this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfast3);
        Button b1 = (Button) findViewById(R.id.save1);
        Button b2 = (Button) findViewById(R.id.BACK_BF1);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Contact)(getIntent().getSerializableExtra("Contact"))!=null) {
                    Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));

                    if(getIntent().getIntExtra("I",0)==1){

                        int i =0;
                        c.setBfFlag(1);

                        Intent i1 = new Intent(Breakfast8.this, Student.class);

                        i1.putExtra("Contact", c);
                        data.ChangeBfStatus(c.getUname(),1);
                        data.UpdateBfCanteen();
                        data.UpdateSlot5();

                        startActivity(i1);

                    }

                    else;

                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Contact)(getIntent().getSerializableExtra("Contact"))!=null) {
                    Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));
                    Intent i1 = new Intent(Breakfast8.this, Breakfast.class);

                    i1.putExtra("Contact", c);

                    startActivity(i1);


                }
            }
        });



    }


}