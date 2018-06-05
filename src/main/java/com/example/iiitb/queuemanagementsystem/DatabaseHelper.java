package com.example.iiitb.queuemanagementsystem;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.iiitb.queuemanagementsystem.Contact;

import java.io.Serializable;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;


public class DatabaseHelper extends SQLiteOpenHelper{

   // SQLiteDatabase db1 = getWritableDatabase();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME_FOOD = "foods";
    private static final String TABLE_NAME = "contacts";
    private static final String TABLE1="canteen";
    private static final String COLUMN_ID = "id";
    private static  final  String ID = "Id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    private static final String SECRET = "secret";
    private static   String COLUMN_BF ="bf";
    private static  String COLUMN_LUNCH ="lunch";
    private static  String COLUMN_DINNER ="dinner";
    private  static  String BFSTATUS = "bfstatus";
    private static  String LUNCHSTATUS = "lunchstatus";
    private static  String DINNERSTATUS = "dinnerstatus";

    private static  String L = "lflag";
    private static  String B = "bflag";

    private static  String SLOT1 = "slot1";
    private static  String SLOT2 = "slot2";
    private static  String SLOT3 = "slot3";
    private static  String SLOT4 = "slot4";
    private static  String SLOT5 = "slot5";
    private static  String SLOT6 = "slot6";

    private static  String D = "dflag";



    SQLiteDatabase db  ;

    private static final String TABLE_CREATE = "create table contacts(id integer primary key not null ," + " name string not null , email string not null , uname string not null , pass string not null , secret string not null , bf integer not null , lunch integer not null , dinner integer not null , bfstatus integer not null , lunchstatus integer not null , dinnerstatus integer not null)";
    //private static final String TABLE_CREATE_FOOD = "create table foods(email text not null , breakfast integer default 0 , lunch integer default 0 , dinner integer default 0)";
    private static final String TABLE_CANTEEN = "create table canteen(id integer primary key not null ," + " bflag integer not null , slot1 integer not null , slot2 integer not null, slot3 integer not null , slot4 integer not null , slot5 integer not null , slot6 integer not null , lflag integer not null , dflag integer not null)";

