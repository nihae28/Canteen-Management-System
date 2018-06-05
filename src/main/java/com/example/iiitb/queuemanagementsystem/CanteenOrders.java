package com.example.iiitb.queuemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by iiitb on 20/4/17.
 */

public class CanteenOrders extends AppCompatActivity{

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canteen_1);

        TextView bf = (TextView)findViewById(R.id.Total_BF_Order);
        TextView bf_total = (TextView)findViewById(R.id.Slot1);
        TextView bf_total1 = (TextView)findViewById(R.id.Slot2);
        TextView bf_total2 = (TextView)findViewById(R.id.Slot3);
        TextView bf_total3 = (TextView)findViewById(R.id.Slot4);
        TextView bf_total4 = (TextView)findViewById(R.id.Slot5);
        TextView bf_total5 = (TextView)findViewById(R.id.Slot6);

        TextView lunch_total = (TextView)findViewById(R.id.Total_Lunch_Order);
        TextView dinner_total = (TextView)findViewById(R.id.Total_Dinner_Order);



        String s1 = getIntent().getStringExtra("slot1");
        String s4 = getIntent().getStringExtra("slot2");
        String s5 = getIntent().getStringExtra("slot3");
        String s6 = getIntent().getStringExtra("slot4");
        String s7 = getIntent().getStringExtra("slot5");
        String s8 = getIntent().getStringExtra("slot6");
        String s0 = getIntent().getStringExtra("break");
        String s2 = getIntent().getStringExtra("lunch");
        String s3 = getIntent().getStringExtra("dinner");


        bf_total.setText(s1);
        bf_total1.setText(s4);
        bf_total2.setText(s5);
        bf_total3.setText(s6);
        bf_total4.setText(s7);
        bf_total5.setText(s8);
        bf.setText(s0);
        lunch_total.setText(s2);
        dinner_total.setText(s3);

        Button b1 = (Button)findViewById(R.id.CANTEEN_1BACK);


        Toast.makeText(CanteenOrders.this,"I am in canteeen",Toast.LENGTH_SHORT).show();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(CanteenOrders.this,Canteen.class);


                startActivity(i);

            }
        });

    }
}
