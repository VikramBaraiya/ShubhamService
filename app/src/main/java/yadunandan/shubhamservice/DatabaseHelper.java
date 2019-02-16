package yadunandan.shubhamservice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.RecyclerView;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB ="Service";
    public static final String TABLE="ServiceInfo";
    static int version =1;
    String[] data;
    String stat="pending";
    public static boolean flag=true;

    public DatabaseHelper( Context context,String[] args) {
        super(context, DB, null, version);
        data=args;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE TEXT,ADDRESS TEXT, REASON TEXT, TYPE TEXT, STATUS TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertData()
    {
        SQLiteDatabase db=this.getWritableDatabase();

        //SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("NAME",data[0]);
        cv.put("MOBILE",data[1]);
        cv.put("ADDRESS",data[2]);
        cv.put("REASON",data[3]);
        cv.put("TYPE",data[4]);
        cv.put("STATUS",stat);
        long result=db.insert(TABLE,null,cv);
        if(result==-1)
        {
            return false;
        }
        else {


            return true;

        }



    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor data=db.rawQuery("select * from "+TABLE,null);
       // RecyclerView rvv;
        //rvv=(RecyclerView)
        return data;



    }
}