 //   contacts(secret,pass,dinner,lunch,email,name,lunchstatus,dinnerstatus,bfstatus,uname,bf


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    public Cursor getPerson(String u){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM contacts WHERE uname = '"+u+"' ";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        // db.execSQL(TABLE_CREATE_FOOD);
        db.execSQL(TABLE_CANTEEN);
        this.db = db;


    }

public void incrementBf(int id)
    {

        Integer i = id;

        db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("b",1);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) });

    }

    public void incrementLunch(int id)
    {

        Integer i = id;

        Integer val = getlunchstatus();

        val = val+1;

        db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("l",val);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) });

    }

    public void incrementDinner(int id)
    {
        Integer i = id;

        db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("d",1);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) });

    }


 /*   public int getIds(String uname)
    {
        db = this.getReadableDatabase();
        String n = uname;
        String query = "select id from canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        String u = "";
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(1).equals(uname))
                {
                    id_val = cursor.getInt(0);
                    //    return cursor.getInt(0);
                }
            }while (cursor.moveToNext());
        }

//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);
//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);

//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);

//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);

//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);

        return id_val;
    }

*/
    public int getlunchstatus()
    {
        db = this.getReadableDatabase();
        String query = "select lunch from canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        String u = "";
        if (cursor.moveToFirst()) {

             id_val = cursor.getInt(0);

        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );
     */
        return id_val;
    }




    public void insertContact(Contact c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        if(c.getName().equals("Canteen") && c.getPass().equals("123")){

                String query = "select * from canteen";

                Cursor cursor = db.rawQuery(query, null);
                //
                int count = cursor.getCount();
                count = count+1;
                values.put(ID,count);
                System.out.println("iam idddddddd" + count);
            System.out.println("iam idddddddd" + count);
            System.out.println("iam idddddddd" + count);
            System.out.println("iam idddddddd" + count);
            System.out.println("iam idddddddd" + count);

            values.put(B,0);
            values.put(SLOT1,0);
            values.put(SLOT2,0);
            values.put(SLOT3,0);
            values.put(SLOT4,0);
            values.put(SLOT5,0);
            values.put(SLOT6,0);
            values.put(L,0);
                values.put(D,0);
                db.insert(TABLE1,null,values);

            System.out.println("I am "+getId(c.getName()));
            System.out.println("I am "+getId(c.getName()));
            System.out.println("I am "+getId(c.getName()));

            System.out.println("I am "+getId(c.getName()));
            System.out.println("I am "+getId(c.getName()));

              //  db.close();
            }

        System.out.println("I  "+getId(c.getName()));
        System.out.println("I  "+getId(c.getName()));
        System.out.println("I  "+getId(c.getName()));

        System.out.println("I  "+getId(c.getName()));
        System.out.println("I  "+getId(c.getName()));


        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
            //    int count = cursor.getCount();



        ContentValues values1 = new ContentValues();
        //   values.put(COLUMN_ID, count+1);
            values1.put(COLUMN_NAME, c.getName());
            values1.put(COLUMN_EMAIL, c.getEmail());
            values1.put(COLUMN_UNAME, c.getUname());
            values1.put(COLUMN_PASS, c.getPass());
            values1.put(SECRET,c.getSecretPass());
            values1.put(COLUMN_BF, c.getbf());
            values1.put(COLUMN_LUNCH, c.getLunch());
            values1.put(COLUMN_DINNER, c.getDinner());

            values1.put(BFSTATUS,c.getbf());
            values1.put(LUNCHSTATUS,c.getLunch());
            values1.put(DINNERSTATUS,c.getDinner());


        db.insert(TABLE_NAME, null, values1);
            db.close();

        System.out.println("I am after canteen"+getId(c.getSecretPass()));
        System.out.println("I am after canteen"+getId(c.getSecretPass()));
        System.out.println("I am after canteen"+getId(c.getSecretPass()));

        System.out.println("I am after canteen"+getId(c.getSecretPass()));
        System.out.println("I am after canteen"+getId(c.getSecretPass()));


    }



    public void insertFood(Contact c){
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from foods";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        values.put(COLUMN_EMAIL,c.getEmail());
        db.insert(TABLE_NAME_FOOD,null,values);
        db.close();
    }


    public String PrintArrayList(ArrayList<String> s)
    {
        String s1 = "";
        for(int i =0; i< s.size(); i++)
        {
            s1 = s1+ "  "+ s.get(i);
        }
        return s1;
    }

    public String searchPass1(String uname) {
        String ret = null;
        ArrayList<String> c = new ArrayList<String>();
        db = this.getReadableDatabase();
        String query = "select uname , pass , bf, lunch , dinner  from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                b = cursor.getString(1);
                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    Integer x = cursor.getInt(2);
                    c.add(x.toString());
                    x = cursor.getInt(3);
                    c.add(x.toString());
                    x = cursor.getInt(4);
                    c.add(x.toString());
                    ret = PrintArrayList(c);
                    break;
                }
            }
            while (cursor.moveToNext());

        }
        return ret;

        //  return b;


    }



    public ArrayList<Object> searchPass(String uname1) {
        ArrayList<String> c = new ArrayList<String>();
        db = this.getReadableDatabase();
        String query = "select name , email , uname , pass , secret , bf , lunch , dinner , bfstatus , lunchstatus , dinnerstatus from " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        String uname, pass,name,email,secret;
        int bf,lunch,dinner;
        uname = email = name =secret = "";
        bf=lunch=dinner=0;
        int bstatus,lstatus,dstatus;
        bstatus=lstatus=dstatus=0;
        pass = "not found";
        if (cursor.moveToFirst()) {
            do {
                name = cursor.getString(0);
                email = cursor.getString(1);
                uname = cursor.getString(2);
                pass = cursor.getString(3);
                secret = cursor.getString(4);
                bf = cursor.getInt(5);
                lunch = cursor.getInt(6);
                dinner = cursor.getInt(7);
                bstatus = cursor.getInt(8);
                lstatus = cursor.getInt(9);
                dstatus = cursor.getInt(10);

                //    secret = cursor.getString(4);
                //Toast.makeText(this,"t",Toast.LENGTH_SHORT).show();

                System.out.println("I am lunch ===== "+lunch );

                if (uname.equals(uname1)) {
                    pass = cursor.getString(3);

                    break;
                }
            }
            while (cursor.moveToNext());

        }

        //   act(String name, String email, String uname, String pass)
        Contact c1 = new Contact(name,email,uname,pass,bstatus,lstatus,dstatus,bf,lunch,dinner,secret);


      //  Integer x = c1.getLunchFlag();
      //  String x1 =Integer.toString(x);

      //  System.out.println("asasasasasaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAAAA      "+x1);

        ArrayList <Object> list = new ArrayList<Object>();

        Object k = new Object();
        k = (Object)pass;
        list.add(k);
        k = (Object)c1;
       /* Contact c2 = new Contact();
        c2 = (Contact)k;
        System.out.println("asasasasasaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAAAA      "+c2.getLunchFlag());

       */
        list.add(k);
    return  list;
    }


 /*   public String getPass(String uname, String secret){

        String n = uname;

        String secretp = secret;String password = "def";
        String query = "select id , uname from contacts where uname = '"+n+"'";
        Cursor cursor = db.rawQuery(query, null);


        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(1).equals(secretp))
                {
                    password = cursor.getString(0);
                    System.out.println("passs"+password);
                    System.out.println("pass"+password);
                    System.out.println("pass"+password);
                    System.out.println("p"+secretp);
                    System.out.println("p"+secretp);
                    System.out.println("p"+secretp);

                    return password;
                    //    return cursor.getInt(0);
                }
            }while (cursor.moveToNext());
        }

        System.out.println("passs"+password);
        System.out.println("pass"+password);
        System.out.println("pass"+password);
        System.out.println("p"+secretp);
        System.out.println("p"+secretp);
        System.out.println("p"+secretp);

        return password;
    }

*/

    public String getPass(String uname,String secret) {
        db = this.getReadableDatabase();
        String n = uname;
        String query = "select uname , pass , secret from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String id_val = "def";
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(0).equals(uname) &&cursor.getString(2).equals(secret) ) {
                    id_val = cursor.getString(1);
                    return id_val;
                    //    return cursor.getInt(0);
                }
            } while (cursor.moveToNext());
        }
        return id_val;
    }



    public int getId(String uname)
    {
        db = this.getReadableDatabase();
        String n = uname;
        String query = "select id , uname from contacts where uname = '"+n+"'";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        String u = "";
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(1).equals(uname))
                    {
                        id_val = cursor.getInt(0);
                   //    return cursor.getInt(0);
                    }
            }while (cursor.moveToNext());
        }

