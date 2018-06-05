package com.example.iiitb.queuemanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.data;

/**
 * Created by iiitb on 12/4/17.
 */


public class Orders extends Activity
{

    DatabaseHelper date = new DatabaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorders);
   //     String uname = getIntent().getStringExtra("Uname");

        TextView t = (TextView)findViewById(R.id.BF);
        TextView t1 = (TextView)findViewById(R.id.LUNCH);
        TextView t2 = (TextView)findViewById(R.id.DINNER);
        TextView t3 = (TextView)findViewById(R.id.DATE);
        Button b1 = (Button)findViewById(R.id.OrdersButton);

        if((Contact)getIntent().getSerializableExtra("Contact")!=null) {
           Contact c = (Contact) getIntent().getSerializableExtra("Contact");
           // String c = date.getlunch(c.);
    //        int x = date.getBf(c.getUname());
    //        int y = date.getlunch(c.getUname());
    //        int z = date.getDinner(c.getUname());
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            Toast.makeText(Orders.this,"I am right till here ", Toast.LENGTH_SHORT).show();

            t3.setText(date);
            Integer i = c.getBfFlag();
            if(i == 2)
            { i = 0;}
          //  Integer i = x;
            String b = i.toString();
            t.setText(b);
            i = c.getLunchFlag();
            if(i == 2)
            { i = 0;}
            t1.setText(i.toString());
            i = c.getDinnerFlag();
            if(i==2){ i = 0;}
            t2.setText(i.toString());

            System.out.println("dineeeeeeeeeeeeer" + i);
        }

        else {
            Toast.makeText(Orders.this,"I am orders null", Toast.LENGTH_SHORT).show();

        }

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {Contact c1 = (Contact) getIntent().getSerializableExtra("Contact");

                Intent i2 = new Intent(Orders.this,Student.class);
                i2.putExtra("Contact",c1);
                startActivity(i2);

                // Toast.makeText(MainActivity.this, "I am One", Toast.LENGTH_SHORT).show();
            }
        });




    //   t.setText(uname);


    }
}
