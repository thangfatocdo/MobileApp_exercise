package com.example.subjectstudent_207ct40431;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class quanlymonhoc extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.example.subjectstudent_207ct40431/databases/";
    private static String DB_NAME = "quanlymonhoc.db";
    private static final int DATABASE_VERSION = 1;

    private static String TABLE_NAME = "tablemonhoc";
    private static String KEY_ID = "_id";
    private static String KEY_HO = "Hosv";
    private static String KEY_TEN ="Tensv";
    private static String KEY_CLASS="Lop";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public quanlymonhoc(@Nullable Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        myContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openDataBase() throws SQLException {
        //Open database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch (SQLException e){
            //databse chua ton tai
        }
        if (checkDB != null)
            checkDB.close();
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        //mo db trogn thu muc asset nhu mot input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        //duong dan den db se tao
        String outFileName = DB_PATH + DB_NAME;

        //mo db giong nhuw mot output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //truyen du lieu tu inputFile sang outfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0){
            myOutput.write(buffer, 0, length);
        }

        //Dong
        myOutput.flush();
        myOutput.close();;
        myInput.close();
    }

    public void createDataBase() throws IOException{
        boolean dbExist = checkDataBase(); //kiem tra db
        if ( (dbExist)){
            //Khong lam gi ca db da co roi
        }
        else {
            this.getReadableDatabase();
            try{
                copyDataBase();//chep du lieu
            }
            catch (IOException e){
                throw new Error("Error copying database");
            }
        }
    }

    public Cursor laytatcacauhoi(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor contro = db.rawQuery("select * from "+TABLE_NAME, null);
        return contro;
    }
}
