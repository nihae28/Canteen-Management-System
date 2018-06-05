package com.example.iiitb.queuemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by iiitb on 23/4/17.
 */

public class ForgottenPassword extends AppCompatActivity{

    private  DatabaseHelper data = new DatabaseHelper (this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);

        final EditText e = (EditText)findViewById(R.id.uname_edit_text);
        final EditText e1 = (EditText)findViewById(R.id.secretPass);
        final TextView t = (TextView)findViewById(R.id.PP);
        Button b1 = (Button)findViewById(R.id.ResetPassword);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = e.getText().toString();

                String secret = e1.getText().toString();

                if(data.getPass(uname,secret).equals("def"))
                {

                    //   Intent i = new Intent();

                    Toast.makeText(ForgottenPassword.this,"Wrong secret code entered",Toast.LENGTH_SHORT).show();




                }

                else{

                    Intent i = new Intent(ForgottenPassword.this,ResetPassword.class);

                    String p = data.getPass(uname,secret);

                    Toast.makeText(ForgottenPassword.this,"Iam password okay "+p,Toast.LENGTH_SHORT).show();


                    if(p != null) {

                     //   t.setText(p);
                        i.putExtra("pass",p);

                    }
                    //  i.putExtra("pass",p);



                 //   tv1.setText(data.getPass(uname,secret));
                     //    i.putExtra("password",data.getPass(uname,secret));

                    startActivity(i);

               }
            }
        });





    }
}
