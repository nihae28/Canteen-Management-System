


package com.example.iiitb.queuemanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.security.PrivilegedAction;

/**
 * Created by iiitb on 11/2/17.
 */

public class Student extends AppCompatActivity {

    DatabaseHelper data = new DatabaseHelper(this);
    Contact c = new Contact();
    String n;
    String p;
    String e;
    String u;
    String secret;
    int l;
    int d;
    int b;

    protected void onCreate(Bundle savedInstanceState) {

        c = (Contact) getIntent().getSerializableExtra("Contact");
        n = c.getName();
         p = c.getPass();
         e = c.getEmail();
         u = c.getUname();
         l = c.getLunchFlag();
         b = c.getBfFlag();
         d = c.getDinnerFlag();
        secret = c.getSecretPass();

        //   Contact c3=new Contact();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
        Button b1,b2;
        final Button b3;
        Button b4, b5, b6;
         b1 = (Button)findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Breakfast(v);
                // Toast.makeText(MainActivity.this, "I am One", Toast.LENGTH_SHORT).show();
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lunch(v);
                // Toast.makeText(MainActivity.this, "I am One", Toast.LENGTH_SHORT).show();
            }
        });

        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  Toast.makeText(Student.this, b3.getText().toString(), Toast.LENGTH_SHORT).show();

                Dinner(v);
                // Toast.makeText(MainActivity.this, "I am One", Toast.LENGTH_SHORT).show();
            }
        });
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOrders(v);
                // Toast.makeText(MainActivity.this, "I am One", Toast.LENGTH_SHORT).show();
            }
        });

        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Student.this, MainActivity.class);
                startActivity(i);


                // Toast.makeText(MainActivity.this, "I am One", Toast.LENGTH_SHORT).show();
            }
        });


        b6 = (Button) findViewById(R.id.PAY);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Payment(v);
                // Toast.makeText(MainActivity.this, "I am One", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Breakfast(View view) {
        if ((Contact) getIntent().getSerializableExtra("Contact") != null) {
            //  if (data != null) {
         //   c = (Contact) getIntent().getSerializableExtra("Contact");
         //   getLunchCanteen
           if(c.getbf()==0) {

                if (c.getBfFlag() == 0 ) {
                    Intent i = new Intent(Student.this, Breakfast.class);
                    i.putExtra("Contact", c);
                    startActivity(i);
                }

             else if (c.getBfFlag() == 1) {
                    Intent i = new Intent(Student.this, Breakfast1.class);
                    i.putExtra("Contact", c);
                    startActivity(i);
                }
            }

            else if(c.getBfFlag() == 1 && (c.getbf()==1)) {

                Intent i = new Intent(Student.this, BreakfastCanteen.class);
                i.putExtra("Contact", c);
                startActivity(i);

            }




        } else {
            Toast.makeText(Student.this, "i AM IN breakfast NULL ", Toast.LENGTH_SHORT).show();

        }
     /*   System.out.println("I am outside bf methoddddddddddd " + c.getLunchFlag());
        System.out.println("I am outside bf methoddddddddddd " + c.getLunchFlag());
        System.out.println("I am outside bf methoddddddddddd " + c.getLunchFlag());
        System.out.println("I am outside bf methoddddddddddd " + c.getLunchFlag());

        System.out.println("I am outside bf methoddddddddddd " + c.getLunchFlag());

    */
    }


    public void Lunch(View view) {


        if ((Contact) getIntent().getSerializableExtra("Contact") != null) {
         //   c = (Contact) getIntent().getSerializableExtra("Contact");

            if(c.getLunch()==0) {

                if (c.getLunchFlag() == 0 ) {
                    Intent i = new Intent(Student.this, Lunch.class);
                    i.putExtra("Contact", c);
                    startActivity(i);
                }

                else if (c.getLunchFlag() == 1) {
                    Intent i = new Intent(Student.this, Lunch1.class);
                    i.putExtra("Contact", c);
                    startActivity(i);
                }

                else if(c.getLunchFlag()==2){


                    Intent i = new Intent(Student.this, Lunch2.class);
                    i.putExtra("Contact", c);
                    startActivity(i);


                }

            }

            else if(c.getLunchFlag() == 1 && (c.getLunch()==1)) {

                Intent i = new Intent(Student.this, LunchCanteen.class);
                i.putExtra("Contact", c);
                startActivity(i);

            }


        } else {
            Toast.makeText(Student.this, "i AM IN LUNCH NULL ", Toast.LENGTH_SHORT).show();

        }

    /*    System.out.println("I am outside lunch method " + c.getLunchFlag());
        System.out.println("I am outside lunch method " + c.getLunchFlag());

        System.out.println("I am outside lunch method " + c.getLunchFlag());
        System.out.println("I am outside lunch method " + c.getLunchFlag());

        System.out.println("I am outside lunch method " + c.getLunchFlag());

*/
    }


    public void Dinner(View v) {


        if ((Contact) getIntent().getSerializableExtra("Contact") != null) {
            //   c = (Contact) getIntent().getSerializableExtra("Contact");

            if(c.getDinner()==0) {

                if (c.getDinnerFlag() == 0 ) {
                    Intent i = new Intent(Student.this, Dinner.class);
                    i.putExtra("Contact", c);
                    startActivity(i);
                }

                else if (c.getDinnerFlag() == 1) {
                    Intent i = new Intent(Student.this, Dinner1.class);
                    i.putExtra("Contact", c);
                    startActivity(i);
                }

                else if(c.getDinnerFlag()==2){


                    Intent i = new Intent(Student.this, Dinner2.class);
                    i.putExtra("Contact", c);
                    startActivity(i);


                }
            }

            else if(c.getDinner() == 1 && (c.getDinnerFlag()==1)) {

                Intent i = new Intent(Student.this, DinnerCanteen.class);
                i.putExtra("Contact", c);
                startActivity(i);

            }



        } else {
            Toast.makeText(Student.this, "i AM IN Dinner NULL ", Toast.LENGTH_SHORT).show();

        }


    }


    public void MyOrders(View v) {
    /*    System.out.println("I am breakfast flag ");
        System.out.println("I am breakfast flag ");
        System.out.println("I am breakfast flag ");
        System.out.println("I am breakfast flag ");
        System.out.println("I am breakfast flag ");

        System.out.println("I am breakfast flag " + c.getBfFlag());
        System.out.println("I am lunch flag " + c.getLunchFlag());
        System.out.println("I am dineer flag " + c.getDinnerFlag());*/

        Intent i7 = new Intent(this, Orders.class);


        //  String uname = getIntent().getStringExtra("Username");
        if ((Contact) getIntent().getSerializableExtra("Contact") != null) {
            //  if (data != null) {
            c = (Contact) getIntent().getSerializableExtra("Contact");
            //  Contact c = (Contact) getIntent().getSerializableExtra("Contact");

            i7.putExtra("Contact", c);
        }

        // i7.putExtra("Uname",uname);
        startActivity(i7);

    }

