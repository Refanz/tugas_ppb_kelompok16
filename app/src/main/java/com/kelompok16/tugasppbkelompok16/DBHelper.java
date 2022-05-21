package com.kelompok16.tugasppbkelompok16;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "absensi.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("CREATE TABLE tb_users (email TEXT PRIMARY KEY, password TEXT)");
        myDB.execSQL("CREATE TABLE tb_absen (id TEXT PRIMARY KEY, nim TEXT, nama TEXT, tanggal TEXT, jam TEXT, status TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("DROP TABLE IF EXISTS tb_users");
        myDB.execSQL("DROP TABLE IF EXISTS tb_absen");
    }

    /* Akun */

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
        if(c.getCount() > 0) {
            c.close();
            return true;
        }else {
            c.close();
            return false;
        }
    }

    public boolean checkEmailPassword(String email, String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor c = myDb.rawQuery("SELECT * FROM tb_users WHERE email = ? AND password = ?", new String[] {email,password});
        if(c.getCount() > 0) {
            c.close();
            return true;
        }else {
            c.close();
            return false;
        }
    }

    /* Data Absensi */

    public boolean insertDataAbsensi(String id, String nim, String nama, String tanggal, String jam, String status){
        if(checkDataAbsen(nim, tanggal)){
            return false;
        }else{
            SQLiteDatabase myDB = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("id", id);
            cv.put("nim", nim);
            cv.put("nama", nama);
            cv.put("tanggal", tanggal);
            cv.put("jam", jam);
            cv.put("status", status);
            long result = myDB.insert("tb_absen", null, cv);
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }
    }

    public boolean checkDataAbsen(String nim, String tanggal){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor c = myDB.rawQuery("SELECT nim FROM tb_absen WHERE nim = ? AND tanggal = ?", new String[] {nim, tanggal});
        if(c.getCount() > 0){
            c.close();
            return true;
        }
        c.close();
        return false;
    }

    public Cursor showDataAbsenRecyclerView(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String[] columns = {"id", "nim", "nama", "tanggal", "jam", "status"};
        return myDB.query("tb_absen", columns, null, null, null, null, null);
    }

    public void deleteAllTableAbsen(){
        SQLiteDatabase myDb = this.getWritableDatabase();
        myDb.execSQL("DELETE FROM tb_absen");
    }
}