//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);
//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);

//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);

//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);

//        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + id_val);

        return id_val;
    }

    public int getBfCanteen1(String uname)
    {
        db = this.getReadableDatabase();
        String n = uname;
        String query = "select bfstatus , uname from contacts where uname = '"+n+"'";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        String u = "";
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(1).equals(uname))
                {
                    id_val = cursor.getInt(0);
                    //    return cursor.getInt(0);
                }
            }while (cursor.moveToNext());
        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );
     */

        return id_val;
    }


    public int getDinnerCanteen1(String uname)
    {
        db = this.getReadableDatabase();
        String n = uname;
        String query = "select dinnerstatus , uname from contacts where uname = '"+n+"'";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        String u = "";
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(1).equals(uname))
                {
                    id_val = cursor.getInt(0);
                    //    return cursor.getInt(0);
                }
            }while (cursor.moveToNext());
        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );
     */
        return id_val;
    }

    public int getLunchCanteen1(String uname)
    {
        db = this.getReadableDatabase();
        String n = uname;
        String query = "select lunchstatus , uname from contacts where uname = '"+n+"'";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        String u = "";
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(1).equals(uname))
                {
                    id_val = cursor.getInt(0);
                    //    return cursor.getInt(0);
                }
            }while (cursor.moveToNext());
        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );
     */
        return id_val;
    }


    public int getlunch(String uname)
    {
        db = this.getReadableDatabase();
        String n = uname;
        String query = "select lunch , uname from contacts where uname = '"+n+"'";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        String u = "";
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(1).equals(uname))
                {
                    id_val = cursor.getInt(0);
                //    return cursor.getInt(0);
                }
            }while (cursor.moveToNext());
        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );
     */
        return id_val;
    }



    public int getBf(String uname)
    {
        db = this.getReadableDatabase();
        String n = uname;
        String query = "select bf , uname from contacts where uname = '"+n+"'";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        String u = "";
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(1).equals(uname))
                {
                    id_val = cursor.getInt(0);
                    //    return cursor.getInt(0);
                }
            }while (cursor.moveToNext());
        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

     */
         return id_val;
    }

    public int getDinner(String uname)
    {
        db = this.getReadableDatabase();
        String n = uname;
        String query = "select dinner , uname from contacts where uname = '"+n+"'";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        String u = "";
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(1).equals(uname))
                {
                    id_val = cursor.getInt(0);
                    //    return cursor.getInt(0);
                }
            }while (cursor.moveToNext());
        }

   /*     System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

    */
         return id_val;
    }


   /* public  void ChangeLunchStatus(String usr, int val)
    {

       // this.onCreate(db);
       db = this.getWritableDatabase();

        String word_name = usr;*/

   /*     int va = val;

        String args = usr;
        String query =
                "UPDATE " + DatabaseHelper.TABLE_CANTEEN
                        + " SET "   + DatabaseHelper.COLUMN_LUNCH + "=" + val
                        + " WHERE " + DatabaseHelper.COLUMN_UNAME +"=?";

      */

  // db.rawQuery()
     //  db.rawQuery(query, new String[]{args});