/*    public void Payment() {
        Toast.makeText(Student.this, "i am in paymentvlbkjk method not null ", Toast.LENGTH_SHORT).show();


        Toast.makeText(Student.this, "ndehde ", Toast.LENGTH_SHORT).show();

        Intent i7 = new Intent(this, Payment.class);

    //    c = (Contact) getIntent().getSerializableExtra("Contact");


        if (c != null) {
            Toast.makeText(Student.this, "i am in null ", Toast.LENGTH_SHORT).show();


        }

        i7.putExtra("Contact", c);
        startActivity(i7);


        Toast.makeText(Student.this, "i am in paymenjkjbl bt method null ", Toast.LENGTH_SHORT).show();


    }
*/

    public void Payment(View v) {


    /*    System.out.println("sasssssssssss" + n);
        System.out.println("sasssssssssss" + e);

        System.out.println("sasssssssssss" + u);
        System.out.println("sasssssssssss" + p);
        System.out.println("sasssssssssss" + l);
        System.out.println("sasssssssssss" + b);

        System.out.println("sasssssssssss" + d);

*/
        Contact c2 = new Contact(n,e,u,p,b,l,d,b,l,d,secret);



        double Amount = 0;

        Contact c = new Contact();

        if(l!=1)
        {l =0;}
        if(b!=1)
            b=0;
        if(d!=1)d=0;
        Amount = (l+b+d) * (40.0);
        Double amt = Amount;
        Intent i = new Intent(Student.this, Payment.class);
        i.putExtra("Contact", c2);
        i.putExtra("Amount",amt.toString());
        startActivity(i);





    }

}