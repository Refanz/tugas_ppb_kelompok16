package com.kelompok16.tugasppbkelompok16;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "login.db";

    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("CREATE TABLE tb_users (id_user TEXT PRIMARY KEY, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("DROP TABLE IF EXISTS tb_users");
    }

    public boolean insertData(String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("password", password);
        long result = myDB.insert("tb_users", null, cv);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean checkEmail(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor c = myDB.rawQuery("SELECT * FROM tb_users WHERE email = ?", new String[] {email});
        if(c.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkEmailPassword(String email, String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor c = myDb.rawQuery("SELECT * FROM tb_users WHERE email = ? AND password = ?", new String[] {email,password});
        if(c.getCount() > 0)
            return true;
        else
            return  false;
    }
}
