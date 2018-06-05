package com.example.iiitb.queuemanagementsystem;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by iiitb on 11/4/17.
 */



public class Contact implements Serializable {

    private static long serialVersionUID =1;
    public String name,email,uname,pass;

    public int bf, lunch, dinner;


   public int bf_flag;
   public int lunch_flag;
    public int dinner_flag;

    public String secretpass;

    public Contact(String name, String email, String uname, String pass, int bf, int lunch, int dinner,int bf_flag,int lunch_flag,int dinner_flag, String S)
    {
        this.name = name;
        this.email= email;
        this.uname = uname;
        this.pass = pass;
        this.bf= bf;
        this.lunch=lunch;
        this.dinner=dinner;
        this.lunch_flag= lunch_flag;
        this.dinner_flag=dinner_flag;
        this.bf_flag=bf_flag;
        secretpass = S;
    }

   public Contact(){

       bf = lunch = dinner =0;
               bf_flag=lunch_flag=dinner_flag=0;
   }

   public String getSecretPass()
   {

       return secretpass;
   }
    public void setBfFlag(int x){
        bf_flag=x;

    }

    public void setLunchFlag(int x){
        lunch_flag=x;

    }
    public void setDinnerFlag(int x) {
      dinner_flag=x;
    }


    public int getLunchFlag()
    {
        return lunch_flag;
    }

    public int getBfFlag()
    {
        return bf_flag;
    }
    public int getDinnerFlag()
    {
        return dinner_flag;
    }


    public void setSecretpass(String s){

        secretpass = s;
    }

    public void setName(String name){

        this.name = name;

    }
    public String getName(){


        return this.name;
    }

    public int getbf()
    {
        return bf;
    }

    public  int getLunch()
    {
        return lunch;

    }

    public  int getDinner()
    {
        return dinner;
    }

    public void setbf()
    {
        bf = bf+1;
    }

    public void setlunch()
    {
        lunch = lunch+1;
    }

    public void setdinner()
    {
        dinner = dinner+1;
    }


    public void setEmail(String email){

        this.email = email;

    }
    public String getEmail(){


        return this.email;
    }

    public void setUname(String uname){

        this.uname = uname;

    }
    public String getUname(){


        return this.uname;
    }

    public void setPass(String pass){

        this.pass = pass;

    }
    public String getPass(){


        return this.pass;
    }



}