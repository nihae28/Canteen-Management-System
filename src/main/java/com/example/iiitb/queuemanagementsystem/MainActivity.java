package com.example.iiitb.queuemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iiitb.queuemanagementsystem.Contact;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClick(View v) {
        if (v.getId() == R.id.bLogin) {
            EditText a = (EditText) findViewById(R.id.TFUsername);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.TFPassword);
            String pass = b.getText().toString();
            String uname = a.getText().toString();

            ArrayList<Object> o = new ArrayList<Object>();

            o = helper.searchPass(str);

            String password = (String)o.get(0);

            Contact c = new Contact();

            c = (Contact)o.get(1);

            Toast.makeText(this,pass,Toast.LENGTH_SHORT).show();

            Toast.makeText(this,password,Toast.LENGTH_SHORT).show();


            if (pass.equals(password)) {

                    String p = helper.searchPass1(str);

                    if(c.getName().equals("Canteen") && pass.equals("123"))
                    {
                        Toast.makeText(this,c.getName(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(this,c.getPass(),Toast.LENGTH_SHORT).show();

                        Intent i1 = new Intent(MainActivity.this, Canteen.class);
                   //     i1.putExtra("Contact",c);
                        startActivity(i1);
                    }
                   else {

                        Toast.makeText(this,c.getName(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(this,c.getPass(),Toast.LENGTH_SHORT).show();

                        Intent i1 = new Intent(MainActivity.this, Student.class);
                        if (c != null) {
                            i1.putExtra("Contact", c);


                        } else {
                            Toast.makeText(MainActivity.this, "null in mainactivity!!", Toast.LENGTH_SHORT).show();
                        }
                        startActivity(i1);

                    }

                } else {
                    Toast.makeText(this,c.getName(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(this,password,Toast.LENGTH_SHORT).show();
                    Toast temp = Toast.makeText(MainActivity.this, "Wrong Credentials !!", Toast.LENGTH_SHORT);
                    temp.show();
                }

            }


            else if (v.getId() == R.id.Bsignup) {
                Intent i = new Intent(MainActivity.this, SignUp.class);

                startActivity(i);

            }

            else if(v.getId() == R.id.ForgotPassword)
                {
               //     Toast.makeText(MainActivity.this,"hey",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, ForgottenPassword.class);
                  //  i.putExtra("Contact",c);
                            startActivity(i);
                }

    }
}