//        String updateQuery ="UPDATE contacts SET lunch = 1 WHERE uname = "+usr;
       // db.rawQuery(updateQuery,null);
      //  db.rawQuery("update")
       // db.rawQuery("update "+ DatabaseHelper.TABLE_NAME +  "set"  Column_= '"+va+ " where " + DatabaseHelper.COLUMN_UNAME + " = \""+word_name+"\"", null);
       // update contacts set lunch =1 where
              // String sql = "UPDATE "+TABLE_NAME +" SET " + ColumnName+ " = '"+newValue+"' WHERE "+Column+ " = "+rowId;
           // String query = "update contacts set lunch=val where uname='"+usr+"'";

      //      db.rawQuery(query, null);

        /*
        http://stackoverflow.com/questions/11563732/change-a-value-in-a-column-in-sqlite
        * */

 //   }


    public  void ChangeLunchStatus1( String usr, int l)
    {
        db = this.getWritableDatabase();
        int Id = getId(usr);
        ContentValues contentValues = new ContentValues();
        contentValues.put("lunchstatus",l);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(Id) });
    }


    public  void ChangeBfStatus1( String usr, int l)
    {
        db = this.getWritableDatabase();
        int Id = getId(usr);
        ContentValues contentValues = new ContentValues();
        contentValues.put("bfstatus",l);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(Id) });
    }

    public  void ChangeDinnerStatus1( String usr, int l)
    {
        db = this.getWritableDatabase();
        int Id = getId(usr);
        ContentValues contentValues = new ContentValues();
        contentValues.put("dinnerstatus",l);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(Id) });
    }


    public  void ChangeLunchStatus( String usr, int l)
    {
        db = this.getWritableDatabase();

        int Id = getId(usr);

  /*      System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();
    //    contentValues.put("id",Id);
        contentValues.put("lunch",l);
     //   contentValues.put("name",name);
      //  contentValues.put("email",email);
      //  contentValues.put("uname",usr);
      //  contentValues.put("pass",pass);
       // contentValues.put("bf",b);
       // contentValues.put("dinner",d);
       // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
       // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(Id) });

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        getlunch(usr);


      //  System.out.println();

    }


    public  void ChangeBfStatus( String usr, int b)
    {
        db = this.getWritableDatabase();


        int Id = getId(usr);

/*        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);

*/
        ContentValues contentValues = new ContentValues();
    //    contentValues.put("id",Id);
    //    contentValues.put("name",name);
    //    contentValues.put("email",email);
    //    contentValues.put("uname",usr);
    //    contentValues.put("pass",pass);
    //    contentValues.put("lunch",l);
    //    contentValues.put("dinner",d);
        contentValues.put("bf",b);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(Id) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        getlunch(usr);


        //  System.out.println();

    }


    public  void ChangeDinnerStatus(String usr,  int d)
    {
        db = this.getWritableDatabase();


        int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
        */
        contentValues.put("dinner",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(Id) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        getlunch(usr);


        //  System.out.println();

    }




    public int getSlot1()
    {
        db = this.getReadableDatabase();
    //    String n = uname;
        String query = "SELECT * FROM canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;

        if (cursor.moveToFirst()) {


            id_val = cursor.getInt(2);

        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

     */
        return id_val;
    }


    public int getSlot2()
    {
        db = this.getReadableDatabase();
        //    String n = uname;
        String query = "SELECT * FROM canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;

        if (cursor.moveToFirst()) {


            id_val = cursor.getInt(3);

        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

     */
        return id_val;
    }

    public int getSlot3()
    {
        db = this.getReadableDatabase();
        //    String n = uname;
        String query = "SELECT * FROM canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;

        if (cursor.moveToFirst()) {


            id_val = cursor.getInt(4);

        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

     */
        return id_val;
    }

    public int getSlot4()
    {
        db = this.getReadableDatabase();
        //    String n = uname;
        String query = "SELECT * FROM canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;

        if (cursor.moveToFirst()) {


            id_val = cursor.getInt(5);

        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

     */
        return id_val;
    }

    public int getBfCanteen()
    {
        db = this.getReadableDatabase();
        //    String n = uname;
        String query = "SELECT * FROM canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;

        if (cursor.moveToFirst()) {


            id_val = cursor.getInt(1);

        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

     */
        return id_val;
    }



    public int getSlot5()
    {
        db = this.getReadableDatabase();
        //    String n = uname;
        String query = "SELECT * FROM canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;

        if (cursor.moveToFirst()) {


            id_val = cursor.getInt(6);

        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

     */
        return id_val;
    }

    public int getSlot6()
    {
        db = this.getReadableDatabase();
        //    String n = uname;
        String query = "SELECT * FROM canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;

        if (cursor.moveToFirst()) {


            id_val = cursor.getInt(7);

        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

     */
        return id_val;
    }



    public int getLunchCanteen()
    {
        db = this.getReadableDatabase();
        //    String n = uname;
        String query = "SELECT * FROM canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;

        if (cursor.moveToFirst()) {


            id_val = cursor.getInt(8);

        }

        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );


        return id_val;
    }


    public int getDinnerCanteen()
    {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM canteen";
        Cursor cursor = db.rawQuery(query, null);
        int id_val =0;
        if (cursor.moveToFirst()) {


            id_val = cursor.getInt(9);

        }

     /*   System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  ");
        System.out.println("I am lunch sasasaaaaaaaaaaaaaaaaaaaaaa :  "+id_val );

     */
        return id_val;
    }



    public  void UpdateLunchCanteen()
    {
        db = this.getWritableDatabase();


   //     int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
      */

     int d = getLunchCanteen();

        d = d+1;

        contentValues.put("lflag",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
  //      getlunch(usr);


        //  System.out.println();

    }


    public  void UpdateBfCanteen()
    {
        db = this.getWritableDatabase();


        //     int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
      */

        int d = getBfCanteen();

        d = d+1;

        contentValues.put("bflag",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        //      getlunch(usr);


        //  System.out.println();

    }



    public  void UpdateSlot1()
    {
        db = this.getWritableDatabase();


        //     int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
      */

        int d = getSlot1();

        d = d+1;

        contentValues.put("slot1",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        //      getlunch(usr);


        //  System.out.println();

    }



    public  void UpdateSlot2()
    {
        db = this.getWritableDatabase();


        //     int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
      */

        int d = getSlot2();

        d = d+1;

        contentValues.put("slot2",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        //      getlunch(usr);


        //  System.out.println();

    }



    public  void UpdateSlot3()
    {
        db = this.getWritableDatabase();


        //     int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
      */

        int d = getSlot3();

        d = d+1;

        contentValues.put("slot3",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        //      getlunch(usr);


        //  System.out.println();

    }


    public  void UpdateSlot4()
    {
        db = this.getWritableDatabase();


        //     int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
      */

        int d = getSlot4();

        d = d+1;

        contentValues.put("slot4",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        //      getlunch(usr);


        //  System.out.println();

    }


    public  void UpdateSlot5()
    {
        db = this.getWritableDatabase();


        //     int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
      */

        int d = getSlot5();

        d = d+1;

        contentValues.put("slot5",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        //      getlunch(usr);


        //  System.out.println();

    }


    public  void UpdateSlot6()
    {
        db = this.getWritableDatabase();


        //     int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
      */

        int d = getSlot6();

        d = d+1;

        contentValues.put("slot6",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        //      getlunch(usr);


        //  System.out.println();

    }



    public  void UpdateDinnerCanteen()
    {
        db = this.getWritableDatabase();


        //     int Id = getId(usr);

    /*  System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
        System.out.println("I am id valueeeeeeeeeeeeeeeeeeeeeeeee " + Id);
*/
        ContentValues contentValues = new ContentValues();

     /*   contentValues.put("id",Id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("uname",usr);
        contentValues.put("pass",pass);
        contentValues.put("bf",b);
        contentValues.put("lunch",l);
      */

        int d = getDinnerCanteen();

        d = d+1;

        contentValues.put("dflag",d);

        // PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) }

        // https://www.tutorialspoint.com/android/android_sqlite_database.htm
        // http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
        // String q = "update contacts set lunch = val where id = Id";
        //db.rawQuery(q,null);

        db.update("canteen", contentValues, "id = ? ", new String[] { Integer.toString(1) } );

       /* db.update(TABLE_CREATE, contentValues, DatabaseHelper.COLUMN_LUNCH + " = ?",
                new String[] { String.valueOf(l) });
*/
        //      getlunch(usr);


        //  System.out.println();

    }



    /*

    public boolean updateData(String name,String email,String uName, String pwd, int bf,int l , int d ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        int id = getId(uName);
        contentValues.put(COLUMN_ID,id);
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_EMAIL,email);
        contentValues.put(COLUMN_UNAME,uName);
        contentValues.put(COLUMN_PASS,pwd);
        contentValues.put(COLUMN_BF,bf);
        contentValues.put(COLUMN_LUNCH,l);
        contentValues.put(COLUMN_DINNER,d);

        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
