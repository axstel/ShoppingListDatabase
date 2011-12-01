package com.wbh.loewe.shoppinglist.database;

import java.io.IOException;

import android.content.ContentValues;
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
	
	/* Return a Cursor over the list of all DataSets from table of the parameter */
	public Cursor fetchAllDataSets(String table) {
		return db.rawQuery("SELECT * FROM "+ table, new String [] {});
	}
	
	/* Create a new article and return the rowid of new dataset */
	public long createArticle(String aName, int aCategory, int aQuantityUnit) {
		ContentValues values = new ContentValues();
		values.put(ShoppingListDatabase.FIELD_NAME_NAME, aName);
		values.put(ShoppingListDatabase.FIELD_NAME_IDCATEGORY, aCategory);
		values.put(ShoppingListDatabase.FIELD_NAME_IDQUANTITYUNIT, aQuantityUnit);
		
		return db.insert(ShoppingListDatabase.TABLE_NAME_ARTICLE, null, values);
	}
	
	/* update article and return if succeed or not */
	public boolean  updateArticle(long aID, String aName, int aCategory, int aQuantityUnit) {
		ContentValues values = new ContentValues();
		values.put(ShoppingListDatabase.FIELD_NAME_NAME, aName);
		values.put(ShoppingListDatabase.FIELD_NAME_IDCATEGORY, aCategory);
		values.put(ShoppingListDatabase.FIELD_NAME_IDQUANTITYUNIT, aQuantityUnit);
		
		return db.update(ShoppingListDatabase.TABLE_NAME_ARTICLE, values, ShoppingListDatabase.FIELD_NAME_ID + "=" + aID, null) > 0;
	} 
	
	/* delete article and return if succeed or not */
	public boolean deleteArticle(long aID) {
		return db.delete(ShoppingListDatabase.TABLE_NAME_ARTICLE, ShoppingListDatabase.FIELD_NAME_ID + "=" + aID, null) > 0;
	}
	
	/* Create a new shoppinglist and return the rowid of new dataset */
	public long createShoppingList(String aName) {
		ContentValues values = new ContentValues();
		values.put(ShoppingListDatabase.FIELD_NAME_NAME, aName);
		
		return db.insert(ShoppingListDatabase.TABLE_NAME_SHOPPPINGLIST, null, values);
	} 
	
	/* update shoppinglist and return if succeed or not */
	public boolean  updateShoppingList(long aID, String aName) {
		ContentValues values = new ContentValues();
		values.put(ShoppingListDatabase.FIELD_NAME_NAME, aName);
		
		return db.update(ShoppingListDatabase.TABLE_NAME_SHOPPPINGLIST, values, ShoppingListDatabase.FIELD_NAME_ID + "=" + aID, null) > 0;
	} 	
}
