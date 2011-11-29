package com.wbh.loewe.shoppinglist.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ShoppingListDatabaseHelper extends SQLiteOpenHelper {

	private static ShoppingListDatabaseHelper mInstance;
	private static SQLiteDatabase db;
	
	private static final String DATABASE_NAME = "shoppinglistdata";
	private static final int DATABASE_VERSION = 1;

	public static ShoppingListDatabaseHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ShoppingListDatabaseHelper(context.getApplicationContext());
            db = mInstance.getWritableDatabase();
        } 
        return mInstance;
    }
	
	public ShoppingListDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
		
	// Method is called during creation of the database
	@Override
	public void onCreate(SQLiteDatabase database) {
		ShoppingListDatabase.onCreate(database);
	}

	@Override
	protected void finalize() throws Throwable {
		if (db != null) {
			db.close();
		}
		super.finalize();
	}


	// Method is called during an upgrade of the database,
	// e.g. if you increase the database version
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		ShoppingListDatabase.onUpgrade(database, oldVersion, newVersion);
	}
	
	/** * Return a Cursor over the list of all DataSets from table of the parameter * * @return Cursor over all notes */
	public Cursor fetchAllDataSets(String table) {
		return db.rawQuery("SELECT * FROM "+ table, new String [] {});
	}
}
