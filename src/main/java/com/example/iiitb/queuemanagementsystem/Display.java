package com.example.iiitb.queuemanagementsystem;

/**
 * Created by iiitb on 11/4/17.
 */


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;



public class Display extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
//        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVUsername);

   //     tv.setText(username);

    }
    public void logout(View v){

        Intent i = new Intent(Display.this,MainActivity.class);
        startActivity(i);
    }
}
