package com.example.mattias.movietest.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbAdapter {
    DbHelper myhelper;

    public DbAdapter(Context context) {
        myhelper = new DbHelper(context);
    }

    public long insertData(String name, long uid) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.NAME, name);
        contentValues.put(DbHelper.UID, uid);

        long id = dbb.insert(DbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getData() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {DbHelper.UID, DbHelper.NAME};
        Cursor cursor =db.query(DbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            String name = cursor.getString(cursor.getColumnIndex(DbHelper.NAME));
            buffer.append(name + "\n");
        }
        return buffer.toString();
    }

    public boolean exists(long id) {
        SQLiteDatabase db = myhelper.getReadableDatabase();
        String[] columns = {DbHelper.UID};
        String whereClause = "id = ?";
        String[] whereArgs = new String[] { ""+id };
        String idString = ""+id;
        Cursor c = db.query(DbHelper.TABLE_NAME, columns, whereClause, whereArgs, null, null, null);

        if (c.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int delete(String uname) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={uname};

        int count = db.delete(DbHelper.TABLE_NAME ,DbHelper.NAME+" = ?",whereArgs);
        return  count;
    }

    public int delete(long uid) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs = {""+uid};
        int count = db.delete(DbHelper.TABLE_NAME, DbHelper.UID + " = ?", whereArgs);
        return count;
    }

    public int updateName(String oldName , String newName) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.NAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(DbHelper.TABLE_NAME,contentValues, DbHelper.NAME+" = ?",whereArgs );
        return count;
    }

    static class DbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "favorites";
        private static final String TABLE_NAME = "favorite_movies";
        private static final int DATABASE_Version = 1;
        private static final String UID="id";
        private static final String NAME = "name";

        private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME +
                "("+ UID +" LONG PRIMARY KEY, " + NAME + " VARCHAR(255) );";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Log.d("DbAdapter", "onCreate error " + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Log.d("DbAdapter", "onUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Log.d("DbAdapter", "onUpgrade error " + e);
            }
        }
    }
}