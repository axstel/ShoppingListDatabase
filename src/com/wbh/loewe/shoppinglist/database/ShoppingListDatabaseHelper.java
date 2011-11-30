package com.wbh.loewe.shoppinglist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ShoppingListDatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "shoppinglistdata";
	private static final int DATABASE_VERSION = 1;

	public ShoppingListDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	// Method is called during creation of the database
	@Override
	public void onCreate(SQLiteDatabase database) {
		ShoppingListDatabase.onCreate(database);
	}

	// Method is called during an upgrade of the database,
	// e.g. if you increase the database version
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		ShoppingListDatabase.onUpgrade(database, oldVersion, newVersion);
	}
}
