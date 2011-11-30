package com.wbh.loewe.shoppinglist.dbtest;

import android.app.Application;

import com.wbh.loewe.shoppinglist.database.ShoppingListDatabaseAdapter;

public class ShoppingListDatabaseApplication extends Application {
	
	private ShoppingListDatabaseAdapter mDBAdapter;
	
	@Override
    public void onCreate() {
        super.onCreate();
        mDBAdapter = new ShoppingListDatabaseAdapter(getApplicationContext());
        mDBAdapter.open();
    }

	@Override
	public void onTerminate() {
		if (mDBAdapter != null) {
			mDBAdapter.close();
		}
		super.onTerminate();
	}
	
	public ShoppingListDatabaseAdapter getDBAdapter() {
		return mDBAdapter;
	}
}
