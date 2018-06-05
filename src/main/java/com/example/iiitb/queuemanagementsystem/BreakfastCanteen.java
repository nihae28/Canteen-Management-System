package com.example.iiitb.queuemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by iiitb on 4/5/17.
 */

public class BreakfastCanteen extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfastcanteen);

        Button b = (Button)findViewById(R.id.BreakfastCanteenBack);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Contact)(getIntent().getSerializableExtra("Contact"))!=null) {
                    Contact c = (Contact)(getIntent().getSerializableExtra("Contact"));
                    Intent i1 = new Intent(BreakfastCanteen.this, Student.class);

                    i1.putExtra("Contact", c);

                    startActivity(i1);

                }
            }
        });


    }
}
