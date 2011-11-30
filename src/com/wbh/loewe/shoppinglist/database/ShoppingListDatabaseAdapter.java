package com.wbh.loewe.shoppinglist.database;

import java.io.IOException;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ShoppingListDatabaseAdapter {

	private Context context;
	private SQLiteDatabase db;
	private ShoppingListDatabaseHelper dbHelper;
	
	public ShoppingListDatabaseAdapter(Context context) {
		this.context = context;
	}

	public ShoppingListDatabaseAdapter open() throws SQLException {
		dbHelper = new ShoppingListDatabaseHelper(context);
		try {
			dbHelper.createDataBase();
			db = dbHelper.getWritableDatabase();
		} catch (IOException ioe) {
	 		throw new Error("Unable to create database");
	 	}
		return this;
	}

	public void close() {
		dbHelper.close();
	}
	
	/** * Return a Cursor over the list of all DataSets from table of the parameter * * @return Cursor over all notes */
	public Cursor fetchAllDataSets(String table) {
		return db.rawQuery("SELECT * FROM "+ table, new String [] {});
	}
}
