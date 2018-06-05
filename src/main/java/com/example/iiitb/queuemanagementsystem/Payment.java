package com.example.iiitb.queuemanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by iiitb on 17/4/17.
 */

public class Payment extends Activity{

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        Toast.makeText(Payment.this,"i am in payment ",Toast.LENGTH_SHORT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        String amt = getIntent().getStringExtra("Amount");

        TextView t = (TextView)findViewById(R.id.AmountValue);
        t.setText("Rs "+amt);

        Button b = (Button)findViewById(R.id.ButtonAmountBack);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Contact c = new Contact();
                c= (Contact)getIntent().getSerializableExtra("Contact");

                Intent i2 = new Intent(Payment.this,Student.class);
                i2.putExtra("Contact",c);
                startActivity(i2);

                // Toast.makeText(MainActivity.this, "I am One", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
