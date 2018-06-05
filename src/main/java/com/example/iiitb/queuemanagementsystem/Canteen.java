package com.example.iiitb.queuemanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by iiitb on 20/4/17.
 */

public class Canteen extends Activity{

    DatabaseHelper data= new DatabaseHelper (this);;
   // Contact c;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.canteen_front);

        Button b1 = (Button)findViewById(R.id.canteen_front_logout);

        Button b2 = (Button)findViewById(R.id.canteen_front_orders);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Orders(v);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logout(v);

            }
        });


    }


    public  void Orders(View v)
    {

        Toast.makeText(Canteen.this,"i am neha",Toast.LENGTH_SHORT).show();
    //    if ((Contact) getIntent().getSerializableExtra("Contact") != null) {

      //      c =  (Contact) getIntent().getSerializableExtra("Contact");

            Intent i = new Intent(Canteen.this,CanteenOrders.class);

      //      i.putExtra("Contact",c);


         /*   TextView bf_total = (TextView)findViewById(R.id.Total_Breakfast_Order);
            TextView bf_pending = (TextView)findViewById(R.id.Pending_Breakfast_Order);
            TextView lunch_total = (TextView)findViewById(R.id.Total_Lunch_Order);
            TextView lunch_pending = (TextView)findViewById(R.id.Pending_Lunch_Order);
            TextView dinner_total = (TextView)findViewById(R.id.Total_Dinner_Order);
            TextView dinner_pending = (TextView)findViewById(R.id.Pending_Dinner_Order);

            dinner_total.setText(data.getDinnerCanteen());
            bf_total.setText(data.getBfCanteen());
            lunch_total.setText(data.getLunchCanteen());
*/

        Integer l = data.getBfCanteen();
        i.putExtra("break",l.toString());
        l = data.getLunchCanteen();
        i.putExtra("lunch",l.toString());
        l = data.getDinnerCanteen();
        i.putExtra("dinner",l.toString());
        l = data.getSlot1();
        i.putExtra("slot1",l.toString());
        l = data.getSlot2();
        i.putExtra("slot2",l.toString());
        l = data.getSlot3();
        i.putExtra("slot3",l.toString());
        l = data.getSlot4();
        i.putExtra("slot4",l.toString());
        l = data.getSlot5();
        i.putExtra("slot5",l.toString());
        l = data.getSlot6();
        i.putExtra("slot6",l.toString());

        startActivity(i);


//        }

    }

    public  void logout(View v){

        Intent i = new Intent(Canteen.this, MainActivity.class);
        startActivity(i);


    }
}
